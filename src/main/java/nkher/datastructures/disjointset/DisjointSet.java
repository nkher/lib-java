package nkher.datastructures.disjointset;

import java.util.HashMap;
import java.util.Map;
import nkher.exception.NodeDoesNotExistException;

/***
 * This is an implementation of the disjoint set data structure that uses the root trees representation.
 * It also called the union find data structure or the merge find set data structure and is used in a variety
 * of applications like finding connected components in an undirected graph or implementing Kruskal's algorithm
 * to find the minimum Spanning Tree of a graph. </br>
 * 
 * Two major heuristics used in this implementation are : </br>
 * 		1. Union By Rank </br>
 * 		2. Path Compression </br>
 * 
 * The implementation is done using a hashdataNodeMap which makes it easier to implement the findset() method.</br>
 * 
 * Reference : https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/DisjointSet.java </br>
 * 
 * Time Complexity of this implementation is O(m * alpha(m, n)) where, </br>
 * 		1. m = number of times makeset(), mergesets() and findset() is called </br>
 * 		2. n = number of times makeset() operation is called </br>
 * 		3. alpha(m, n) is a slowly growing inverse of Ackermann’s function which is <= 4 practically (See Proof. in Prof. Cormens Book - Introduction to Algorithms) </br>
 *  
 * @author nameshkher
 *
 */
public class DisjointSet<T extends Comparable<T>> {
	
	private int numberOfComponents; // number of components in the data structure
	private Map<T, DisjointSetNode> dataNodeMap;
	
	public DisjointSet() {
		dataNodeMap = new HashMap<T, DisjointSetNode>();
		numberOfComponents = 0;
	}
	
	public class DisjointSetNode {
		private T data;
		private DisjointSetNode parent;
		private int rank;
				
		public DisjointSetNode(T data, int rank) {
			this.data = data;
			this.rank = rank;
			this.parent = this;
		}
		
		public T data() {
			return data;
		}
		
		public DisjointSetNode parent() {
			return parent;
		}
		
		public void parent(DisjointSetNode parent) {
			this.parent = parent;
		}
		
		public int rank() {
			return rank;
		}
	}
	
	/***
	 * Makes a set of a single element. The parent of this node would point to itself.
	 * @param data
	 */
	public void makeset(T data) {
		DisjointSetNode new_node = new DisjointSetNode(data, 0); /* Parent initialization happens within */
		// put the data within the map
		dataNodeMap.put(data, new_node);
		numberOfComponents++;
	}
	
	
	private DisjointSetNode findset(DisjointSetNode n) {
		DisjointSetNode parent = n.parent();
		if (parent.equals(n)) { // finding the node that is the parent of itself
			return parent;
		}
		n.parent = findset(n.parent);
		return n.parent;
	}
	
	/***
	 * Function to find the set that the node belongs to. It returns the representative of the set that this node belongs to.
	 * @param n
	 * @return
	 */
	public T findset(T data) {
		T setRepresentative = findset(dataNodeMap.get(data)).data;
		if (null == setRepresentative) {
			throw new NodeDoesNotExistException("Node does not exist");
		}
		return setRepresentative;
	}
	
	/***
	 * Merges both the sets into a single set that would after merging be represented by a single Node.
	 * Union By Ranking is followed here.
	 *  
	 * @param elem1
	 * @param elem2
	 */
	public void mergesets(T elem1, T elem2) {
		// Get the parents for both the nodes from the set
		DisjointSetNode p1 = findset(dataNodeMap.get(elem1));
		DisjointSetNode p2 = findset(dataNodeMap.get(elem2));
		
		// check if they are already in the same set
		if (p1.data.equals(p2.data)) {
			return;
		}
		
		// Union by rank
		if (p1.rank >= p2.rank) {
			p1.rank = (p1.rank == p2.rank) ? p1.rank + 1 : p1.rank; //  increment rank if both ranks are same
			p2.parent = p1;
		}
		else {
			p1.parent = p2;
		}
		numberOfComponents--;
	}
	
	public int numberOfComponents() {
		return numberOfComponents;
	}
}
