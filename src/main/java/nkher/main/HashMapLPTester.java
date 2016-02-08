package nkher.main;

import nkher.datastructures.map.HashMapLP;

public class HashMapLPTester {

	public static void main(String[] args) {
		
		HashMapLP<String, Integer> map = new HashMapLP<>();
		
		map.put("Messi", 1);
		map.put("Ronaldo", 2);
		map.put("Iniesta", 3);
		map.put("Deco", 4);
		map.put("Rooney", 5);
		
		System.out.println("Size of hashmap : " + map.size());
		System.out.println("Keyset : " + map.keySet());
		
		System.out.println(map.containsKey("Iniesta"));
		System.out.println(map.containsKey("iniesta"));
		System.out.println(map.containsKey("Deco"));
		
		System.out.println(map.get("ronaldo"));
		System.out.println(map.get("Deco"));
		System.out.println(map.get("Rooney"));
		System.out.println(map.get("Messi"));
	}
}
