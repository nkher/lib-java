package nkher.main;

import nkher.datastructures.lists.DynamicArray;
import nkher.datastructures.lists.SinglyLinkedList;
import nkher.datastructures.trees.BinarySearchTree;
import nkher.datastructures.trees.BinarySearchTree.BSTNode;


public class BinarySearchTreeTester {
	
	public static void main(String args[]) {
		
		// BST has an integer key and name as the value
		// Salary is the key and the name of the person signifies that the person earns a salary = key
		BinarySearchTree<Integer, String> salaryTree = new BinarySearchTree<Integer, String>();
		
		System.out.println("Height : " + salaryTree.height());
		
		salaryTree.insert(new BSTNode<Integer, String>(150, "Joe"));
		salaryTree.insert(new BSTNode<Integer, String>(200, "Shetty"));
		salaryTree.insert(new BSTNode<Integer, String>(900, "Farhan"));
		salaryTree.insert(new BSTNode<Integer, String>(500, "Keshav"));
		salaryTree.insert(new BSTNode<Integer, String>(1000, "Gennady"));
		salaryTree.insert(new BSTNode<Integer, String>(15000, "mehta"));
		salaryTree.insert(new BSTNode<Integer, String>(75, "Kasoor"));
		salaryTree.insert(new BSTNode<Integer, String>(677, "messi"));
		salaryTree.insert(new BSTNode<Integer, String>(344, "iniesta"));
		salaryTree.insert(new BSTNode<Integer, String>(98, "Milkha"));
		salaryTree.insert(new BSTNode<Integer, String>(117, "Saleem"));
		salaryTree.insert(new BSTNode<Integer, String>(53, "Sliquness"));
		salaryTree.insert(new BSTNode<Integer, String>(14, "Ronaldo"));
		salaryTree.insert(new BSTNode<Integer, String>(-90, "Hritik"));
		salaryTree.insert(new BSTNode<Integer, String>(67, "hero"));
		
		System.out.println(salaryTree.size());
		
		// System.out.println(salaryTree.root().toString());
		
		DynamicArray<BSTNode<Integer, String>> result = salaryTree.inorder();
		
		// System.out.println(result.toString());
		
		BSTNode<Integer, String> node = salaryTree.search(15000);
		System.out.println(node.value());
		
		result.clear();
		System.out.println("Result is Clear : " + result.toString());
		result = salaryTree.rangeSearch(150, 999);
		
//		System.out.println("Range search : ");
//		for (BSTNode<Integer, String> n : result) {
//			System.out.println(n.toString());
//		}
		
		// System.out.println("Height : " + salaryTree.height());
				
		// getting the nodes in level order fashion
		DynamicArray<SinglyLinkedList<BSTNode<Integer, String>>> levelorder = salaryTree.levelorder();
		
		int i = 0;
//		for (SinglyLinkedList<BSTNode<Integer, String>> level : levelorder) {
//			System.out.println("Level " + (i++) + " : " + level.toString());
//			System.out.println("-----------");
//		}
		
		
		// delete 677 and then 500 - not working properly
		
		System.out.println("io keys : " + salaryTree.inorderkeys().toString());
		salaryTree.remove(677);
		salaryTree.remove(500);
		salaryTree.remove(150);
		salaryTree.remove(200);
		salaryTree.remove(117);
		System.out.println("io keys : " + salaryTree.inorderkeys().toString());
		
		
		System.out.println("---------------------------------------------------------------");
		
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
		
		bst.insert(new BSTNode<Integer, Integer>(10, 10));
		bst.insert(new BSTNode<Integer, Integer>(5, 5));
		bst.insert(new BSTNode<Integer, Integer>(15, 15));
		bst.insert(new BSTNode<Integer, Integer>(7, 7));
		bst.insert(new BSTNode<Integer, Integer>(9, 9));
		bst.insert(new BSTNode<Integer, Integer>(12, 12));
		bst.insert(new BSTNode<Integer, Integer>(17, 17));
		
		DynamicArray<SinglyLinkedList<BSTNode<Integer, Integer>>> lo = bst.levelorder();
		int j = 0;
		System.out.println(bst.size());
		
		for (SinglyLinkedList<BSTNode<Integer, Integer>> level : lo) {
			System.out.println("Level " + (j++) + " : " + level.toString());
			System.out.println("-----------");
		}
		
		System.out.println("Inorder keys : " + bst.inorderkeys().toString());
		bst.remove(10);
		System.out.println("Inorder keys : " + bst.inorderkeys().toString());
		
		System.out.println(bst.size());
		
	}
}
