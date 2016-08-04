package nkher.datastructures.graphs;

public class GraphEdge<T> {
	
	private String edgeId;

	private GraphNode<?> nodeOne;

	private GraphNode<?> nodeTwo;
	
	public GraphEdge(GraphNode<?> nodeOne, GraphNode<?> nodeTwo) {

		if (nodeOne == null || nodeTwo == null) {
			throw new IllegalArgumentException("Cannot have an edge with a null node.");
		}

		this.nodeOne = nodeOne;
		this.nodeTwo = nodeTwo;
	}
	
	public String edgeId() { return edgeId; }
	
	public GraphNode<?> getNodeOne() { return nodeOne; }
	
	public GraphNode<?> getNodeTwo() { return nodeTwo; }
}
