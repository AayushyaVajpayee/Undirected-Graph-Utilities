package com.graph.entity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Graph {

	private final int vertexCount;
	private ArrayList<Set<Integer>> adjacencyList;
	private int edgeCount;

	public Graph(int verticesCount) {
		this.vertexCount = verticesCount;
		this.edgeCount = 0;
		adjacencyList = new ArrayList<>(verticesCount);
		for (int v = 0; v < verticesCount; v++)
			adjacencyList.add(new HashSet<>());

	}

	void addEdge(int v, int w) {
		adjacencyList.get(v).add(w);
		adjacencyList.get(w).add(v);
		edgeCount++;
	}

	void removeEdge(int v, int w) {
		adjacencyList.get(v).remove(w);
		adjacencyList.get(w).remove(v);
		edgeCount--;
	}

	public Set<Integer> getAdjacentVertices(int v) {
		return adjacencyList.get(v);
	}

	public int getVertexCount() {
		return vertexCount;
	}

	public int getEdgeCount() {
		return edgeCount;
	}

}
