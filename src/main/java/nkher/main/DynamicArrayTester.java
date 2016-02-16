package nkher.main;


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
		
		System.out.println("Before : " + v.toString());
		System.out.println("Reversing");
		System.out.println(v.getReverseArray());
		v.reverse();
		System.out.println("After : " + v);
		
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
		v.replaceAt(10, 999);
		System.out.println(v.toString());
		System.out.println(v.getAt(12));
		v.replaceAt(12, 1);
		System.out.println(v.toString());

		
		System.out.println("Size  : " + v.size());
		System.out.println(v.toString());
		
		v.insertAtHead(-10);
		System.out.println("Size : " + v.size());
		System.out.println(v.toString() + " -- " + v.size());
		System.out.println("capacity : " + v.capacity());
		
		v.remove();
		v.remove();
		v.remove();
		v.remove();
		
		System.out.println(v.toString() + " -- " + v.size());
		System.out.println("capacity : " + v.capacity());
		
		v.remove();
		
		System.out.println(v.toString() + " -- " + v.size());
		System.out.println("capacity : " + v.capacity());
		
		v.remove();
		v.remove();
		v.remove();
		v.remove();
		v.remove();
		
		System.out.println(v.toString() + " -- " + v.size());
		System.out.println("capacity : " + v.capacity());
		
		v.remove();
		v.remove();
		
		System.out.println(v.toString() + " -- " + v.size());
		System.out.println("capacity : " + v.capacity());
		
		
		System.out.println("\n----------------------------------\n");
		
		
		
		DynamicArray<Integer> v1 = new DynamicArray<>();
		
		v1.insert(1);
		v1.insert(2);
		v1.insert(13);
		v1.insert(4);
		v1.insert(55);
		v1.insert(55);
		v1.insert(13);
		v1.insert(3);
		v1.insert(4);
		v1.insert(5);
		v1.insert(5);
		v1.insert(2);
		v1.insert(2);
		v1.insert(3);
		
		System.out.println(v1);
		
		v1.uniqueArray();
		
		System.out.println(v1);
		
	}

}
