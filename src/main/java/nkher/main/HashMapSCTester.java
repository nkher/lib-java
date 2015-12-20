package nkher.main;

import nkher.datastructures.map.HashMapSC;

public class HashMapSCTester {
	
	public static void main(String args[]) {
		
		HashMapSC<Integer, String> map = new HashMapSC<Integer, String>();
			
		map.put(1, "namesh");
		map.put(2, "sarika");
		map.put(3, "eshan");
		map.put(4, "utsav");
		map.put(5, "amit");
		
		System.out.println("Size : " + map.size());

		System.out.println(map.get(4));
		
		System.out.println(map.toString());
		
		map.clear();
		
		for (int i=0; i<100000000; i++) {
			map.put(i, i+"1");
		}
		System.out.println("Size : " + map.size());
		System.out.println("Alpha : " + map.loadFactor());
	}
}
