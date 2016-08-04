package nkher.datastructures.trees;

import java.util.Random;

import nkher.datastructures.lists.DynamicArray;
import nkher.api.MyTreap;

/***
 * A Treap a is a special type of tree data structure that stores 2 pieces of information.
 * 
 * 1. The data we want to store - We look up for this as we do in a usual Binary Search Tree.
 * 2. A random real number - We store a random real number as in a Binary Heap.
 * 
 * A treap combines the advantages of a Binary Search Tree and a Binary Heap. With a very high probability
 * an n-node treap's height is O(log(n)).
 * 
 * @author nameshkher
 *
 * @param <K> - Key to be stored
 * @param <V> - Value to be stored
 */
public class Treap<K extends Comparable<K>, V> implements MyTreap<K, V> {
	
	private int size;
	private static Random rand = new Random();

	private TreapNode<K, V> root;
	
	public static class TreapNode<K extends Comparable<K>, V> {
		
		private int priority; // the numeric value that decides priority is a real random number
		private K key;
		private V value;
		private TreapNode<K, V> left;
		private TreapNode<K, V> right;
		
		public TreapNode() {} /** default cons */
		
		public TreapNode(K key, V value) {
			this.key = key;
			this.value = value;
			this.priority = rand.nextInt(Integer.MAX_VALUE/2) + 1;
		}
		
		public TreapNode(K key, V value, int priority) {
			this.key = key;
			this.value = value;
			this.priority = priority;
		}
		
		public TreapNode(K key, V value, TreapNode<K, V> left, TreapNode<K, V> right) {
			this(key, value);
			this.left = left;
			this.right = right;
		}

		/** Getters  for key, value, left and right nodes */
		
		public K key() {
			return this.key;
		}
		
		public V value() {
			return this.value;
		}
		
		public TreapNode<K, V> left() {
			return left;
		}
		
		public TreapNode<K, V> right() {
			return right;
		}
		
		public int priority() {
			return this.priority;
		}
		
		/** Setters for left and right nodes */
		
		public void setLeft(TreapNode<K, V> node) {
			this.left = node;
		}
		
		public void setRight(TreapNode<K, V> node) {
			this.right = node;
		}
		
		/***
		 * Returns the max key in the the current node's subtree 
		 * 
		 * @return a key of type {@code K}
		 */
		public K max() {
			if (right == null) return key;
			return right.max();
		}
		
		/***
		 * Returns the maximum key node in the the current node's subtree 
		 * 
		 * @return a node of type {@code TreapNode<K, V>}
		 */
		public TreapNode<K, V> maxnode() {
			if (right == null) return this;
			return right.maxnode();
		}
		
		/***
		 * Returns the min key in the the current node's subtree 
		 * 
		 * @return a key of type {@code K}
		 */
		public K min() {
			if (left == null) return key;
			return left.min();
		}
		
		/***
		 * Returns the minimum key node in the the current node's subtree 
		 * 
		 * @return a node of type {@code TreapNode<K, V>}
		 */
		public TreapNode<K, V> minnode() {
			if (left == null) return this;
			return left.minnode();
		}
		
		public String toString() {
			return "[ key->" + this.key.toString() + ", value->" + this.value.toString() + ", priority->" + this.priority + " ]";
		}
		
		public boolean isLeaf() {
			return (left == null && right == null);
		}
		
	}
	
	@Override
	public void insert(K key, V val) {
		insert(new TreapNode<K, V>(key, val));
	}
	
	public void insert(TreapNode<K, V> node) {
		if (node == null) {
			throw new IllegalArgumentException("Cannot insert a null node in a treap.");
		}
		size++;
		root = insertHelper(root, node);
	}
	
	public void insertWithPriority(K key, V val, int priority) {
		root = insertHelper(root, new TreapNode<>(key, val, priority));
	}
	
	private TreapNode<K, V> insertHelper(TreapNode<K, V> root, TreapNode<K, V> node) {
		
		if (null == root) {
			return node;
		} 
		else if (root.key.compareTo(node.key) > 0) { // root is greater
			root.left = insertHelper(root.left, node);
			if (root.left.priority < root.priority) {
				root = rightRotate(root);
			}			
		}
		else if (root.key.compareTo(node.key) < 0){ // root is smaller
			root.right = insertHelper(root.right, node);
			if (root.right.priority < root.priority) {
				root = leftRotate(root);
			}
		}
		
		return root;
	}

