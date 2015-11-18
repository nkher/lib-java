package nkher;

import nkher.datastructures.lists.SinglyLinkedList;
import nkher.datastructures.lists.SinglyLinkedList.SinglyNode;


public class LinkedListTester {

	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		System.out.println(sll.size());
		
		sll.insert(10);
		sll.insert(20);		
		
		sll.insert(30);
		sll.insert(40);
		System.out.println(sll.toString());
		
		sll.removeAt(3);
				
		System.out.println(sll.toString());
		
		sll.remove(20);
		System.out.println(sll.toString());
		
		sll.insert(70);
		sll.insert(100);
		sll.insert(70);
		sll.insert(70);
		System.out.println(sll.toString());
		
		sll.remove(70);
		sll.remove(70);
		sll.remove(70);
		System.out.println(sll.toString());
		
		sll.remove(100);
		System.out.println(sll.toString());
		
		sll.remove(10);
		System.out.println(sll.toString());
		
		sll.insertAtHead(1400);
		System.out.println(sll.toString());
		
		SinglyLinkedList<Integer> sll2 = sll.clone();
		System.out.println(sll2.toString());
		
		System.out.println("Head -> " + sll.head());
		
		sll2.removeAt(0);
		System.out.println("sll 1 : " + sll.toString());
		
		sll2.insert(107);
		System.out.println("sll 2 : " + sll2.toString());
		
		SinglyNode<Integer> sNode = new SinglyNode<Integer>(777);
		sll.insert(sNode);
		
		System.out.println("---------------");
		
		System.out.println("Head : " + sll.head());
		System.out.println("Tail : " + sll.tail());
		
		System.out.println("sll 1 : " + sll.toString());
		sll.removeAt(2);
		System.out.println("sll 1 : " + sll.toString());
		
		
		System.out.println(sll2.head() + " " + sll2.tail());
		
		sll2.append(sll);
		
		System.out.println("1 : " + sll2);
		System.out.println("2 : " + sll);
		
		System.out.println(sll2.head() + " " + sll2.tail());
		
		sll2.append(sll);
		
		System.out.println(sll2);
		
		System.out.println(sll2.head() + " " + sll2.tail());
		
		System.out.println("-------------------------------------");
		
		System.out.println("1 : " + sll);
		System.out.println("2 : " + sll2);
		
		for (Integer i : sll2) {
			System.out.println(i);
		}
		
	}
}
