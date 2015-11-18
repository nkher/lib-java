package nkher.main;

import nkher.datastructures.lists.DoublyLinkedList;
import nkher.datastructures.lists.DoublyLinkedList.DoublyNode;

public class DoublyLLTester {

	public static void main(String[] args) {
		
		DoublyLinkedList<Integer> dll1 = new DoublyLinkedList<Integer>();
		
		System.out.println(dll1.size() + " \n" + dll1.toString());
		
		dll1.insert(10);
		dll1.insert(20);
		dll1.insert(30);
		dll1.insert(40);
		System.out.println(dll1.size() + " \n" + dll1.toString());
		System.out.println("tail -> " + dll1.tail());
		
		dll1.insert(50);
		dll1.insert(80);
		dll1.insert(980);
		dll1.insert(24);
		System.out.println(dll1.size() + " \n" + dll1.toString());
		
		dll1.insert(12);
		System.out.println(dll1.size() + " \n" + dll1.toString());
		
		dll1.removeAt(7);
		System.out.println(dll1.size() + " \n" + dll1.toString());
		
		System.out.println("tail -> " + dll1.tail());
		
		dll1.removeAt(7);
		System.out.println(dll1.size() + " \n" + dll1.toString());
		
		System.out.println("head -> " + dll1.head());
		System.out.println("tail -> " + dll1.tail());
		
		dll1.insertAtHead(30);
		System.out.println(dll1.size() + " \n" + dll1.toString());
		System.out.println("head -> " + dll1.head());
		
		dll1.insert(new DoublyNode<Integer>(1477));
		
		System.out.println(dll1.size() + " \n" + dll1.toString());
		System.out.println("tail -> " + dll1.tail());
		
		dll1.removeAt(0);
		System.out.println("remove element at 0 ");
		System.out.println(dll1.size() + " \n" + dll1.toString());
		
		dll1.removeAt(0);
		System.out.println("remove element at 0 ");
		System.out.println(dll1.size() + " \n" + dll1.toString());
		
		dll1.removeAt(0);
		System.out.println("remove element at 0 ");
		System.out.println(dll1.size() + " \n" + dll1.toString());
		
		dll1.removeAt(0);
		System.out.println("remove element at 0 ");
		System.out.println(dll1.size() + " \n" + dll1.toString());
//		
//		dll1.removeAt(10);
//		System.out.println("remove element at 0 ");
//		System.out.println(dll1.size() + " \n" + dll1.toString());
		
		DoublyLinkedList<Integer> dll2 = dll1.clone();
		
		System.out.println(dll2.size() + " \n" + dll2.toString());
	}

}