	@Override
	public boolean remove(K key) {
		if (contains(key)) {
			removeHelper(root, key);
			return true;
		}
		return false;		
	}
	
	private TreapNode<K, V> removeHelper(TreapNode<K, V> root, K key) {
		
		if (root == null) return root;
		
		if (key.compareTo(root.key) < 0) { // if key is smaller
			root.left = removeHelper(root.left, key);
		} else if (key.compareTo(root.key) > 0) { // if key is larger
			root.right = removeHelper(root.right, key);
		} 
		
		else if (root.left == null) { // If the key is at the root and left is null
			TreapNode<K, V> temp = root;
			root = temp.right;
		} 
		else if (root.right == null) { // If the key is at the root and right is null
			TreapNode<K, V> temp = root;
			root = temp.left;
		}
			
		else if (root.left.priority < root.right.priority) {
			root = leftRotate(root);
			root.left = removeHelper(root.left, key);
		} 
		else {
			root = rightRotate(root);
			root.right = removeHelper(root.right, key);
		}
		
		return root;
	}

	@Override
	public boolean contains(K key) {
		return containsHelper(this.root, key);
	}
	
	private boolean containsHelper(TreapNode<K, V> root, K key) {
		if (root == null) return false;
		
		if (root.key.compareTo(key) == 0) {
			return true;
		}
		
		if (root.key.compareTo(key) < 0) { // If root's key is greater than key to be searched
			return containsHelper(root.left, key);
		}
		
		return containsHelper(root.right, key);
	}

	@Override
	public K minKey() {
		TreapNode<K, V> temp = root;
		while (temp != null) {
			temp = temp.left;
		}
		return temp.key;
	}

	@Override
	public V minVal() {
		TreapNode<K, V> temp = root;
		while (temp != null) {
			temp = temp.left;
		}
		return temp.value;
	}

	@Override
	public K maxKey() {
		TreapNode<K, V> temp = root;
		while (temp != null) {
			temp = temp.right;
		}
		return temp.key;
	}

	@Override
	public V maxVal() {
		TreapNode<K, V> temp = root;
		while (temp != null) {
			temp = temp.right;
		}
		return temp.value;
	}

	@Override
	public void clear() {		
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public TreapNode<K, V> root() {
		return root;
	}
	
	/*******************************************************************************
	 * Methods that perform necessary rotations for balancing the search tree.
	 * These are used to check balance property during insertion and deletion of nodes.
	 *******************************************************************************/
	
	private TreapNode<K, V> leftRotate(TreapNode<K, V> y) {
		TreapNode<K, V> x = y.right;
		TreapNode<K, V> subtree = x.left;
		
		/** Performing the rotation */
		x.left = y;
		y.right = subtree;
		
		return x;
	}
	
	private TreapNode<K, V> rightRotate(TreapNode<K, V> y) {
		TreapNode<K, V> x = y.left;
		TreapNode<K, V> subtree = x.right;
		
		/** Performing the rotation */
		x.right = y;
		y.left = subtree;
		
		return x;
	}

	/******************************
	 * TREE TRAVERSALS
	 ******************************/

	/***
	 * Function to get the nodes of the tree in in-order fashion.
	 * In-order -> left, vertex, right
	 * 
	 * @return - array of {@code DynamicArray<TreapNode<K, V>>} type
	 */
	public DynamicArray<TreapNode<K, V>> inorder() {
		DynamicArray<TreapNode<K, V>> dArray = new DynamicArray<TreapNode<K,V>>();
		if (this.root == null) return dArray;
		return inorderUtil(root, dArray);
	}
	
	private DynamicArray<TreapNode<K, V>> inorderUtil(TreapNode<K, V> node, DynamicArray<TreapNode<K, V>> dArray) {
		if (node != null) {
			inorderUtil(node.left, dArray);
			dArray.insert(node);
			inorderUtil(node.right, dArray);
		}
		return dArray;
	}
	

}
