package arun.problems.ds.graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * @author akumars
 *
 * @param <T>
 */
public class DepthFirstSearch<T> extends GraphSearch<T> {

	private Graph<T> graphToBeused;
	
	/**
	 * @param graph
	 */
	public DepthFirstSearch(final Graph<T> graph) {
		this.graphToBeused = graph;
	}
	
	/**
	 * 
	 */
	public DepthFirstSearch() {
		/* Nothing*/
	}

	@Override
	public boolean searchElement(T vertex,
								 Graph<T> graph) {

		
		return false ;
	}

	/* (non-Javadoc)
	 * @see arun.problems.ds.graphs.GraphSearch#searchPath(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Collection<T> searchPath(T startingVertex,
									T endVertex,
									Graph<T> graph) {
		
		final Collection<T> pathList = new ArrayList<T>();
		Graph<T> graphToBeSearched = graph;

		if(graphToBeSearched == null)
			return pathList;
		
		if(graphToBeSearched.exists(startingVertex)
				|| graphToBeSearched.exists(endVertex)) {
			/* Throw exception or return empty list. */
		}
		
		final Set<T> visitedElements = new HashSet<T>();
		final Stack<T> backTrackingStack = new Stack<T>();
		final Map<T, T> visitedParentMap = new HashMap<T, T>();
		
		backTrackingStack.push(startingVertex);
		
		while(!backTrackingStack.isEmpty()) {

			T vertexInSearchContext = backTrackingStack.pop();
			System.out.println("DFS: Visiting Node: " + vertexInSearchContext);

			if(vertexInSearchContext.equals(endVertex)) {
				return getPathListFromVisitedMap(visitedParentMap, vertexInSearchContext);
			}
			visitedElements.add(vertexInSearchContext);
			Collection<T> neighboursList = graphToBeSearched.getNeighbours(vertexInSearchContext);
			for (T neigbour : neighboursList) {
				if(!visitedElements.contains(neigbour)) {
					visitedElements.add(neigbour);
					backTrackingStack.push(neigbour);
					visitedParentMap.put(neigbour, vertexInSearchContext);
				}
			}	
		}
		return pathList;
	}

	@Override
	public Collection<T> searchPath(T startingVertex, T endVertex) {
			return searchPath(startingVertex, endVertex, graphToBeused);
	}
}
