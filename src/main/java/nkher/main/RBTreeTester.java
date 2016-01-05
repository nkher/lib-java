package nkher.main;

import nkher.datastructures.lists.SinglyLinkedList;
import nkher.datastructures.trees.RedBlackTree;
import nkher.datastructures.trees.RedBlackTree.RedBlackNode;

public class RBTreeTester {
	
	
	public static void main(String args[]) {
		
		// Testing insertion
		
		RedBlackTree<Integer, Integer> rbTree = new RedBlackTree<>();
		
		// inserting the data
		rbTree.insert(new RedBlackNode<>(10, 10));		
		rbTree.insert(new RedBlackNode<>(20, 20));
		rbTree.insert(new RedBlackNode<>(-10, -10));
		rbTree.insert(new RedBlackNode<>(15, 15));
		rbTree.insert(new RedBlackNode<>(17, 17));		
		rbTree.insert(new RedBlackNode<>(40, 40));
		rbTree.insert(new RedBlackNode<>(50, 50));
		System.out.println("\n------Inserting 60------\n");
		rbTree.insert(new RedBlackNode<>(60, 60));
				
		for (SinglyLinkedList<RedBlackNode<Integer, Integer>> list : rbTree.levelorder()){
			System.out.println(list);
		}
	}
}
