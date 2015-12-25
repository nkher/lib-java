package nkher.datastructures.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import nkher.datastructures.lists.DynamicArray;

/***
 * This is an enhanced form of the simple HashMap where we have a variable in the EnhancedTrieNode
 * to maintain the counts for each character at each level/position. This trie works like a 
 * dictionary with word frequencies but is efficient when searching for prefix queries as 
 * compared to a normal HashMap. </br></br>
 * 
 *
 * Use of the internal HashMap : </br>
 * The HashMap helps us in knowing when to remove a particular key from the
 * trie completely. for example when we have jack inserted 4 times and jacket
 * once, we have our leafs set for the nodes 'k' and 't' in jack and jacket 
 * respectively. When removing jack from the trie we make use of the HashMap
 * that stores the keys and their frequency counts in it. </br></br>
 * 
 * When trying to remove the key 'jacket' form the trie,
 * the HashMap helps us to know that only the last 2 nodes from 'jacket' are to be
 * removed that are 'e' and 't'. We should not do any thing to the key jack other then
 * decrementing its character counts from the trie. </br></br>
 * 
 * NOTE : These are not implemented as Key(String) and  Value stores as the TernarySearch Tries as we may fill up the heap
 * faster. </br>
 * 
 * @author nameshkher
 *
 */

public class EnhancedTrie extends Trie {
		
	private HashMap<String, Integer> dictionary;
	private EnhancedTrieNode root;
	
	/***
	 * This represents the Internal EnhancedTrieNode for this Trie. It has an
	 * additional parameter called count which stores the count for that
	 * particular character in that particular position/level of the trie.
	 * 
	 * @author nameshkher
	 *
	 */
	private class EnhancedTrieNode {
		private char data; // this will contain the data
		private int count; // contains the count of the word
		private boolean leaf;
		private char parentData;
		private HashMap<Character, EnhancedTrieNode> children;
		
		public EnhancedTrieNode(char data, int count, char parentData) {
			this.data = data;
			this.count = count;
			this.parentData = parentData;
			children = new HashMap<>();
		}
		
		public void setAsLeaf() {
			this.leaf = true;
		}
		
		public void unsetLeaf() {
			this.leaf = false;
		}
		
		public boolean isLeaf() {
			return (leaf == true);
		}
		
		public void incrementCount() {
			this.count = this.count + COUNT_ONE;
		}
		
		public void decrementCount() {
			this.count = this.count - COUNT_ONE;
		}
		
		// adds a child node to the hashmap with count as 1
		public void addChild(char ch, char parentData) {
			children.put(ch, new EnhancedTrieNode(ch, COUNT_ONE, parentData));
		}
		
		public void incrementChildCount(char ch) {
			children.get(ch).incrementCount();
			children.put(ch, children.get(ch));
		}
		
		public void decrementChildCount(char ch) {
			children.get(ch).decrementCount();
			children.put(ch, children.get(ch));
		}

		
		public void removeChild(char ch) {
			children.remove(ch);
		}
		
		public String toString() {
			return "(" + data + "," + parentData + "," + leaf + "," + count + ")";
		}
		
		public boolean hasChildren() {
			return (children.size() > 0);
		}
	}
	
	public EnhancedTrie() {
		root = new EnhancedTrieNode('$', 0, 'n'); // place holder value for the root
		dictionary = new HashMap<>();
	}
	
	/*** SIMPLE METHODS TO MANIPULATE THE DICTIONARY */
	
	private void addKeyToDict(String key) {
		if (!dictionary.containsKey(key)) {
			dictionary.put(key, COUNT_ONE);
			return;
		}
		dictionary.put(key, dictionary.get(key)+1);
	}
	
	private void removeKeyFromDict(String key) {
		if (!dictionary.containsKey(key)) { return; }
		else if (dictionary.get(key) == 1) {
			dictionary.remove(key);
		}
		else dictionary.put(key, dictionary.get(key)-1);
	}
	
	/*** TRIE RELATED METHODS */

	@Override
	public void insert(String key) {
		checkValidKey(key);
		size++;
		insertionUtil(key, root, 0);
		addKeyToDict(key);
	}
	
