package nkher.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

import nkher.exception.DataStructureEmptyException;

public class GraphNode<T extends Comparable<T>> {
	
	private String nodeId;
	
	private List<GraphNode<T>> neighbors;
	
	public GraphNode(String nodeId) {
		this.nodeId = nodeId;
		neighbors = new ArrayList<>();
	}
	
	public GraphNode(String nodeId, List<GraphNode<T>> neighbors) {
		this.nodeId = nodeId;
		setNeighbors(neighbors);
	}
	
	public String getNodeId() { return nodeId; }
	
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
