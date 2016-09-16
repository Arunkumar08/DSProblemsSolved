package arun.problems.ds.graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import arun.problems.ds.graphs.model.Person;

/**
 * This implementation of graph uses a 2D array to store the edges between the vertex
 * 
 *    0 1 2 3 4 5
 *  0 0 1 0 0 0 0
 *  1 1 0 0 0 0 0
 *  2 1 1 1 1 1 1
 *  3 0 0 0 0 1 0
 *  4 0 0 1 0 1 0
 *  5 1 0 0 0 1 0
 *  
 *  Row and Columns indicates the Vertexes, 1 indicates Edge existing between them. 
 *  Storage complexity will be |V| * |V| as we have to store all the possible combinations of vertexes.
 *   
 * @author akumars
 *
 */
public class AdjacencyMatrixGraph<T> extends Graph<T> {

	/**
	 * Maps the vertex to the index of the matrix.
	 */
	private final List<T> vertexList;
	
	/* Matrix to store the relation. */
	private int[][] relationshipMatrix;
	
	public AdjacencyMatrixGraph() {
		vertexList = new ArrayList<T>();
		relationshipMatrix = new int[7][7];
	}

	/* (non-Javadoc)
	 * @see arun.problems.ds.graphs.Graph#getNeigbours(java.lang.Object, java.lang.Integer)
	 */
	@Override
	public List<T> getNeigbours(T vertex, Integer distance) {
		int vertexIndex = vertexList.indexOf(vertex);
		final List<T> neighboursList = new ArrayList<T>();
		if (vertexIndex != -1) {
			for(int column = 0; column < getNumberOfVertices(); column++) {
				if (relationshipMatrix[vertexIndex][column] == 1) {
					if (distance == 1) {
						neighboursList.add(vertexList.get(column));
					} else {
						neighboursList.addAll(getNeigbours(vertexList.get(column), distance-1));
					}
				}
			}
		}
		return neighboursList;
	}

	/* (non-Javadoc)
	 * @see arun.problems.ds.graphs.Graph#getNeigboursOfAll(java.lang.Object)
	 */
	@Override
	public Map<T, Collection<T>> getNeigboursOfAll(final Integer distance) {

		Map<T, Collection<T>> vertexMap = new HashMap<T, Collection<T>>();

		/* Find the relationship for each vertex at given distance using matrix multiplication. */
		int[][] relationShipAtGiveDistMatrix = getNeighboursUsingMatrixMultiplication(relationshipMatrix, relationshipMatrix, distance);

		for (int row = 0; row < getNumberOfVertices(); row++) {
			final List<T> relationshipVertexList = new ArrayList<T>();
			for (int column = 0; column < getNumberOfVertices(); column++) {
				if (relationShipAtGiveDistMatrix[row][column] > 0) {
					relationshipVertexList.add(vertexList.get(column));
				}
			}
			vertexMap.put(vertexList.get(row), relationshipVertexList);
		}
		return vertexMap;
	}

	/**
	 * @param matrix1
	 * @param matrix2
	 * @param distance
	 * @return
	 */
	public int[][] getNeighboursUsingMatrixMultiplication(int[][] matrix1, int[][]matrix2, Integer distance) {

		if(distance == 1) {
			return matrix1;
		}
		int[][] multipliedMatrix = multiplyMatrix(matrix1, matrix2);
		System.out.println("Stack seperator:");
		return getNeighboursUsingMatrixMultiplication(multipliedMatrix, relationshipMatrix, distance-1);
	}
	
