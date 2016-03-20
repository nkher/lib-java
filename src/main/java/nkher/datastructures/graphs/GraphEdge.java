package nkher.datastructures.graphs;

public class GraphEdge<T> {
	
	private String edgeId;
	private GraphNode<?> nodeOne;
	private GraphNode<?> nodeTwo;
	
	public GraphEdge(GraphNode<?> nodeOne, GraphNode<?> nodeTwo) {
		this.nodeOne = nodeOne;
		this.nodeTwo = nodeTwo;
	}
	
	public String edgeId() { return edgeId; }
	
	public GraphNode<?> getNodeOne() { return nodeOne; }
	
	public GraphNode<?> getNodeTwo() { return nodeTwo; }
	
	public void setNodeOne(GraphNode<?> nodeOne) {
		this.nodeOne = nodeOne;
	}
	
	public void setNodeTwo(GraphNode<?> nodeTwo) {
		this.nodeTwo = nodeTwo;
	}
}
