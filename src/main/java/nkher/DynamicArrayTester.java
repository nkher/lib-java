package nkher;

import java.util.ArrayList;

import nkher.datastructures.lists.DynamicArray;

public class DynamicArrayTester {

	public static void main(String[] args) {
		
		DynamicArray<Integer> v = new DynamicArray<Integer>();	
		
		v.insert(1);
		v.insert(2);
		v.insert(3);
		v.insert(4);
		v.insert(5);
		v.insert(1);
		v.insert(233);
		v.insert(1);
		v.insert(90);
		v.insert(100);
		v.insert(55);
		v.insert(67);
		v.insert(786);
		v.insert(345);
		v.insert(1);
		System.out.println(v.toString());
		System.out.println(v.size());
		v.removeAt(8);
		System.out.println(v.toString() + " " + v.size());
		v.removeAt(13);
		System.out.println(v.toString());
		v.setAt(10, 999);
		System.out.println(v.toString());
		System.out.println(v.getAt(12));
		v.setAt(12, 1);
		System.out.println(v.toString());

		
		System.out.println("Size  : " + v.size());
		System.out.println(v.toString());
		
		v.insertAtHead(-10);
		System.out.println("Size : " + v.size());
		System.out.println(v.toString() + " -- " + v.size());
		
		v.clear();
		
		System.out.println(v.toString() + " -- " + v.size());
		
		Integer a[] = {1, 2, 3};
		
		System.out.println("jwbewj : " + a.toString());
		
		v.fill(a);
		
		System.out.println(v.toString() + " -- " + v.size());
		
		v.insert(4);
		v.insert(4);
		v.insert(4);
		v.insert(4);
		v.insert(4);
		v.insert(4);
		v.insert(4);
		v.insert(4);
		v.insert(4);
		v.insert(4);
		v.insert(4);
		v.insert(4);
		v.insert(4);
		
		System.out.println(v.toString() + " -- " + v.size());
		
//		Integer[] arr = (Integer[]) v.toArray();
//		System.out.println(arr.toString());
		
		ArrayList<Integer> list = v.toArrayList();

		System.out.println(list.toString());

	}

}
