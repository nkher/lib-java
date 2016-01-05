package nkher.datastructures.trees;

import nkher.Interfaces.MyTree;
import nkher.datastructures.lists.DynamicArray;
import nkher.datastructures.lists.SinglyLinkedList;
import nkher.exception.DataStructureEmptyException;
import nkher.exception.NodeDoesNotExistException;

public class BinarySearchTree<K extends Comparable<K>, V> implements MyTree<K, V> {
	
	private int size;
	private BSTNode<K, V> root;
	
	public static class BSTNode<K extends Comparable<K>, V> extends AbstractTreeNode<K, V>{
		private BSTNode<K, V> left;
		private BSTNode<K, V> right;
		
		/** Default cons */
		public BSTNode() {}
		
		/** Constructor that initializes a BSTNode with its key and value only 
		 * @param - K key 
		 * @param - V value 
		 * @return - Returns a Node of type {@code BSTNode} 
		 */
		public BSTNode(K key, V value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}
		
		/** Constructor that initializes a BSTNode with its left and right nodes, key and value 
		 * @param - K key 
		 * @param - V value 
		 * @param - left child
		 * @param - right child
		 * @return - Returns a Node of type {@code BSTNode} 
		 */
		public BSTNode(K key, V value, BSTNode<K, V> left, BSTNode<K, V> right) {
			this.key = key;
			this.value = value;
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
		
		public BSTNode<K, V> left() {
			return left;
		}
		
		public BSTNode<K, V> right() {
			return right;
		}
		
		/** Setters for left and right nodes */
		
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
		
		public String toString() {
			return "[ key->" + this.key.toString() + ", value->" + this.value.toString() + " ]";
		}
		
		public boolean isLeaf() {
			return (left == null && right == null);
		}
		
		public void remove(K k, BSTNode<K, V> parent) {
			if (this.key.equals(k)) { // found the node
				
				/* Handle the deletion here */
				if (isLeaf()) { // Case 1 : node has no children
					if (parent.left == this) parent.left = null;
					else parent.right = null;
				}
				
				else if (left == null && right != null) { // Case 2 : node has only right child 
					parent.right = right;
					return;
				}
				
				else { // Case 3 : node has both children or only left child
					
					BSTNode<K, V> rightMin;
					
					if (right != null) rightMin = right.minnode();
					else rightMin = minnode();
					
					remove(rightMin.key, this); // remove the rightMin from its current position
					
					/* Adjust the pointers */
					rightMin.left = this.left;
					rightMin.right = this.right;
					
					if (parent.right == this) parent.right = rightMin;
					else parent.left = rightMin;
					
					return;
				}
			}
			else if (this.key.compareTo(k) < 0) { // go on the right
				right.remove(k, this);
			}
			else { // go on the left
				left.remove(k, this);
			}
		}
	}

	public int size() {
		return this.size;
	}

	public void insert(K key, V value) {
		insert(new BSTNode<K, V>(key, value));
	}
	
	/***
	 * Algorithm to insert a node in a binary search tree.
	 * Runtime - O(logN)
	 * 
	 * @param node - a {@code BSTNode} type node to be inserted
	 */
	public void insert(BSTNode<K, V> node) {
		size++;
		if (this.root == null) {
			this.root = node;
			return;
		}
		BSTNode<K, V> focusNode = root;
		BSTNode<K, V> parent;
		
		while (true) {
			parent = focusNode;
			if (parent.key.compareTo(node.key) > 0) { // parent is greater
				focusNode = focusNode.left;
				if (focusNode == null) {
					parent.left = node;
					return;
				}
			}
			else {
				focusNode = focusNode.right;
				if(focusNode == null) {
					parent.right = node;
					return;
				}
			}
		}
	}
	
	/***
	 * A method to search for a particular node in the BST that has the same key.
	 * The first occurrence of the node with the same key is returned. If the node does not
	 * exist in the tree then NodeDoesNotExistException is thrown with an appropriate message.
	 * If the tree is empty then DataStructureEmptyException is thrown with an appropriate message. <br/><br/>
	 * 
	 * @param node
	 * @return
	 */
	public BSTNode<K, V> search(BSTNode<K, V> node) {
		return search(node.key);
	}
	
	/***
	 * A method to search for a particular node in the BST that has the same key.
	 * The first occurrence of the node with the same key is returned. If the node does not
	 * exist in the tree then NodeDoesNotExistException is thrown with an appropriate message.
	 * If the tree is empty then DataStructureEmptyException is thrown with an appropriate message. <br/><br/>
	 * 
	 * @param node
	 * @return
	 */
	public BSTNode<K, V> search(K key) {
		if (root == null) {
			throw new DataStructureEmptyException("Binary Search Tree is Empty. Cannot search in an empty BST.");
		}
		return search(key, root);
	}
	
