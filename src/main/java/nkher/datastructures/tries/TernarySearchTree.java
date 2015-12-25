package nkher.datastructures.tries;

import java.security.InvalidParameterException;
import java.util.List;

/***
 * This class represents the implementation for a Ternary Search Trie that is similar to the implementation
 * of a hashmap or associative array where you can insert (key, value) pairs and get the value associated to
 * a particular key. The constraint here is that keys are only Strings. Each internal node has 3 children as
 * opposed to 26 children (English alphabets) in the normal Trie. This makes the number of null links at 
 * lesser which hence improves performance. There is no particular reason for why the design of this Trie is a
 * <Key, Value> and other regular tries are more for providing membership functionality or word frequency counts. 
 * One intuitive reasoning could be that the other tries require more space and memory hence are better for
 * storing dictionaries / words without Values associated to them. This eliminates the overhead of the values and
 * out of memory errors.
 * 
 * @author nameshkher
 * 
 * Reference : https://www.youtube.com/watch?v=CIGyewO7868 (Robert Sedgewicks Implementation)
 *
 * @param <V>
 */
public class TernarySearchTree<V> {

	private TernaryNode root;
	private int size;
	
	private class TernaryNode {
		private char data;
		private char parentData;
		private V value;
		private TernaryNode left, right, equal;
		
		public TernaryNode(char data, char parentData, V value) {
			this.data = data;
			this.parentData = parentData;
			this.value = value;
			this.left = this.right = this.equal = null;
		}
		
		public V value() { return value; }

		public String toString() {
			return "(" + data + "," + parentData + "," + value.toString() + ")";
		}
	}
	
	public TernarySearchTree() {
		this.size = 0;
	}
	
	public void insert(String key, V value) {
		checkValidKey(key);
		if (!contains(key)) size++;
		root = insertionUtil(key, value, root, 0, '$');
	}
	
	public boolean contains(String key) {
		return (get(key) != null);
	}
	
	/***
	 * A helper to insert the current key at the correct spot.
	 * @param key
	 * @param root
	 */
	private TernaryNode insertionUtil(String key, V value, TernaryNode node, int position, char parentData) {
		char ch = key.charAt(position); 
		if (node == null) { node = new TernaryNode(ch, parentData, value); }
		if (ch < node.data) {
			insertionUtil(key, value, node.left, position, node.data);
		} 
		else if (ch > node.data) {
			insertionUtil(key, value, node.right, position, node.data);
		}
		else {
			insertionUtil(key, value, node.equal, position+1, node.data);
		}
		return node;
	}

	/***
	 * Returns the values for the specified key
	 * @param key
	 * @return
	 */
	public V get(String key) {
		return searchUtil(key, root, 0, key.length());
	}
	
	private V searchUtil(String key, TernaryNode node, int position, int n) {
		
		if (node == null) return null;
		char ch = key.charAt(position); 
		
		if (ch < node.data) {
			return searchUtil(key, node.left, position, n);
		} 
		else if (ch > node.data) {
			return searchUtil(key, node.right, position, n);
		}
		else { // if equal go middle
			if (position == n-1) { // if this is the last character
				return (node.value());
			}
			return searchUtil(key, node.equal, position+1, n);
		} 		
	}

	public List<String> prefixSearch(String prefixKey) {
		return null;
	}

	public boolean containsPrefix(String prefixKey) {
		return false;
	}

	public boolean removeKey(String key) {
		return false;
	}

	protected void checkValidKey(String key) {
		if (null == key) { throw new NullPointerException("Passed key is null ! Please check."); }
		if (key.length() == 0) { 
			System.out.println("Inserting paramter with 0 length. Nothing inserted. Trie not modified."); 
		}
	}
	
	protected void checkValidKeysList(List<String> keys) {
		if (null == keys) { throw new NullPointerException("Passed parameter is null !"); }
		if (keys.size() == 0) { throw new InvalidParameterException("List passed is empty."); }
	}
}
