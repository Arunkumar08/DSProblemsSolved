package arun.problems.ds.graphs;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Topological sort means, when if there is a directed edge from U to V,
 * Then in the ordering, V should never appear U.
 * 
 * This Sort is possible only in the Directed Acyclic Graph (DAG)
 * DAG - Directed and no cycles are available in the graph.
 * 
 * Applications:
 * 	- Build systems (Where order of compiling packages matter)
 *  - Version Control systems (Keep the versions in order) 
 *  - Etc
 */
public class TopologicalSortOfGraph<T> {
	public void sortAndPrintGraph(Graph<T> graph, T visitingVertex, Stack<T> sortStack, Set<T> visitedElements) {
		// Get the childrens of vertex
		Collection<T> neigbours = graph.getNeigbours(visitingVertex, 1);
		visitedElements.add(visitingVertex);
		if (!neigbours.isEmpty()) {
			for(T vertex : neigbours) {
				if (!visitedElements.contains(vertex))
					sortAndPrintGraph(graph, vertex, sortStack, visitedElements);
			}
		}
		sortStack.push(visitingVertex);
	}
	public static void main(String a[]) {
		Graph<String> graph1 = new AdjacencyListGraph<String>();
		graph1.addVertex("Arun");
		graph1.addVertex("Ananth");
		graph1.addVertex("Srini");
		graph1.addVertex("Naveen");
		graph1.addVertex("Sat");
		graph1.addVertex("Master");
		graph1.addVertex("Dhins");
	
		//Add Vertices
		graph1.addEdge("Arun", "Ananth");
		graph1.addEdge("Arun", "Sat");
		graph1.addEdge("Ananth", "Srini");
		graph1.addEdge("Ananth", "Naveen");
		graph1.addEdge("Naveen", "Dhins");
		graph1.addEdge("Srini", "Master");
		
		Stack<String> sortStack = new Stack<String>();
		Set<String> visitedVertices = new HashSet<String>();
		TopologicalSortOfGraph<String> topSort = new TopologicalSortOfGraph<String>();
		
		Collection<String> vertices = graph1.getVertices();
		for (String vertex : vertices) {
			if (!visitedVertices.contains(vertex)) {
				topSort.sortAndPrintGraph(graph1, vertex, sortStack, visitedVertices);
			}
		}
		
		while(!sortStack.isEmpty()) {
			System.out.print(sortStack.pop());
			if(!sortStack.isEmpty())
				System.out.print("-->");
		}
	}
}