	/***
	 * A helper to insert the current key at the correct spot.
	 * @param key
	 * @param root
	 */
	private void insertionUtil(String key, EnhancedTrieNode node, int level) {
		char ch;
		int n = key.length();
		for (level=0; level<n; level++) {
			ch = key.charAt(level); // get the character at that level
			if (!node.children.containsKey(ch)) {
				node.addChild(ch, node.data); // adding a child with count as 1
			}
			else {
				node.incrementChildCount(ch); // incrementing the child count by 1
			}
			// go to the child node
			node = node.children.get(ch);
		}
		node.setAsLeaf(); // setting the last inserted node as the leaf
	}

	/** Here we can also find the key in the dictionary directly */
	@Override
	public boolean contains(String key) {
		checkValidKey(key);
		return containsUtil(key, root, 0);
	}
	
	/***
	 * A helper method that checks if a key is present within the trie.
	 * Follows simple trie traversal for checking which is similar to the insertion strategy.
	 * It returns false if at any point a node is not found in the tree.
	 * @param key
	 * @param node
	 * @param level
	 * @return
	 */
	private boolean containsUtil(String key, EnhancedTrieNode node, int level) {
		char ch;
		int n = key.length();
		for (level=0; level<n; level++) {
			ch = key.charAt(level); // get the character at that level
			if (!node.children.containsKey(ch)) {
				return false;
			}
			node = node.children.get(ch); // go to the child node
		}
		return true;
	}
	
	/***
	 * A utility method that encapsulates the result in a dynamic array and returns the DynamicArray.
	 * It internally calls the prefixSearch(prefixKey) method.
	 * 
	 * @param prefixKey
	 * @return
	 */
	public DynamicArray<String> prefixSearchDArray(String prefixKey) {
		checkValidKey(prefixKey);
		List<String> result = prefixSearch(prefixKey);
		return new DynamicArray<>(result);
	}

	@Override
	public List<String> prefixSearch(String prefixKey) {
		checkValidKey(prefixKey);
		List<String> result = new ArrayList<String>();
		// get the key associated to the last character
		EnhancedTrieNode lastCharNode = getLastCharEnhancedTrieNode(prefixKey, root, 0);
		if (null == lastCharNode) {
			return result;
		}
		if (lastCharNode.isLeaf()) { 
			result.add(prefixKey);
		}
		StringBuilder sb = new StringBuilder(prefixKey);
		return prefixSearchDFS(lastCharNode, result, sb); // performs the dfs
	}
	
	/***
	 * This is a very important helper method used for the prefix search functionality. 
	 * This method returns the trienode associated to the last character of the prefix key. Once 
	 * we have that, we can go ahead and perform the dfs using the prefixSearchDFS() method.
	 * 
	 * @param prefixKey
	 * @return
	 */
	private EnhancedTrieNode getLastCharEnhancedTrieNode(String prefixKey, EnhancedTrieNode node, int level) {
		char ch;
		int n = prefixKey.length();
		for (level=0; level<n; level++) {
			ch = prefixKey.charAt(level); // get the character at that level
			if (!node.children.containsKey(ch)) {
				return null;
			}
			node = node.children.get(ch);
		}
		return node;
	}
	
	/***
	 * A helper method that performs the dfs to get all the keys with the same prefix.
	 * @return
	 */
	private List<String> prefixSearchDFS(EnhancedTrieNode node, List<String> list, StringBuilder sb) {
		for (Character child : node.children.keySet()) {
			sb.append(child);
			EnhancedTrieNode childNode = node.children.get(child);
			if (childNode.isLeaf()) {
				list.add(sb.toString());
			}
			prefixSearchDFS(childNode, list, sb);
			sb.deleteCharAt(sb.length()-1); // delete the last char
		}
		return list;
	}
	
	@Override
	public boolean containsPrefix(String prefixKey) {
		checkValidKey(prefixKey);
		return containsUtil(prefixKey, root, 0);
	}

	/***
	 * 
	 * @return
	 */
	public String toString() {
		if (isEmpty()) { return "{ }"; }
		int level = 0;
		
		System.out.println("Printing node in (data, parent, isleafnode, count) form.");
		StringBuilder sb = new StringBuilder("{ ");
		Queue<EnhancedTrieNode> parentLevel = new LinkedList<>();
		Queue<EnhancedTrieNode> currentLevel = new LinkedList<>();
		
		// Adding the root to the parent level
		currentLevel.add(root);
		
		EnhancedTrieNode child;
		
		while (!currentLevel.isEmpty()) {
			
			sb.append("level " + level + " : ");
			
			parentLevel = new LinkedList<>(currentLevel);
			currentLevel = new LinkedList<>();
			// iterating over all the nodes in the parent level and keep adding to the child level, simultaneously append to StringBuffer
			for (EnhancedTrieNode parent : parentLevel) {
				sb.append(parent.toString());
				// add the parents children to the childlevel
				if (parent.hasChildren()) {
					for (char ch : parent.children.keySet()) {
						child = parent.children.get(ch);
						currentLevel.add(child);
					}
				}
			}
			sb.append("\n");
			level++;
		} 		
		
		sb.append(" }");
		return sb.toString();
	}
	
