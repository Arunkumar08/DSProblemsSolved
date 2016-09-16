package arun.problems.ds.graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Stack;

/**
 * There are two basic methods to search an element in a graph data structures.
 * 
 * DFS: - Depth First Search
 * BFS: - Breadth First Search
 * 
 * @author akumars
 *
 */
public abstract class GraphSearch<T> {
	
	public abstract boolean searchElement(T vertex, Graph<T> grpah);

	public abstract Collection<T> searchPath(T startingVertex, T endVertex);
	
	/**
	 * @param visitedParentMap
	 * @param vertexInSearchContext
	 * @return
	 */
	public Collection<T> getPathListFromVisitedMap(final Map<T, T> visitedParentMap,
													final T vertexInSearchContext) {
		Stack<T> pathStack = new Stack<T>();
		T parent = vertexInSearchContext;
		while(parent != null) {
			pathStack.push(parent);
			parent = visitedParentMap.get(parent);
		}
		
		Collection<T> pathList = new ArrayList<T>();
		while(!pathStack.isEmpty()) {
			pathList.add(pathStack.pop());
		}
		return pathList;
	}

	/**
	 * @param startingVertex
	 * @param endVertex
	 * @param graph
	 * @return
	 */
	public abstract Collection<T> searchPath(T startingVertex, T endVertex, Graph<T> graph);

}
