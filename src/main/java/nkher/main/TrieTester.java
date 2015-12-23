package nkher.main;

import nkher.datastructures.tries.Trie;

public class TrieTester {

	public static void main(String[] args) {
		
		Trie trie = new Trie();
		
		System.out.println("Size of trie : " + trie.size());
		trie.insert("jack");
		trie.insert("jack");
		trie.insert("jack");
		trie.insert("jack");
		trie.insert("jackson");
		trie.insert("jacket");
		trie.insert("jackman");
		System.out.println("Size of trie : " + trie.size());
		
		System.out.println(trie.containsPrefix("jab"));
		System.out.println(trie.containsPrefix("jac"));
		
		System.out.println(trie.prefixSearchDArray("jack").toString());
	}

}
