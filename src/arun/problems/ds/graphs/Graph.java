package arun.problems.ds.graphs;

import java.util.Collection;
import java.util.Map;

public abstract class Graph<T> {

	private int numberOfVertices;
	private int numberOfEdges;
	
	public Graph() {
		numberOfVertices = 0;
		numberOfEdges = 0;
	}
	
	/**
	 * This method returns the neighbours for the given vertex at given distance.
	 * 
	 * @param vertex
	 * @param distance
	 * @return
	 */
	public abstract Collection<T> getNeigbours(final T vertex, final Integer distance);

	/**
	 * This method returns the neighbours of all the vertices at given distance.
	 *
	 * @return
	 */
	public abstract Map<T, Collection<T>> getNeigboursOfAll(final Integer distance);
	
	/**
	 * Returns the number of incoming edges for the given vertex.
	 *
	 * @param vertex
	 * @return
	 */
	public abstract Integer getInDegree(final T vertex);
	
	/**
	 * Returns the number of outgoing edges for the given vertex.
	 *
	 * @param vertex
	 * @return
	 */
	public abstract Integer getOutDegree(final T vertex);
	
	/**
	 * Adds the given vertex into the graph.
	 *
	 * @param vertex
	 */
	protected abstract void addVertexIntoGraph(final T vertex);
	
	/**
	 * Adds the edge between the vertex.
	 * Edge starts at vertexOne and ends at vertextTwo.
	 *
	 * @param vertexOne
	 * @param vertexTwo
	 */
	protected abstract void addEdgeForVertex(final T vertexOne, final T vertexTwo);

	/**
	 * This method returns the one-hop neighbours for the given vertex.
	 * 
	 * @param vertex
	 * @return
	 */
	public Collection<T> getNeighbours(final T vertex) {
		return getNeigbours(vertex, 1);
	}
	
	/**
	 * Returns the total number of edges for the vertex [Both in and out.]
	 * @param vertex
	 * @return
	 */
	public Integer getDegree(final T vertex) {
		return getInDegree(vertex) + getOutDegree(vertex);
	}

	/**
	 * Adds the vertext into the graph.
	 * 
	 * @param vertex
	 */
	public void addVertex(final T vertex) {
		addVertexIntoGraph(vertex);
		numberOfVertices++;
	}
	
	/**
	 * Adds the edge between the vertex.
	 * Edge starts at vertexOne and ends at vertextTwo
	 * 
	 * @param vertexOne
	 * @param vertexTwo
	 */
	public void addEdge(final T vertexOne, final T vertexTwo) {
		addEdgeForVertex(vertexOne, vertexTwo);
		numberOfEdges++;
	}

	/**
	 * Total no. of vertices available in the graph.
	 * 
	 * @return
	 */
	public int getNumberOfVertices() {
		return numberOfVertices;
	}

	/**
	 * Total no. of edges available in the graph.
	 *
	 * @return
	 */
	public int getNumberOfEdges() {
		return numberOfEdges;
	}

	public abstract Boolean exists(T vertex);
}
