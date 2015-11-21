package nkher.datastructures.trees;

import nkher.Interfaces.MyTree;
import nkher.exception.DataStructureEmptyException;

/****
 * 
 * 
 * @author nameshkher
 *
 *
 * @param <K>
 * @param <V>
 */
public class AVLTree<K extends Comparable<K>, V> implements MyTree<K, V> {

	private int size = 0;
	private AVLNode<K, V> root;
	
	public static class AVLNode<K extends Comparable<K>, V> {
		private K key;
		private V value;
		private AVLNode<K, V> left;
		private AVLNode<K, V> right;
		private int height;
		
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
			height = 1;
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
			height = 1;
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

	/***
	 * Algorithm to insert a node in a AVL tree.
	 * The function accepts a Key and Value for inserting into the tree.
	 * Runtime - O(logN)
	 * 
	 * @param node - a Key of type {@code K} and Value of type {@code V} for inserting into the tree.
	 */
	public void insert(K k, V v) {
		insert(new AVLNode<K, V>(k, v));
	}
	
	/***
	 * Algorithm to insert a node in a AVL tree.
	 * The function accepts a AVLNode<K, V> type object.
	 * Runtime - O(logN)
	 * 
	 * @param node - a {@code AVLNode} type node to be inserted
	 */
	public void insert(AVLNode<K, V> node) {
		if (node == null) {
			throw new IllegalArgumentException("Cannot insert a null node");
		}
		root = insertHelper(root, node);
	}
	
	private AVLNode<K, V> insertHelper(AVLNode<K, V> root, AVLNode<K, V> node) {
		
		/* Performing a Recursive BST insertion */
		size++;		
		if (null == root) {
			return node;
		}
		else if (root.key.compareTo(node.key) > 0) { // root is greater then go left
			root.left = insertHelper(root.left, node);
		}
		else {
			root.right = insertHelper(root.right, node);
		}
		/* BST insertion done */
		
		/* Performing the balancing of each of the ancestors of the node inserted */
		root.setHeight(Math.max(heightAt(root.left), heightAt(root.right)) + 1);
						
		/* Get the balance factor at this point to re check if it is unbalanced */
		int balanceFactor = balanceAt(root);
		
		// System.out.println("Root : " + root + ", BF : " + balanceFactor);
		
		/* Check all possible cases where balance can go wrong */
		
		// CASE 1 : LEFT LEFT CASE
		if (balanceFactor > 1 && node.key.compareTo(root.left.key) < 0) {
			return rightRotate(root);
		}
		
		// CASE 2 : LEFT RIGHT CASE
		if (balanceFactor > 1 && node.key.compareTo(root.left.key) > 0) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}
		
		// CASE 3 : RIGHT RIGHT CASE
		if (balanceFactor < -1 && node.key.compareTo(root.right.key) > 0) {
			return leftRotate(root);
		}
		
		// CASE 4 : RIGHT LEFT CASE
		if (balanceFactor < -1 && node.key.compareTo(root.right.key) < 0) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}
		
		return root;
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
		AVLNode<K, V> x = y.right;
		AVLNode<K, V> subtree = x.left;
		
		/** Rotation */
		x.left = y;
		y.right = subtree;
		
		/** Fixing the heights */
		y.height = Math.max(heightAt(y.left), heightAt(y.right)) + 1;
		x.height = Math.max(heightAt(x.right), heightAt(x.left)) + 1;
		
		return x;
	}
	
	private AVLNode<K, V> rightRotate(AVLNode<K, V> y) {
		AVLNode<K, V> x = y.left; /* get the left child */
		AVLNode<K, V> subtree = x.right; /* get the right child of the left child */
		
		/** Rotation */
		x.right = y;
		y.left = subtree;
		
		/** Fixing the heights */
		y.height = Math.max(heightAt(y.left), heightAt(y.right)) + 1;
		x.height = Math.max(heightAt(x.right), heightAt(x.left)) + 1;
		
		return x;
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
		if (null == node) return 0;
		return node.height;
	}

}
