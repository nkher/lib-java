package nkher.datastructures.graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Graph<T> {
	
	private String graphId;
	private int size;
	private Map<String, GraphNode<?>> nodeMap;
	
	public Graph(String graphId) {
		nodeMap = new HashMap<>();
	}
	
	public Graph(String graphId, ArrayList<GraphNode<?>> nodes) {
		nodeMap = new HashMap<>();
		for (GraphNode<?> node : nodes) {
			nodeMap.put(node.getNodeId(), node);
			size++;
		}
	}
	
	public void setGraphId(String graphId) {
		this.graphId = graphId;
	}
	
	public String getGraphId() {
		return graphId;
	}
	
	public int getNumberOfNodes() {
		return size;
	}
	
	public Collection<GraphNode<?>> getGraphNodes() {
		return nodeMap.values();
	}
}
