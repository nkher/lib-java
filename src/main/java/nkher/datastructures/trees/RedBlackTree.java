package nkher.datastructures.trees;

import nkher.Interfaces.MyTree;
import nkher.datastructures.trees.BinarySearchTree.BSTNode;
import nkher.exception.DataStructureEmptyException;

public class RedBlackTree<K extends Comparable<K>, V>  implements MyTree<K, V> {
	
	private enum Color {
		Red, Black;
	}
	
	private int size;
	private RedBlackNode<K, V> root;
	
	public static class RedBlackNode<K extends Comparable<K>, V> extends AbstractTreeNode<K, V>{
		private Color color;
		private RedBlackNode<K, V> left, right, parent;
		
		/** Default cons */
		public RedBlackNode() {}
		
		/** Constructor that initializes a RedBlackNode with its key and value only 
		 * @param - K key 
		 * @param - V value 
		 * @return - Returns a Node of type {@code RedBlackNode} 
		 */
		public RedBlackNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		/** Constructor that initializes a RedBlackNode with its left, right and parent nodes, as well as key and value 
		 * @param - K key 
		 * @param - V value 
		 * @param - left child
		 * @param - right child
		 * @return - Returns a Node of type {@code RedBlackNode} 
		 */
		public RedBlackNode(K key, V value, RedBlackNode<K, V> left, RedBlackNode<K, V> right, RedBlackNode<K, V> parent) {
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
		
		/*** Getters and Setters */
		public void setParent(RedBlackNode<K, V> parent) {
			this.parent = parent;
		}
		
		public void setLeft(RedBlackNode<K, V> left) {
			this.left = left;
		}
		
		public void setRight(RedBlackNode<K, V> right) {
			this.right = right;
		}
		
		public void setColor(Color color) {
			this.color = color;
		}
		
		public RedBlackNode<K, V> parent() {
			return parent;
		}
		
		public RedBlackNode<K, V> left() {
			return left;
		}
		
		public RedBlackNode<K, V> right() {
			return right;
		}
		
		public Color getColor() {
			return this.color;
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
		 * @return a node of type {@code RedBlackNode<K, V>}
		 */
		public RedBlackNode<K, V> maxnode() {
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
		 * @return a node of type {@code RedBlackNode<K, V>}
		 */
		public RedBlackNode<K, V> minnode() {
			if (left == null) return this;
			return left.minnode();
		}
		
		public String toString() {
			return "[ key->" + this.key.toString() + ", value->" + this.value.toString() + ", color->" + this.color.toString() + " ]";
		}
		
		public boolean isLeaf() {
			return (left == null && right == null);
		}
	}
	
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void insert(K k, V v) {		
	}
	
	public void insert(RedBlackNode<K, V> node) {
		size++;
		if (null == root) {
			root = node;
			root.setColor(Color.Black); // set root's color to black
			root.setParent(null);
		}
		else {
			RedBlackNode<K, V> focusNode = root;
			RedBlackNode<K, V> parent;
			
			// always inserting the incoming the nodes as red
			while (true) {
				parent = focusNode;
				if (parent.key.compareTo(node.key) > 0) { // go to the left
					focusNode = focusNode.left;
					if (null == focusNode) {
						parent.setLeft(node);
						node.setParent(parent);
						node.setColor(Color.Red);
						break;
					}
 				}
				else { // go to the right
					focusNode = focusNode.right;
					if (null == focusNode) {
						parent.setRight(node);
						node.setParent(parent);
						node.setColor(Color.Red);
						break;
					}
				}
			}
			
			/** Now the Red Black Tree fixing part */
			if (!node.parent.getColor().equals(Color.Black)) { // if the inserted node's parent is not black
				
				RedBlackNode<K, V> uncle = getUncleNode(node);
				RedBlackNode<K, V> grandparent = node.parent.parent;
				
				/** Case 1 : Uncle is red */
				if (null == uncle || uncle.getColor().equals(Color.Red)) {
					
					/** Case where the grandparent is the root itself */
					if (root == grandparent) {
						grandparent.right.setColor(Color.Black);
						grandparent.left.setColor(Color.Black);
						return;
					}
					
					/** right rotate on the grandparent only if it is not the root */
					else {
						 
					}
				}
				
				/** Case 2 : Uncle is black */
				else if (null == uncle || uncle.getColor().equals(Color.Black)) {
					
					/** Sub case 1 : Left Left Case */
					if (node.parent.left == node && grandparent.left == node.parent) {
						leftleftCase(grandparent, node.parent);
					}
					
					/** Sub case 2 : Left Right Case */
					else if (node.parent.right == node && grandparent.left == node.parent) {
						leftRotate(node.parent);
						leftleftCase(grandparent, node);
					}
					
					/** Sub case 3 : Right Right Case */
					else if (node.parent.right == node && grandparent.left == node.parent) {
						rightrightCase(grandparent, node.parent);
					}
					
					/** Sub case 4 : Right Left Case */
					else if (node.parent.right == node && grandparent.left == node.parent) {
						rightRotate(node.parent);
						rightrightCase(grandparent, node);
					}
				}
			}
		}
	}
	
	/***
	 * Utility function to perform the left left case rotation. 
	 */
	private void leftleftCase(RedBlackNode<K, V> grandparent, RedBlackNode<K, V> parent) {
		rightRotate(grandparent);
		swapNodeColors(grandparent, parent);
	}
	
	/***
	 * Utility function to perform the right right case rotation. 
	 */
	private void rightrightCase(RedBlackNode<K, V> grandparent, RedBlackNode<K, V> parent) {
		leftRotate(grandparent);
		swapNodeColors(grandparent, parent);
	}
	
	/***
	 * Utility function to get the uncle node for the current node.
	 */
	private RedBlackNode<K, V> getUncleNode(RedBlackNode<K, V> node) {
		if (null == node) return null; // no parent sibling
		if (node.parent.left == node) { // if left child
			return node.parent.right;
		}
		return node.parent.right;
	}
	
	private void swapNodeColors(RedBlackNode<K, V> rbNode1, RedBlackNode<K, V> rbNode2) {
		Color temp = rbNode1.color;
		rbNode1.setColor(rbNode2.color);
		rbNode2.setColor(temp);
	}

	@Override
	public boolean remove(K k) {
		return false;
	}

	@Override
	public K rootkey() {
		if (root == null || size == 0) {
			throw new DataStructureEmptyException("Cannot return root key from an empty tree.");
		}
		return this.root.key;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}
	
	/*******************************************************************************
	 * Functions that perform necessary rotations for balancing the search tree.
	 * These are used to check balance property during insertion and deletion of nodes.
	 *******************************************************************************/
	
	/**
	 * Utility function for performing the left rotation.
	 * @param root
	 */
	private void leftRotate(RedBlackNode<K, V> root) {
		
	}
	
	/**
	 * Utility function for performing the right rotation.
	 * @param root
	 */
	private void rightRotate(RedBlackNode<K, V> grandparent) { // x is th grandparent here (in left left case)
		RedBlackNode<K, V> parent = grandparent.left; 
		
	}

}
