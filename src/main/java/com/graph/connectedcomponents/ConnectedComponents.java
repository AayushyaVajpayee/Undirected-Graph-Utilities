package com.graph.connectedcomponents;
import com.graph.entity.Graph;

public class ConnectedComponents {
	private boolean[] marked;
	private int[] id;
	private int count;

	public ConnectedComponents(Graph graph) {
		marked = new boolean[graph.getVertexCount()];
		id = new int[graph.getVertexCount()];
		for (int vertex = 0; vertex < graph.getVertexCount(); vertex++) {
			if (!marked[vertex]) {
				depthFirstSearch(graph, vertex);
				count++;
			}
		}
	}

	public boolean isConnected(int vertex1, int vertex2) {
		return id[vertex1] == id[vertex2];
	}

	public int getCount() {
		return count;
	}

	public int getId(int vertex) {
		return id[vertex];
	}

	private void depthFirstSearch(Graph graph, int startingVertex) {
		marked[startingVertex] = true;
		id[startingVertex] = count;
		for (int vertex : graph.getAdjacentVertices(startingVertex))
			if (!marked[vertex])
				depthFirstSearch(graph, vertex);
	}

}
