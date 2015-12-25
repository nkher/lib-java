package nkher.datastructures.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import nkher.datastructures.lists.DynamicArray;

/***
 * This class demonstrates the simple basic data structure of a Trie. The Trie is Dynamic in nature
 * and hence supports additions and deletions within it. The TrieNode is basic
 * element or building block of the Trie which contains a character, a boolean value to identify it
 * it is a leaf and a HashMap for storing its children. It exposes a useful API which helps us in 
 * performing different functions like insertion, deletion and searching in try with various forms to it.
 * It support prefix search queries for which tries are built. </br></br>
 * 
 * NOTE : These are not implemented as Key(String) and  Value stores as the TernarySearch Tries as we may fill up the heap
 * faster. </br>
 * 
 * @author nameshkher
 *
 */
public class BasicTrie extends Trie {
		
	private BasicTrieNode root;
	private HashSet<String> dictionary;
	
	private class BasicTrieNode {
		private char data; // this will contain the data
		private boolean leaf;
		private char parentData; 
		private HashMap<Character, BasicTrieNode> children;
		
		public BasicTrieNode(char data, char parent) {
			this.data = data;
			this.parentData = parent;
			children = new HashMap<>();
		}
		
		public void setAsLeaf() {
			this.leaf = true;
		}
		
		public boolean isLeaf() {
			return (leaf == true);
		}
		
		// adds a child node to the HashMap with count as 1
		public void addChild(char ch, char parentData) {
			children.put(ch, new BasicTrieNode(ch, parentData));
		}
		
		public void removeChild(char ch) {
			children.remove(ch);
		}
		
		public String toString() {
			return "(" + data + "," + parentData + "," + leaf + ")";
		}
		
		public boolean hasChildren() {
			return (children.size() > 0);
		}
	}
	
	public BasicTrie() {
		root = new BasicTrieNode('$', 'n'); // place holder value for the root
		dictionary = new HashSet<>();
	}
	
	/*** TRIE RELATED METHODS */

	@Override
	public void insert(String key) {
		checkValidKey(key);
		if (dictionary.contains(key)) return;
		size++;
		insertionUtil(key, root, 0);
		dictionary.add(key);
	}
	
	/***
	 * A helper to insert the current key at the correct spot.
	 * @param key
	 * @param root
	 */
	private void insertionUtil(String key, BasicTrieNode node, int level) {
		char ch;
		int n = key.length();
		for (level=0; level<n; level++) {
			ch = key.charAt(level); // get the character at that level
			if (!node.children.containsKey(ch)) {
				node.addChild(ch, node.data); // adding a child with count as 1
			}
			// crawl to the child node
			node = node.children.get(ch);
		}
		node.setAsLeaf(); // set the last inserted node as the leaf
	}

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
	private boolean containsUtil(String key, BasicTrieNode node, int level) {
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
		BasicTrieNode lastCharNode = getLastCharEnhancedTrieNode(prefixKey, root, 0);
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
	private BasicTrieNode getLastCharEnhancedTrieNode(String prefixKey, BasicTrieNode node, int level) {
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
	private List<String> prefixSearchDFS(BasicTrieNode node, List<String> list, StringBuilder sb) {
		for (Character child : node.children.keySet()) {
			sb.append(child);
			BasicTrieNode childNode = node.children.get(child);
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
	public boolean removeKey(String key) {
		checkValidKey(key);
		if (!contains(key)) return false;
		size--;
		dictionary.remove(key);
		return removalUtil(key, root, 0, key.length());
	}
	
	/***
	 * A recursive deletion function for the trie.
	 * 
	 * @param key
	 * @param node
	 * @param level
	 */
	private boolean removalUtil(String key, BasicTrieNode parent, int position, int n) {

		if (position >= n) return true;
		char curr = key.charAt(position);
		BasicTrieNode child = parent.children.get(curr); // get the child
		
		if (position < n-1) { // if this is not the last keep going forward
			removalUtil(key, child, position+1, n);
		}
		// do the removal here
		if (!child.hasChildren()) {
			parent.removeChild(curr);
		}
		
		return true;
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
	 * Using a BFS for printing the trie.
	 */
	public String toString() {
		if (isEmpty()) { return "{ }"; }
		int level = 0;
		
		System.out.println("Printing node in (data, parent, isleafnode) form.");
		StringBuilder sb = new StringBuilder("{ ");
		Queue<BasicTrieNode> parentLevel = new LinkedList<>();
		Queue<BasicTrieNode> currentLevel = new LinkedList<>();
		
		// Adding the root to the parent level
		currentLevel.add(root);
		
		BasicTrieNode child;
		
		while (!currentLevel.isEmpty()) {
			
			sb.append("level " + level + " : ");
			
			parentLevel = new LinkedList<>(currentLevel);
			currentLevel = new LinkedList<>();
			// iterating over all the nodes in the parent level and keep adding to the child level, simultaneously append to StringBuffer
			for (BasicTrieNode parent : parentLevel) {
				sb.append(parent);
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
}
