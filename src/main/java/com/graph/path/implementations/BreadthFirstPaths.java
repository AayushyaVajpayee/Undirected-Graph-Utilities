package com.graph.path.implementations;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.graph.entity.Graph;
import com.graph.path.interfaces.Paths;

public class BreadthFirstPaths implements Paths {

	private boolean[] marked;
	private int[] edgeTo;
	private int startingVertex;

	public BreadthFirstPaths(Graph graph, int startingVertex) {
		this.startingVertex = startingVertex;
		breadthFirstSearch(graph, startingVertex);
	}

	private void breadthFirstSearch(Graph graph, int startingVertex) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(startingVertex);
		marked[startingVertex] = true;
		while (!queue.isEmpty()) {
			int currentVertex = queue.remove();
			for (int vertex : graph.getAdjacentVertices(currentVertex)) {
				if (!marked[vertex]) {
					queue.add(vertex);
					marked[vertex] = true;
					edgeTo[vertex] = currentVertex;
				}
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
		for (int x = vertex; x != startingVertex; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(startingVertex);
		return path;
	}

	private void assertPathExists(int vertex) {
		if (!hasPathTo(vertex))
			throw new RuntimeException("There exists no path between " + startingVertex + " and " + vertex);
	}

}
