package com.graph.path.interfaces;

public interface Paths {
	
	boolean hasPathTo(int vertex);

	Iterable<Integer> pathTo(int vertex);
}
