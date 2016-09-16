package arun.problems.ds.graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AdjacencyListGraph<T> extends Graph<T> {

	/**
	 * Storage Map:
	 * Map<T, List<T>> ===  Vertex ---> List of vertices which has Edges.
	 */
	Map<T, Collection<T>> adjacencyMap;
	
	boolean includeSelfPaths = false;
	
	@Override
	public Collection<T> getNeigbours(T vertex, Integer distance) {
		final Set<T> neigbours = new LinkedHashSet<T>();
		if(adjacencyMap != null) {
			Collection<T> edges = adjacencyMap.get(vertex);
			neigbours.addAll(edges);
			if(distance > 1) {
				for(T vertexIn : edges) {
					if(!includeSelfPaths
							&& vertex.equals(vertexIn)) {
						continue;
					}
					neigbours.addAll(getNeigbours(vertexIn, distance - 1));
				}
			}
		}
		return neigbours;
	}

	@Override
	public Map<T, Collection<T>> getNeigboursOfAll(Integer distance) {
		Map<T, Collection<T>> neighbourMap = new HashMap<T, Collection<T>>();
		if(adjacencyMap != null) {
			if(distance == 1) {
				neighbourMap = adjacencyMap;
			} else {
				for(final Entry<T, Collection<T>> entry : adjacencyMap.entrySet()) {
					neighbourMap.put(entry.getKey(), getNeigbours(entry.getKey(), distance));
				}
			}
		}
		return neighbourMap;
	}

	@Override
	public Integer getInDegree(T vertex) {
		Integer degree = 0;
		if(adjacencyMap != null) {
			for(final Entry<T, Collection<T>> entry : adjacencyMap.entrySet()) {
				if(entry.getValue().contains(vertex)) {
					if(!includeSelfPaths
							&& vertex.equals(entry.getKey())) {						
						continue;
					}
					degree++;
				}
			}
		}
		return degree;
	}

	@Override
	public Integer getOutDegree(T vertex) {
		Integer degree = 0;
		if(adjacencyMap != null) {
			Collection<T> outEdges = adjacencyMap.get(vertex);
			if(outEdges != null){
				degree = outEdges.size();
			}
		}
		return degree;
	}

	@Override
	protected void addVertexIntoGraph(T vertex) {
		if(adjacencyMap == null) {
			adjacencyMap = new HashMap<T, Collection<T>>();
		}
		if(adjacencyMap.get(vertex) == null) {
			adjacencyMap.put(vertex, new ArrayList<T>());
		} else {
			/* Decide what to do. */
		}
	}

	@Override
	protected void addEdgeForVertex(T vertexOne, T vertexTwo) {
		if(adjacencyMap != null) {
			Collection<T> edgesList = adjacencyMap.get(vertexOne);
			if(edgesList != null) {
				edgesList.add(vertexTwo);
			} else {
				/* Vertex is not there. */
			}
		} else {
			/* Vertex is not there. */
		}
	}

	@Override
	public Boolean exists(T vertex) {
		if(adjacencyMap != null) {
			return adjacencyMap.containsKey(vertex);
		}
		return false;
	}

}