	/***
	 * Prints all the keys/words in the trie.
	 * @return
	 */
	public String allKeys() {
		if (isEmpty()) {
			return "{ }";
		}
		return dictionary.toString();
	}
	
	/***
	 * Removes a specific key from the trie equal to count number of times. The function returns 
	 * an integer variable which indicates the number of times it removed the the key from the trie.
	 * 
	 * @param key
	 * @param count - number of times the key is removed form the trie {@code int}
	 */
	public int removeKey(String key, int count) {
		int i=0;
		while (i < count && removeKey(key)) {
			i++;
		}
		return i;
	}

	@Override
	public boolean removeKey(String key) {
		checkValidKey(key);
		if (!contains(key)) return false;
		size--;
		removeKeyFromDict(key);
		boolean unsetFlag = (!dictionary.containsKey(key)) ? true : false;
		System.out.println("Unset Flag " + key + " -> " + unsetFlag);
		return removalUtil(key, root, 0, key.length(), unsetFlag);
	}
	
	/***
	 * 
	 * @param key
	 * @param node
	 * @param level
	 */
	private boolean removalUtil(String key, EnhancedTrieNode parent, int position, int n, boolean unsetFlag) {
		
		if (position >= n) return true;
		char curr = key.charAt(position);
		
		parent.decrementChildCount(curr); // decrement the child count
		EnhancedTrieNode child = parent.children.get(curr); // get the child
		
		if (position < n-1) { // if this is not the last keep going forward
			removalUtil(key, child, position+1, n, unsetFlag);
		}
		// do the removal here
		if (!child.hasChildren()) {
			parent.removeChild(curr);
		}
		if (position == n-1 && unsetFlag) {
			child.unsetLeaf();
		}
		
		return true;
	}

	/***
	 * The trie can have a count associated to a single character and also a count for the whole String key. 
	 * Hence we can add the same key multiple times. This remove method, removes the key with the given prefix
	 * from the trie by decrementing its count in the trie. If you want to completely remove the key then the method
	 * removePrefixKeyCompletely() would do that. If the key is not at all present in the trie
	 * then the method returns 1. If the key is not at all present in the trie
	 * then the method returns {@code false}. </br></br></br>
	 * 
	 * @param prefixKey
	 * @return
	 */
	public void removePrefixKeys(String prefixKey) {
		List<String> keys = prefixSearch(prefixKey);
		for (String key : keys) {
			removeKeyCompletely(key);
		}
	}
	
	/***
	 * Removes the key completely from the trie. If the key count is greater than 1
	 * then it removes all the copies of the key. If the key is not at all present in the trie
	 * then the method returns {@code false}. </br></br>
	 *  
	 * @param key
	 * @return
	 */
	public boolean removeKeyCompletely(String key) {
		checkValidKey(key);
		boolean found = false;
		while (contains(key)) {
			removeKey(key);
			found = true;
		}
		return found;
	}
	
	/***
	 * Removes all the keys that have a prefix key equal to the passed prefix key completely from the trie. 
	 * For all the keys with the same prefix : if the key count is greater than 1, all the copies of the key are removed. 
	 * If the key is not at all present in the trie. then the method returns {@code false}. </br></br>
	 *  
	 * @param key
	 * @return
	 */
	public void removePrefixKeysCompletely(String prefixKey) {
		List<String> keys = prefixSearch(prefixKey);
		for (String key : keys) {
			removeKeyCompletely(key);
		}
	}
	
	/***
	 * Removes a list of keys from the trie. This is not hard removal of the keys. It removes the keys 
	 * by decrementing the count of the keys in the trie.
	 * @param keys
	 */
	public void removeListOfKeys(List<String> keys) {
		checkValidKeysList(keys);
		for (String key : keys) {
			removeKey(key);
		}
	}
}
