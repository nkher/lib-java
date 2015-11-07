package nkher.datastructures;

import nkher.Interfaces.MyTree;

public class BinarySearchTree<K extends Comparable<K>, V> implements MyTree<K, V> {
	
	private int size;
	private BSTNode<K, V> root;
	
	public static class BSTNode<K extends Comparable<K>, V> {
		private K key; // field that determines the order of insertion
		private V val;
		private BSTNode<K, V> left;
		private BSTNode<K, V> right;
		
		public BSTNode() {}
		
		/** Constructor that initializes a BSTNode with its key and value only 
		 * @param - K key 
		 * @param - V value 
		 * @return - Returns a BSTNode */
		public BSTNode(K key, V val) {
			this.key = key;
			this.val = val;
			this.left = null;
			this.right = null;
		}
		
		/** Constructor that initializes a BSTNode with its left and right nodes, key and value 
		 * @param - K key 
		 * @param - V value 
		 * @param - left (left child) 
		 * @param - right (right child) 
		 * @return - Returns a BSTNode */
		public BSTNode(K key, V val, BSTNode<K, V> left, BSTNode<K, V> right) {
			this.key = key;
			this.val = val;
			this.left = left;
			this.right = right;
		}
		
		public K key() {
			return this.key;
		}
		
		public V value() {
			return this.val;
		}
		
		public BSTNode<K, V> left() {
			return left;
		}
		
		public BSTNode<K, V> right() {
			return right;
		}
		
		public void setLeft(BSTNode<K, V> node) {
			this.left = node;
		}
		
		public void setRight(BSTNode<K, V> node) {
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
		 * @return a node of type {@code BSTNode<K, V>}
		 */
		public BSTNode<K, V> maxnode() {
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
		 * @return a node of type {@code BSTNode<K, V>}
		 */
		public BSTNode<K, V> minnode() {
			if (left == null) return this;
			return left.minnode();
		}
	}

	public int size() {
		return this.size;
	}

	public void insert(K k, V v) {
		
	}

	public void remove(K k) {
		
	}

	public K rootkey() {
		return this.root.key;
	}
	
	public BSTNode<K, V> root() {
		return this.root;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public DynamicArray<V> inorder() {
		return null;
	}

	public DynamicArray<V> preorder() {
		return null;
	}

	public DynamicArray<V> postorder() {
		return null;
	}


}
