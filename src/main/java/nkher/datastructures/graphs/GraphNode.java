package nkher.datastructures.graphs;

import java.util.Collections;
import java.util.List;

import nkher.exception.DataStructureEmptyException;

public class GraphNode<T extends Comparable<T>> {
	
	private int nodeId;
	
	private List<GraphNode<T>> neighbors;
	
	public GraphNode(int nodeId) {
		this(nodeId, Collections.emptyList());
	}
	
	public GraphNode(int nodeId, List<GraphNode<T>> neighbors) {
		this.nodeId = nodeId;
		setNeighbors(neighbors);
	}
	
	public int getNodeId() { return nodeId; }
	
	public List<GraphNode<T>> getNeighbors() { return neighbors; }
	
	public void addNeighbor(GraphNode<T> node) {
		neighbors.add(node);
	}
	
	public boolean isNeighbor(GraphNode<T> node) {
		return neighbors.contains(node);
	}
	
	public void setNeighbors(List<GraphNode<T>> neighbors) {
		if (null == neighbors) {
			throw new DataStructureEmptyException("Cannot accept null list of neighbors.");
		}
		this.neighbors = neighbors;
	}
}
