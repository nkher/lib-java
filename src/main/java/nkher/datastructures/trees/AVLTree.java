package nkher.datastructures.trees;

import nkher.Interfaces.MyTree;
import nkher.exception.DataStructureEmptyException;

public class AVLTree<K extends Comparable<K>, V> implements MyTree<K, V> {

	private int size = 0;
	private AVLNode<K, V> root;
	
	protected static class AVLNode<K extends Comparable<K>, V> {
		private K key;
		private V value;
		private AVLNode<K, V> left;
		private AVLNode<K, V> right;
		private int height = 0;
		
		public AVLNode() {}
		
		/** Constructor that initializes a AVLNode with its key and value only 
		 * @param - K key 
		 * @param - V value 
		 * @return - Returns a Node of type {@code AVLNode} 
		 */
		public AVLNode(K key, V val) {
			this.key = key;
			this.value = val;
			left = right = null;
		}
		
		/** Constructor that initializes a AVLNode with its left and right nodes, key and value 
		 * @param - K key 
		 * @param - V value 
		 * @param - left child 
		 * @param - right child
		 * @return - Returns a Node of type {@code AVLNode}  
		 */
		public AVLNode(K key, V val, AVLNode<K, V> left, AVLNode<K, V> right) {
			this.key = key;
			this.value = val;
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
		
		public int height() {
			return this.height;
		}
		
		public AVLNode<K, V> left() {
			return left;
		}
		
		public AVLNode<K, V> right() {
			return right;
		}
		
		public void setHeight(int height) {
			this.height = height;
		}
		
		/** Setters for left and right nodes */
		
		public void setLeft(AVLNode<K, V> node) {
			this.left = node;
		}
		
		public void setRight(AVLNode<K, V> node) {
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
		public AVLNode<K, V> maxnode() {
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
		public AVLNode<K, V> minnode() {
			if (left == null) return this;
			return left.minnode();
		}
		
		public String toString() {
			return "[ key->" + this.key.toString() + ", value->" + this.value.toString() + " ]";
		}
		
		public boolean isLeaf() {
			return (left == null && right == null);
		}
		
	}
	
	public int size() {
		return this.size;
	}

	public void insert(K k, V v) {
		
	}

	public boolean remove(K k) {
		return false;
	}

	public K rootkey() {
		if (root == null || size == 0) {
			throw new DataStructureEmptyException("Cannot return root key from an empty tree.");
		}
		return this.root.key;
	}

	public boolean isEmpty() {
		return (this.size == 0);
	}
	
	/*******************************************************************************
	 * Functions that perform necessary rotations for balancing the search tree.
	 * These are used to check balance property during insertion and deletion of nodes.
	 *******************************************************************************/
	
	private AVLNode<K, V> leftRotate(AVLNode<K, V> y) {
		return null;
	}
	
	private AVLNode<K, V> rightRotate(AVLNode<K, V> y) {
		return null;
	}

}
