package nkher.datastructures.graphs;

import java.util.*;

public class Graph<T> {
	
	private int graphId;

	private int size;

	private Map<Integer, GraphNode<?>> nodeMap;
	
	public Graph(String graphId) {

		this(graphId, new ArrayList<>());
	}
	
	public Graph(String graphId, ArrayList<GraphNode<?>> nodes) {
		nodeMap = new HashMap<>();
		for (GraphNode<?> node : nodes) {
			addNode(node);
		}
	}
	
	public void setGraphId(int graphId) {
		this.graphId = graphId;
	}
	
	public int getGraphId() {
		return graphId;
	}
	
	public int getNumberOfNodes() {
		return size;
	}
	
	public Collection<GraphNode<?>> getGraphNodes() {
		return nodeMap.values();
	}

	public GraphNode<?> getGraphNode(int nodeId) {

		if (nodeMap == null || nodeMap.isEmpty()) {
			throw new IllegalStateException("Node Map within graph is empty.");
		}

		return nodeMap.get(nodeId);
	}

	public void addNode(GraphNode<?> node) {
		if (nodeMap.containsKey(node.getNodeId())) {
			throw new IllegalArgumentException("Graph already contains the node.");
		}
		nodeMap.put(node.getNodeId(), node);
		size++;
	}

	public boolean isEmpty() {
		return (size == 0);
	}
}
