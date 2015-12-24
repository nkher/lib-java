package nkher.main;

import nkher.datastructures.tries.BasicTrie;


public class BasicTrieTester {
	
	public static void main(String args[]) {
		
		BasicTrie trie = new BasicTrie();
		trie.insert("jack");
		trie.insert("jack");
		trie.insert("jack");
		trie.insert("jack");
		trie.insert("jackson");
		trie.insert("jacket");
		trie.insert("jackman");
		trie.insert("jacksen");
		System.out.println("Size of trie : " + trie.size());
		
		System.out.println(trie.allKeys());
		
		System.out.println(trie.containsPrefix("jab"));
		System.out.println(trie.containsPrefix("jac"));
		
		System.out.println(trie.prefixSearchDArray("jack").toString());
		
		trie.removeKey("jackson");
					
		System.out.println("prefix search : " + trie.prefixSearch("jack"));
		
		System.out.println("Size of trie : " + trie.size());
		
		System.out.println(trie.allKeys());
		
	}
	

}
