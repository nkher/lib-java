package nkher.Interfaces;

import nkher.datastructures.BinarySearchTree.BSTNode;
import nkher.datastructures.DynamicArray;

public interface MyTree<K, V> {
	
	/***
	 * Returns the Size of the Tree
	 * 
	 * @return {@code int} size of the tree
	 */
	int size();
	
	/***
	 * Inserts a Node into the tree
	 * 
	 * @param k node of type {@code K} to be inserted
	 */
	void insert(K k, V v);
	
	/***
	 * Removes the first occurrence of the node whose data equals t's data
	 * 
	 * @param t
	 */
	void remove(K k);
	
	/***
	 * Returns the root node of the tree
	 * 
	 * @return element of type {@code K} at the root node
	 */
	K rootkey();
		
	/***
	 * Checks is the tree is empty or not
	 * 
	 * @return returns {@code boolean} value true if tree is empty else false
	 */
	boolean isEmpty();
	
	/***
	 * Returns a dynamic array which contains the inorder of the tree
	 * 
	 * @return dynamicArray of type {@code T} which has the inorder
	 */
	DynamicArray<V> inorder();
	
	/***
	 * Returns a dynamic array which contains the preorder of the tree
	 * 
	 * @return dynamicArray of type {@code T} which has the preorder
	 */
	DynamicArray<V> preorder();
	
	/***
	 * Returns a dynamic array which contains the postorder of the tree
	 * 
	 * @return dynamicArray of type {@code T} which has the postorder
	 */
	DynamicArray<V> postorder();
	
}
