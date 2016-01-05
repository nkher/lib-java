package nkher.datastructures.trees;

import nkher.Interfaces.MyTree;
import nkher.datastructures.lists.DynamicArray;
import nkher.datastructures.lists.SinglyLinkedList;
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
			return "[k->" + this.key.toString() + ",v->" + this.value.toString() + ",col->" + this.color.toString() + "]";
		}
		
		public boolean isLeaf() {
			return (left == null && right == null);
		}
		
		public RedBlackNode<K, V> grandparent() {
			return this.parent.parent;
		}
	}
	
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void insert(K k, V v) {		
		insert(new RedBlackNode<K, V>(k, v));
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
						break;
					}
 				}
				else { // go to the right
					focusNode = focusNode.right;
					if (null == focusNode) {
						parent.setRight(node);
						node.setParent(parent);
						break;
					}
				}
			}
			
			/** Setting the color of the newly inserted node to Red */
			node.setColor(Color.Red);
			
			RedBlackNode<K, V> nodeToFixAt = node;
						
			while (null != nodeToFixAt && !nodeToFixAt.parent.getColor().equals(Color.Black) && nodeToFixAt.color.equals(Color.Red)) {
												
				RedBlackNode<K, V> uncle = getUncleNode(nodeToFixAt);
				RedBlackNode<K, V> grandparent = nodeToFixAt.grandparent();
								
				/** Case 1 : Uncle is red -- ReColoring Case */
				if (null != uncle && uncle.getColor().equals(Color.Red)) {
					nodeToFixAt = performReColoring(grandparent);
				}
				
				/** Case 2 : Uncle is black -- Rotation Case */
				
				else if (null == uncle || uncle.getColor().equals(Color.Black)) {
										
					/** Sub case 1 : Left Left Case */
					if (nodeToFixAt.parent.left == nodeToFixAt && grandparent.left == node.parent) {
						nodeToFixAt = leftleftCase(grandparent);
					}
					
					/** Sub case 2 : Left Right Case */
					else if (nodeToFixAt.parent.right == nodeToFixAt && grandparent.left == node.parent) {
						nodeToFixAt = leftRotate(node.parent, (node.parent == root));
						nodeToFixAt = leftleftCase(grandparent);
					}
					
					/** Sub case 3 : Right Right Case */
					else if (nodeToFixAt.parent.right == nodeToFixAt && grandparent.right == nodeToFixAt.parent) {
						nodeToFixAt = rightrightCase(grandparent);
					}
					
					/** Sub case 4 : Right Left Case */
					else if (nodeToFixAt.parent.left == nodeToFixAt && grandparent.right == nodeToFixAt.parent) {
						nodeToFixAt = rightRotate(node.parent, (node.parent == root));
						nodeToFixAt = rightrightCase(grandparent);
					}
				}	
				
				if (root == nodeToFixAt) { // we cannot go above root
					break;
				}
			}
		}
		System.out.println("Insertion successfull !");
	}
	
	private RedBlackNode<K, V> performReColoring(RedBlackNode<K, V> grandparent) {
		/** Keep changing the color of parent and uncle till we reach null */
		if (null != grandparent) {
			grandparent.right.setColor(Color.Black);
			grandparent.left.setColor(Color.Black);
			if (grandparent != root) {
				grandparent.setColor(Color.Red);
				
				/* 
				 * Re color if following 3 conditions are met
				 * 	1. Grandparent is not null
				 *  2. Grandparent's parent's color is Red
				 *  3. Grandparent's uncle's color is Red
				 */
				if (null != getUncleNode(grandparent) && grandparent.parent.color.equals(Color.Red) && getUncleNode(grandparent).color.equals(Color.Red)) {
					performReColoring(grandparent.grandparent()); // recurse above
				}
			}
		}		
		return grandparent;
	}
	
	/***
	 * Utility function to perform the left left case rotation. 
	 */
	private RedBlackNode<K, V> leftleftCase(RedBlackNode<K, V> grandparent) {
		RedBlackNode<K, V> temp = rightRotate(grandparent, (grandparent == root));
		flipNodeColors(grandparent, temp);
		return temp;
	}
	
	/***
	 * Utility function to perform the right right case rotation. 
	 */
	private RedBlackNode<K, V> rightrightCase(RedBlackNode<K, V> grandparent) {
		RedBlackNode<K, V> temp = leftRotate(grandparent, (grandparent == root));
		flipNodeColors(grandparent, temp);
		return temp;
	}
	
	/***
	 * Utility function to get the uncle node for the current node.
	 */
	private RedBlackNode<K, V> getUncleNode(RedBlackNode<K, V> node) {
		if (null == node || null == node.parent() || null == node.grandparent()) return null; // no parent sibling		
		if (node.grandparent().left == node.parent()) { // if left child
			return node.grandparent().right;
		}
		return node.grandparent().left;
	}
	
	private void flipNodeColors(RedBlackNode<K, V> rbNode1, RedBlackNode<K, V> rbNode2) {
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
	private RedBlackNode<K, V> leftRotate(RedBlackNode<K, V> node, boolean isRoot) {
		RedBlackNode<K, V> r = node.right;
		RedBlackNode<K, V> rLeft = r.left;
		
		/* Setting the left and right pointers appropriately */
		r.left = node;
		node.right = rLeft;
		
		/* Reset the parents and children appropriately -- very important */ 
		r.setParent(node.parent);
		
		if (!isRoot) {
			if (node.parent.left == node) {
				node.parent.setLeft(r);
			}
			else if (node.parent.right == node) {
				node.parent.setRight(r);
			}
		}
		else { // if we are rotating the root
			root = r;
		}
		
		node.setParent(r);
		
		return r;
	}
	
	/**
	 * Utility function for performing the right rotation.
	 * @param root
	 */
	private RedBlackNode<K, V> rightRotate(RedBlackNode<K, V> node, boolean isRoot) {		
		RedBlackNode<K, V> l = node.left; // 17
		RedBlackNode<K, V> lRight = l.right; // null
		
		/* Setting the left and right pointers appropriately */
		l.right = node;
		node.left = lRight;
		
		/* Reset the parents and children appropriately -- very important */ 
		l.setParent(node.parent);
		
		if (!isRoot) {
			if (node.parent.left == node) {
				node.parent.setLeft(l);
			}
			else if (node.parent.right == node) {
				node.parent.setRight(l);
			}
		}
		else { // if we are rotating the root
			root = l;
		}
		
		node.setParent(l);
		
		return l;
	}
	
	/***
	 * Function to get the nodes of the tree in in-order fashion.
	 * In-order -> left, vertex, right
	 * 
	 * @return - array of {@code DynamicArray<RedBlackNode<K, V>>} type
	 */
	public DynamicArray<RedBlackNode<K, V>> inorder() {
		DynamicArray<RedBlackNode<K, V>> dArray = new DynamicArray<RedBlackNode<K,V>>();
		if (this.root == null) return dArray;
		return inorderUtil(root, dArray);
	}
	
	private DynamicArray<RedBlackNode<K, V>> inorderUtil(RedBlackNode<K, V> node, DynamicArray<RedBlackNode<K, V>> dArray) {
		if (node != null) {
			inorderUtil(node.left, dArray);
			dArray.insert(node);
			inorderUtil(node.right, dArray);
		}
		return dArray;
	}
	
	/***
	 * Utility function to get the nodes of a BST in level order fashion.
	 * Each level is a linked list of nodes.
	 * 
	 * @return - an array of type {@code DynamicArray<SinglyLinkedList<RedBlackNode<K, V>>>}
	 */
	public DynamicArray<SinglyLinkedList<RedBlackNode<K, V>>> levelorder() {
		
		DynamicArray<SinglyLinkedList<RedBlackNode<K, V>>> result = new DynamicArray<SinglyLinkedList<RedBlackNode<K,V>>>();
		SinglyLinkedList<RedBlackNode<K, V>> children = new SinglyLinkedList<RedBlackNode<K,V>>();
		SinglyLinkedList<RedBlackNode<K, V>> parents;
		
		if (null == root) return result;
		
		children.insert(root); // insert the first node in the tree
		
		while (!children.isEmpty()) {
			result.insert(children);
			parents = children;
			children = new SinglyLinkedList<RedBlackNode<K,V>>();
			
			for (RedBlackNode<K, V> rbNode : parents) {
				
				if (rbNode.left != null) {
					children.insert(rbNode.left);
				}
				if (rbNode.right != null) {
					children.insert(rbNode.right);
				}
			}
		}
		return result;
	}
}