	/**
	 * @param matrix1
	 * @param matrix2
	 * @return
	 */
	private int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2) {
		int length = matrix1.length;
		int outMatrix[][] = new int[length][length];
		for( int i = 0; i < length; i++) {
			for( int j = 0; j < length; j++) {
				int value = 0;
				for( int k = 0; k < length; k++) {
					value = (value + (matrix1[i][k]) * (matrix2[k][j]));
				}
				outMatrix[i][j] = value;
				System.out.print(" " + value);
			}
			System.out.println("");
		}
		
		return outMatrix;
	}

	/* (non-Javadoc)
	 * @see arun.problems.ds.graphs.Graph#getInDegree(java.lang.Object)
	 */
	@Override
	public Integer getInDegree(T vertex) {
		int inDegreeCount = 0;
		if (vertexList.contains(vertex)) {
			int vertexIndex = vertexList.indexOf(vertex);
			for(int i = 0; i < getNumberOfEdges(); i ++) {
				if (relationshipMatrix[i][vertexIndex] == 1)
					inDegreeCount++;
			}
		} else {
			/* Throw exception ot return 0. */ 
		}
		return inDegreeCount;
	}

	/* (non-Javadoc)
	 * @see arun.problems.ds.graphs.Graph#getOutDegree(java.lang.Object)
	 */
	@Override
	public Integer getOutDegree(T vertex) {
		int outDegreeCount = 0;
		if (vertexList.contains(vertex)) {
			int vertexIndex = vertexList.indexOf(vertex);
			for(int i = 0; i < getNumberOfEdges(); i ++) {
				if (relationshipMatrix[vertexIndex][i] == 1)
					outDegreeCount++;
			}
		} else {
			/* Throw exception ot return 0. */ 
		}
		return outDegreeCount;
	}

	/**
	 * Addition of the vertex includes:
	 * 	Adding a Row and Column for the vertex.
	 *  Adding 0's for the vertex in row and column.
	 *  
	 */
	@Override
	protected void addVertexIntoGraph(T vertex) {

		if(vertexList.contains(vertex)) {
			/* Vertex is already present in the Graph. */
			//throw new Exception; 		
		} else {
			
			/* Check if the size of matrix needs to be increased. */
			if(relationshipMatrix[0].length == getNumberOfVertices()) {
				increaseTheSizeOfMatrix();
			}

			/* Add to the vertex map. */
			vertexList.add(vertex);
		}
	}

	/**
	 * Increases the size of the matrix by double to the current size.
	 */
	private void increaseTheSizeOfMatrix() {
		
		Integer newMatrixSize = getNumberOfVertices() * 2;

		int[][] newMatrix = new int[newMatrixSize][newMatrixSize];

		/* Copy the content of the old matrix. */
		for(int i = 0; i < relationshipMatrix.length; i++) {
			for(int j=0; j < relationshipMatrix.length; j++) {
				newMatrix[i][j] = relationshipMatrix[i][j];
			}
		}
		relationshipMatrix = newMatrix;
	}

	/**
	 * Adds the edge for the given vertices.
	 * Updates the matrix value as 1 for matrix[startIndex][endIndex]
	 * 
	 */
	@Override
	protected void addEdgeForVertex(T vertexOne, T vertexTwo) {
		final Integer indexForStart = vertexList.indexOf(vertexOne);
		if (indexForStart != -1) {
			final Integer indexForEnd = vertexList.indexOf(vertexTwo);
			if(indexForEnd != -1) {
				relationshipMatrix[indexForStart][indexForEnd] = 1;
			} else {
				/* Ending vertex is not there in the graph. */
			}
		} else {
			/* Starting vertex is not there in the graph. */
		}
	}

	public static AdjacencyMatrixGraph<Person> populateGraph() {
		
		AdjacencyMatrixGraph<Person> ajGraph = new AdjacencyMatrixGraph<Person>();
		Person arun = new Person("Arun", 12345);
		Person srini = new Person("Srini", 23456);
		Person naveen = new Person("Naveen", 34567);
		Person ananth = new Person("Ananth", 45678);
		Person dhina = new Person("Dhina", 56789);
		Person sat = new Person("Sat", 67890);
		Person master = new Person("Master", 78900);
		
		ajGraph.addVertex(arun);
		ajGraph.addVertex(srini);
		ajGraph.addVertex(naveen);
		ajGraph.addVertex(ananth);
		ajGraph.addVertex(dhina);
		ajGraph.addVertex(sat);
		ajGraph.addVertex(master);
		
		ajGraph.addEdge(arun, srini);
		ajGraph.addEdge(srini, arun);
		ajGraph.addEdge(naveen, srini);
		ajGraph.addEdge(srini, naveen);
		ajGraph.addEdge(srini, dhina);
		ajGraph.addEdge(dhina, srini);
		ajGraph.addEdge(dhina, ananth);
		ajGraph.addEdge(ananth, dhina);
		ajGraph.addEdge(ananth, arun);
		ajGraph.addEdge(arun, ananth);
		ajGraph.addEdge(sat, naveen);
		ajGraph.addEdge(naveen, sat);
		ajGraph.addEdge(sat, master);
		ajGraph.addEdge(master, sat);
		ajGraph.addEdge(dhina, sat);
		
		
		ajGraph.printGraph(ajGraph.relationshipMatrix);
		
		int[][] twoDotFriends = ajGraph.multiplyMatrix(ajGraph.relationshipMatrix, ajGraph.relationshipMatrix);
		
		System.out.println("Now displaying the two relation friends");
		
		ajGraph.printGraph(twoDotFriends);
		
		int[][] threeDotFriends = ajGraph.getNeighboursUsingMatrixMultiplication(ajGraph.relationshipMatrix,
				ajGraph.relationshipMatrix,
				3);		
		
		System.out.println("Now displaying the third relation friends");
		
		ajGraph.printGraph(threeDotFriends);
		
		return ajGraph;
	}
	
	/**
	 * Prints the relation.
	 */
	public void printGraph(int graph[][]) {
		for (int row = 0; row < graph.length ; row++) {
			for (int column = 0; column < graph.length ; column++) {
				if((row != column) && graph[row][column] >= 1) {
					System.out.println(vertexList.get(row) + " ---> " + vertexList.get(column));
				}
			}
		}
	}

	@Override
	public Boolean exists(T vertex) {
		return vertexList == null ? false : vertexList.contains(vertex) ;
	}

}