	/***
	 * A helper method to carry out the search and returning the appropriate result.
	 * 
	 * @param key - The key to be searched
	 * @param node - The current node under evaluation in the flow.
	 * @return
	 */
	private BSTNode<K, V> search(K key, BSTNode<K, V> node) {
		if (node == null) {
			throw new NodeDoesNotExistException("Node does not exist in the binary tree.");
		}
		else {
			if (node.key.equals(key)) { // found the node
				return node;
			}
			else if (node.key.compareTo(key) > 1) {
				return search(key, node.left);
			}
			else {
				return search(key, node.right);
			}
		}
	}
	
	/***
	 * This is to get all the nodes in the tree between (within) the specified range.
	 * This works well when the keys are of the numeric types : int, double, float etc.
	 * It also would work well when the Object Key implements its own Comparator. <br/><br/>
	 * 
	 * The function starts at the root of the tree and goes
	 * down to the lower levels based on key comparison. The algorithm is as follows :<br/> <br/>
	 * 
	 * 1. search key > max, recurse left subtree <br/>
	 * 2. search key < min, recurse right subtree <br/>
	 * 3. search key > min and search key < max, add the key and recurse on both sides <br/>
	 * 
	 * @param max - The minimum value for the search
	 * @param min - The maximum value for the search
	 * @return
	 */
	public DynamicArray<BSTNode<K, V>> rangeSearch(K min, K max) {
		if (min.compareTo(max) > 0) {
			throw new IllegalArgumentException("Min cannot be greater than max");
		}
		DynamicArray<BSTNode<K, V>> dArray = new DynamicArray<BSTNode<K,V>>();
		return rangeSearchHelper(min, max, this.root, dArray);
	}
	
	/**
	 * A utility method that serves as the helper for the range search method.
	 * 
	 * @param min - The minimum value for the search
	 * @param max - The maximum value for the search
	 * @param curr - The current value under evaluation in the recursive flow.
	 * @param dArray - The result.
	 * @return
	 */
	private DynamicArray<BSTNode<K, V>> rangeSearchHelper(K min, K max, BSTNode<K, V> curr, DynamicArray<BSTNode<K,V>> dArray) {
		
		if (null == curr) return dArray;
		
		if (curr.key.compareTo(max) > 0) { // go on the left
			rangeSearchHelper(min, max, curr.left, dArray);
		}
		
		else if (min.compareTo(curr.key) > 0) { // go on the right
			rangeSearchHelper(min, max, curr.right, dArray);
		}
		
		else if (curr.key.compareTo(min) >= 0 && max.compareTo(curr.key) >= 0) { // it is in between hence add and search both sides
			dArray.insert(curr);
			rangeSearchHelper(min, max, curr.left, dArray);
			rangeSearchHelper(min, max, curr.right, dArray);
		}

		return dArray;
	}

	/***
	 * Function to remove a node from the binary search tree.
	 * The function would throw a NodeDoesNotExistException() if the
	 * node to be deleted is not found in the tree. It uses a recursive algorithm 
	 * to perform deletion. <br/><br/>
	 * 
	 * ALGORITHM :  <br/>
	 * 
	 * Following are the cases that are taken care of: <br/><br/>
	 * 
	 * 1. The tree is empty, throws an exception.<br/>
	 * 2. The tree does not contain the key at all.<br/>
	 * 
	 * If the node to be deleted is found then following cases are taken care of : <br/><br/>
	 * 
	 * 3. The root is itself the key node.<br/>
	 * 4. The node is a leaf node.<br/>
	 * 5. The node is an internal node with only right child.<br/>
	 * 6. The node is an internal node with left as well as right child.<br/>
	 * 
	 * @return returns true if a node is deleted else returns false<br/>
	 */
	public boolean remove(K k) {
		boolean found = false;
		if (root == null) {
			throw new DataStructureEmptyException("Cannot delete from an empty tree !");
		}
		else {
			if (root.key.equals(k)) { // root equals the key
				
				/* Here we create a temporary parent to the root which would help us in deletion */
				BSTNode<K, V> tempParent = new BSTNode<K, V>();
				tempParent.right = this.root;
				root = tempParent;
				
				root.right.remove(k, tempParent);
				root = tempParent.right;
				tempParent.right = null;
				found = true;
			}
			else {
				this.root.remove(k, null);
				found = true;
			}
		}
		if (found) {
			size--;
		}
		return found;
	}
	
