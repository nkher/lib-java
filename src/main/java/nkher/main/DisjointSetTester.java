package nkher.main;

import nkher.datastructures.disjointset.DisjointSet;

public class DisjointSetTester {

	public static void main(String args[]) {
		
		DisjointSet<Integer> disjointSet = new DisjointSet<Integer>();
		
		System.out.println("Initial Number of Components : " + disjointSet.numberOfComponents());
		
		System.out.println("Making sets 1 through 7.");
		disjointSet.makeset(1);
		disjointSet.makeset(2);
		disjointSet.makeset(3);
		disjointSet.makeset(4);
		disjointSet.makeset(5);
		disjointSet.makeset(6);
		disjointSet.makeset(7);
		System.out.println("Number of Components : " + disjointSet.numberOfComponents());
		
		System.out.println("Merging sets 1 and 2");
		disjointSet.mergesets(1, 2);
		System.out.println("Number of Components : " + disjointSet.numberOfComponents());
		
		System.out.println("Merging sets [2 and 3], [4 and 5], [6 and 7]");
		disjointSet.mergesets(2, 3);
		disjointSet.mergesets(4, 5);
		disjointSet.mergesets(6, 7);
		System.out.println("Number of Components : " + disjointSet.numberOfComponents());
		
		
		System.out.println("Finding representatives for 1, 2, 3 and 7");
		System.out.println(disjointSet.findset(1));
	    System.out.println(disjointSet.findset(2));
	    System.out.println(disjointSet.findset(3));
	    System.out.println(disjointSet.findset(7));
	}
}
