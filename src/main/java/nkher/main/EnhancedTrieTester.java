package nkher.main;

import nkher.datastructures.tries.EnhancedTrie;

public class EnhancedTrieTester {

	public static void main(String[] args) {
		
		EnhancedTrie trie = new EnhancedTrie();
		
		System.out.println("Size of trie : " + trie.size());
		trie.insert("jack");
		trie.insert("jack");
		trie.insert("jack");
		trie.insert("jack");
		trie.insert("jackson");
		trie.insert("jacket");
		trie.insert("jackman");
		trie.insert("jacksen");
		System.out.println("Size of trie : " + trie.size());
		System.out.println(trie.toString());
		
		System.out.println(trie.allKeys());
		
		System.out.println(trie.containsPrefix("jab"));
		System.out.println(trie.containsPrefix("jac"));
		
		System.out.println(trie.prefixSearchDArray("jack").toString());
		
		trie.removeKey("jackson");
		
		System.out.println(trie.prefixSearchDArray("jack").toString());
		
		trie.removeKey("jack", 3);
	
		System.out.println(trie.prefixSearch("jack"));
		
		System.out.println("Size of trie : " + trie.size());
		
		System.out.println(trie.allKeys());
		
		System.out.println(trie.toString());
	}

}