	/***
	 * Function to remove a node from the binary search tree.
	 * The function would throw a NodeDoesNotExistException() if the
	 * node to be deleted is not found in the tree. It uses a recursive algorithm 
	 * to perform deletion. <br/><br/>
	 * 
	 * ALGORITHM :  <br/>
	 * 
	 * Following are the cases that are taken care of: <br/><br/>
	 * 
	 * 1. The tree is empty, throws an exception.<br/>
	 * 2. The tree does not contain the key at all.<br/>
	 * 
	 * If the node to be deleted is found then following cases are taken care of : <br/><br/>
	 * 
	 * 3. The root is itself the key node.<br/>
	 * 4. The node is a leaf node.<br/>
	 * 5. The node is an internal node with only right child.<br/>
	 * 6. The node is an internal node with left as well as right child.<br/>
	 * 
	 * @return returns true if a node is deleted else returns false<br/>
	 */
	public boolean remove(BSTNode<K, V> bstNode) {
		return remove(bstNode.key);
	}

	public K rootkey() {
		if (root == null || size == 0) {
			throw new DataStructureEmptyException("Cannot return root key from an empty tree.");
		}
		return this.root.key;
	}
	
	/***
	 * Returns the root node of the tree. If the tree is empty it returns null.
	 * @return
	 */
	public BSTNode<K, V> root() {
		return this.root;
	}

	public boolean isEmpty() {
		return (size == 0);
	}
	
	/***
	 * Returns the min key node of the tree.<br/>
	 * 
	 * @return - node of {@code BSTNode<K, V>} type
	 */
	public BSTNode<K, V> min() {
		if (null == root) {
			throw new DataStructureEmptyException("Tree is empty.");
		}
		return root.minnode();
	}
	
	/***
	 * Returns the max key node of the tree.<br/>
	 * 
	 * @return - node of {@code BSTNode<K, V>} type
	 */
	public BSTNode<K, V> max() {
		if (null == root) {
			throw new DataStructureEmptyException("Tree is empty.");
		}
		return root.maxnode();
	}
	
	/******************************
	 * TREE TRAVERSALS
	 ******************************/

	/***
	 * Function to get the nodes of the tree in in-order fashion.
	 * In-order -> left, vertex, right
	 * 
	 * @return - array of {@code DynamicArray<BSTNode<K, V>>} type
	 */
	public DynamicArray<BSTNode<K, V>> inorder() {
		DynamicArray<BSTNode<K, V>> dArray = new DynamicArray<BSTNode<K,V>>();
		if (this.root == null) return dArray;
		return inorderUtil(root, dArray);
	}
	
	private DynamicArray<BSTNode<K, V>> inorderUtil(BSTNode<K, V> node, DynamicArray<BSTNode<K, V>> dArray) {
		if (node != null) {
			inorderUtil(node.left, dArray);
			dArray.insert(node);
			inorderUtil(node.right, dArray);
		}
		return dArray;
	}

	/***
	 * Function to get the nodes of the tree in pre-order fashion.
	 * Pre-order -> vertex, left, right
	 * 
	 * @return - array of {@code DynamicArray<BSTNode<K, V>>} type
	 */
	public DynamicArray<BSTNode<K, V>> preorder() {
		DynamicArray<BSTNode<K, V>> dArray = new DynamicArray<BSTNode<K,V>>();
		if (this.root == null) return dArray;
		return preorderUtil(root, dArray);
	}
	
	private DynamicArray<BSTNode<K, V>> preorderUtil(BSTNode<K, V> node, DynamicArray<BSTNode<K, V>> dArray) {
		if (node != null) {
			dArray.insert(node);
			preorderUtil(node.left, dArray);
			preorderUtil(node.right, dArray);
		}
		return dArray;
	}

	/***
	 * Function to get the nodes of the tree in post-order fashion.
	 * Post-order -> left, right, vertex
	 * 
	 * @return - array of {@code DynamicArray<BSTNode<K, V>>} type
	 */
	public DynamicArray<BSTNode<K, V>> postorder() {
		DynamicArray<BSTNode<K, V>> dArray = new DynamicArray<BSTNode<K,V>>();
		if (this.root == null) return dArray;
		return postorderUtil(root, dArray);
	}

	private DynamicArray<BSTNode<K, V>> postorderUtil(BSTNode<K, V> node, DynamicArray<BSTNode<K, V>> dArray) {
		if (node != null) {
			postorderUtil(node.left, dArray);
			postorderUtil(node.right, dArray);
			dArray.insert(node);
		}
		return dArray;
	}
	
