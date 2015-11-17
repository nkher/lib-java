package nkher.datastructures.trees;

import nkher.Interfaces.MyTree;
import nkher.exception.DataStructureEmptyException;

public class AVLTree<K extends Comparable<K>, V> implements MyTree<K, V> {

	private int size = 0;
	private AVLNode<K, V> root;
	
	public static class AVLNode<K extends Comparable<K>, V> {
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
		insert(new AVLNode<K, V>(k, v));
	}
	
	/***
	 * Algorithm to insert a node in a AVL tree.
	 * Runtime - O(logN)
	 * 
	 * @param node - a {@code AVLNode} type node to be inserted
	 */
	public void insert(AVLNode<K, V> node) {
		
		if (node == null) {
			throw new IllegalArgumentException("Cannot insert a null node");
		}
		
		/* Performing a BST insertion */
		size++;		
		if (null == this.root) {
			root = node;
			return;
		}
		AVLNode<K, V> temp = this.root;
		while (true) {
			if (temp.key.compareTo(node.key) > 0) { // temp is greater then go left
				if (temp.left != null) {
					temp = temp.left;
				}
				else {
					temp.left = node;
					break;
				}
			}
			else {
				if (temp.right != null) {
					temp = temp.right;
				}
				else {
					temp.right = node;
					break;
				}
			}
		}
		/* BST insertion done */
		
		/* Performing the balancing */
		System.out.println("temp : " + temp.toString());
		node.setHeight(Math.max(heightAt(temp.left), heightAt(temp.right)) + 1);
		int balanceFactor = balanceAt(temp);
		
		/* Check all possible cases where balance can go wrong */
		
		// CASE 1 : LEFT LEFT CASE
		if (balanceFactor > 1 && node.key.compareTo(temp.left.key) < 0) {
			this.root = rightRotate(temp);
		}
		
		// CASE 2 : LEFT RIGHT CASE
		if (balanceFactor > 1 && node.key.compareTo(temp.left.key) > 0) {
			temp.left = leftRotate(root.left);
			this.root = rightRotate(root);
		}
		
		// CASE 3 : RIGHT RIGHT CASE
		if (balanceFactor < -1 && node.key.compareTo(temp.right.key) > 0) {
			this.root = leftRotate(temp);
		}
		
		// CASE 4 : RIGHT LEFT CASE
		if (balanceFactor < -1 && node.key.compareTo(temp.right.key) < 0) {
			root.right = rightRotate(root.right);
			this.root = leftRotate(temp);
		}		
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
	
	public AVLNode<K, V> root() {
		return this.root;
	}

	public boolean isEmpty() {
		return (this.size == 0);
	}
	
	/*******************************************************************************
	 * Functions that perform necessary rotations for balancing the search tree.
	 * These are used to check balance property during insertion and deletion of nodes.
	 *******************************************************************************/
	
	private AVLNode<K, V> leftRotate(AVLNode<K, V> y) {
		AVLNode<K, V> right = y.right;
		AVLNode<K, V> rightsLChild = right.left;
		
		/** Rotation */
		right.left = y;
		y.right = rightsLChild.left;
		
		/** Fixing the heights */
		right.height = Math.max(right.left.height, right.right.height) + 1;
		y.height = Math.max(y.left.height, y.right.height) + 1;
		
		return right;
	}
	
	private AVLNode<K, V> rightRotate(AVLNode<K, V> y) {
		AVLNode<K, V> left = y.left; /* get the left child */
		AVLNode<K, V> leftsRChild = left.right; /* get the right child of the left child */
		
		/** Rotation */
		left.right = y;
		y.left = leftsRChild;
		
		/** Fixing the heights */
		left.height = Math.max(left.left.height, left.right.height) + 1;
		y.height = Math.max(y.left.height, y.right.height) + 1;
		
		return left;
	}
	
	/***
	 * Function to get the balance at a particular subtree.
	 * Helps for deciding on how to perform rotations.
	 * Returns height of left subtree minus height of right subtree.
	 * 
	 * @param node
	 * @return
	 */
	private int balanceAt(AVLNode<K, V> node) {
		if (null == node) return 0;
		return heightAt(node.left) - heightAt(node.right);
	}
	
	private int heightAt(AVLNode<K, V> node) {
		if (null == root) return 0;
		return root.height;
	}

}
