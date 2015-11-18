package nkher;

import nkher.datastructures.trees.AVLTree;

public class AVLTreeTester {

	public static void main(String[] args) {
		
		AVLTree<Integer, Integer> avltree = new AVLTree<Integer, Integer>();
	
		avltree.insert(10, 10);
		avltree.insert(20, 20);
		avltree.insert(30, 30);
		avltree.insert(40, 40);
		avltree.insert(50, 50);
		avltree.insert(25, 25);
		
		System.out.println(avltree.size());
		
		System.out.println(avltree.root().toString());
	}

}
