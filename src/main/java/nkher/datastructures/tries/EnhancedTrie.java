package nkher.datastructures.tries;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import nkher.Interfaces.MyTrie;
import nkher.datastructures.lists.DynamicArray;

public class EnhancedTrie implements MyTrie {
	
	public static final int COUNT_ONE = 1;
	
	private HashMap<String, Integer> dictionary;
	private TrieNode root;
	private int size; 
	
	private class TrieNode {
		char data; // this will contain the data
		int count; // contains the count of the word
		boolean leaf;
		private HashMap<Character, TrieNode> children;
		
		public TrieNode(char data, int count) {
			this.data = data;
			this.count = count;
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
		public void addChild(char ch) {
			children.put(ch, new TrieNode(ch, COUNT_ONE));
		}
		
		public void incrementChildCount(char ch) {
			children.get(ch).incrementCount();
			children.put(ch, children.get(ch));
		}
		
		public void decrementChildCount(char ch) {
			children.get(ch).decrementCount();
			children.put(ch, children.get(ch));
		}
		
		public boolean childEligibleForDeletion(char ch) {
			return (children.get(ch).count == 0);
		}
		
		public void removeChild(char ch) {
			children.remove(ch);
		}
	}
	
	public EnhancedTrie() {
		root = new TrieNode('$', 0); // place holder value for the root
		dictionary = new HashMap<>();
	}
	
	/** SIMPLE METHODS TO MANIPULATE THE DICTIONARY */
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
	
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return (this.size == 0);
	}

	@Override
	public void insert(String key) {
		checkValidKey(key);
		size++;
		insertionUtil(key, root, 0);
		addKeyToDict(key);
	}
	
	/*** TRIE RELATED METHODS */
	
	/***
	 * A helper to insert the current key at the correct spot.
	 * @param key
	 * @param root
	 */
	private void insertionUtil(String key, TrieNode node, int level) {
		char ch;
		int n = key.length();
		for (level=0; level<n; level++) {
			ch = key.charAt(level); // get the character at that level
			if (!node.children.containsKey(ch)) {
				node.addChild(ch); // adding a child with count as 1
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
	private boolean containsUtil(String key, TrieNode node, int level) {
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
		TrieNode lastCharNode = getLastCharTrieNode(prefixKey, root, 0);
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
	private TrieNode getLastCharTrieNode(String prefixKey, TrieNode node, int level) {
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
	private List<String> prefixSearchDFS(TrieNode node, List<String> list, StringBuilder sb) {
		for (Character child : node.children.keySet()) {
			sb.append(child);
			TrieNode childNode = node.children.get(child);
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

	@Override
	public void buildTrie(List<String> keys) {
		checkValidKeysList(keys);
		for (String key : keys) {
			insert(key);
		}
	}
	
	public void buildTrie(DynamicArray<String> keys) {
		if (null == keys) { throw new NullPointerException("Passed parameter is null !"); }
		if (keys.size() == 0) { throw new InvalidParameterException("List passed is empty."); }
		for (String key : keys) {
			insert(key);
		}
	}
	
	private void checkValidKey(String key) {
		if (null == key) { throw new NullPointerException("Passed key is null ! Please check."); }
		if (key.length() == 0) { 
			System.out.println("Inserting paramter with 0 length. Nothing inserted. Trie not modified."); 
		}
		if (null == root) { 
			System.out.println("Please initialize the trie and then start adding.");
		};
	}
	
	private void checkValidKeysList(List<String> keys) {
		if (null == keys) { throw new NullPointerException("Passed parameter is null !"); }
		if (keys.size() == 0) { throw new InvalidParameterException("List passed is empty."); }
	}
	
	/***
	 * 
	 * @return
	 */
	public String toString() {
		if (isEmpty()) {
			return "{ }";
		}
		StringBuilder sb = new StringBuilder();
		
		return null;
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
		return removalUtil(key, root, 0);
	}
	
	/***
	 * 
	 * @param key
	 * @param node
	 * @param level
	 */
	private boolean removalUtil(String key, TrieNode node, int level) {
		char ch;
		int n = key.length();
		for (level=0; level<n; level++) {
			ch = key.charAt(level); // get the character at that level
			node.decrementChildCount(ch);
			if (node.childEligibleForDeletion(ch)) {
				node.removeChild(ch);
				break;
			}
			node = node.children.get(ch);
		}
		if (!dictionary.containsKey(key) && key.charAt(n-1) == node.data) { // if this is the last character of the key passed, means we never breaked out
			node.unsetLeaf();
		}
		return true;
	}

	@Override
	public void removePrefixKeys(String prefixKey) {
		List<String> keys = prefixSearch(prefixKey);
		for (String key : keys) {
			removeKeyCompletely(key);
		}
	}
	
	@Override
	public boolean removeKeyCompletely(String key) {
		checkValidKey(key);
		boolean found = false;
		while (contains(key)) {
			removeKey(key);
			found = true;
		}
		return found;
	}

	@Override
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
