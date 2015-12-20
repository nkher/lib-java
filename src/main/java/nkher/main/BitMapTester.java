package nkher.main;

import nkher.datastructures.map.BitMap;

public class BitMapTester {
	
	public static void main(String args[]) {
		
		BitMap bitmap = new BitMap(33551000); // handles a good number of bits !	
		System.out.println("size : " + bitmap.size() + " number of bits -> " + bitmap.getBitCount() + " " + Integer.MAX_VALUE);
	
		bitmap.set(200);
		bitmap.set(300);
		bitmap.set(250);
		
		System.out.println(bitmap.get(100));
		System.out.println(bitmap.get(200));
		System.out.println(bitmap.get(300));
	}
	
}
