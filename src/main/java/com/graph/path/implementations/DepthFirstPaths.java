package com.graph.path.implementations;

import java.util.Stack;

import com.graph.entity.Graph;
import com.graph.path.interfaces.Paths;

public class DepthFirstPaths implements Paths {

	private boolean[] marked;
	private int[] edgeTo;
	private int startingVertex;

	public DepthFirstPaths(Graph graph, int startingVertex) {
		this.startingVertex = startingVertex;
		this.marked = new boolean[graph.getVertexCount()];
		this.edgeTo = new int[graph.getVertexCount()];
		depthFirstSearch(graph, startingVertex);
	}

	private void depthFirstSearch(Graph graph, int startingVertex) {
		marked[startingVertex] = true;
		for (int w : graph.getAdjacentVertices(startingVertex)) {
			if (!marked[w]) {
				depthFirstSearch(graph, w);
				edgeTo[w] = startingVertex;
			}
		}
	}

	@Override
	public boolean hasPathTo(int vertex) {
		return marked[vertex];
	}

	@Override
	public Stack<Integer> pathTo(int vertex) {
		assertPathExists(vertex);
		Stack<Integer> path = new Stack<>();
		for (int x = vertex; x != startingVertex; x = edgeTo[x])
			path.push(x);
		path.push(startingVertex);
		return path;
	}

	private void assertPathExists(int vertex) {
		if (!hasPathTo(vertex))
			throw new RuntimeException("There exists no path between " + startingVertex + " and " + vertex);
	}
}