	/***
	 * Returns the height of the BST. It calculates the height of the subtree tree at every
	 * node under it and hence is inefficient.
	 *  
	 * 
	 */
	public int height() {
		return heightUtil(root);
	}
	
	/***
	 * Helper method to get the height of the tree.</br>
	 * 
	 * @param node - The current node under evaluation.
	 * @return - height of the tree
	 */
	private int heightUtil(BSTNode<K, V> node) {
		if (null == node) return 0;
		return Math.max(heightUtil(node.left), heightUtil(node.right)) + 1;
	}
	
	/***
	 * Utility function to get the nodes of a BST in level order fashion.
	 * Each level is a linked list of nodes.
	 * 
	 * @return - an array of type {@code DynamicArray<SinglyLinkedList<BSTNode<K, V>>>}
	 */
	public DynamicArray<SinglyLinkedList<BSTNode<K, V>>> levelorder() {
		
		DynamicArray<SinglyLinkedList<BSTNode<K, V>>> result = new DynamicArray<SinglyLinkedList<BSTNode<K,V>>>();
		SinglyLinkedList<BSTNode<K, V>> children = new SinglyLinkedList<BSTNode<K,V>>();
		SinglyLinkedList<BSTNode<K, V>> parents;
		
		if (null == root) return result;
		
		children.insert(root); // insert the first node in the tree
		
		while (!children.isEmpty()) {
			result.insert(children);
			parents = children;
			children = new SinglyLinkedList<BSTNode<K,V>>();
			
			for (BSTNode<K, V> bstNode : parents) {
				
				if (bstNode.left != null) {
					children.insert(bstNode.left);
				}
				if (bstNode.right != null) {
					children.insert(bstNode.right);
				}
			}
		}
		return result;
	}
	
	/*****************************************************
	 * TREE TRAVERSAL - TO GET KEYS IN DIFFERENT FASHION
	 *****************************************************/
	
	/***
	 * Function to get the keys of all the nodes of the tree in in-order fashion.
	 * In-order -> left, vertex, right <br/>
	 * 
	 * @return - array of {@code DynamicArray<K>} type
	 */
	public DynamicArray<K> inorderkeys() {
		DynamicArray<K> dArray = new DynamicArray<K>();
		if (this.root == null) return dArray;
		return inorderkeysUtil(root, dArray);
	}
	
	/***
	 * Helper method for getting the keys in an in order fashion.<br/>
	 * 
	 * @param node - Current node under evaluation.
	 * @param dArray - The result.
	 * @return
	 */
	private DynamicArray<K> inorderkeysUtil(BSTNode<K, V> node, DynamicArray<K> dArray) {
		if (node != null) {
			inorderkeysUtil(node.left, dArray);
			dArray.insert(node.key);
			inorderkeysUtil(node.right, dArray);
		}
		return dArray;
	}

	/***
	 * Function to get the keys of all the nodes of the tree in pre-order fashion.
	 * Pre-order -> vertex, left, right <br/>
	 * 
	 * @return - array of {@code DynamicArray<K>} type
	 */
	public DynamicArray<K> preorderkeys() {
		DynamicArray<K> dArray = new DynamicArray<K>();
		if (this.root == null) return dArray;
		return preorderkeysUtil(root, dArray);
	}
	
	/***
	 * Helper method for getting the keys in a pre order fashion.<br/>
	 * 
	 * @param node - Current node under evaluation.
	 * @param dArray - The result.
	 * @return
	 */
	private DynamicArray<K> preorderkeysUtil(BSTNode<K, V> node, DynamicArray<K> dArray) {
		if (node != null) {
			dArray.insert(node.key);
			preorderkeysUtil(node.left, dArray);
			preorderkeysUtil(node.right, dArray);
		}
		return dArray;
	}

	/***
	 * Function to get the keys of all the nodes of the tree in post-order fashion.
	 * Pre-order -> vertex, left, right <br/>
	 * 
	 * @return - array of {@code DynamicArray<K>} type
	 */
	public DynamicArray<K> postorderkeys() {
		DynamicArray<K> dArray = new DynamicArray<K>();
		if (this.root == null) return dArray;
		return postorderkeysUtil(root, dArray);
	}

	/***
	 * Helper method for getting the keys in an in order fashion.<br/>
	 * 
	 * @param node - Current node under evaluation.
	 * @param dArray - The result.
	 * @return
	 */
	private DynamicArray<K> postorderkeysUtil(BSTNode<K, V> node, DynamicArray<K> dArray) {
		if (node != null) {
			postorderkeysUtil(node.left, dArray);
			postorderkeysUtil(node.right, dArray);
			dArray.insert(node.key);
		}
		return dArray;
	}
}
