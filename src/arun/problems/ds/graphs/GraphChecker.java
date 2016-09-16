package arun.problems.ds.graphs;

import arun.problems.ds.graphs.model.Person;

public class GraphChecker {

	public static void main(String a[]) {
		
		Person arun = new Person("Arun", 12345);
		Person srini = new Person("Srini", 23456);
		Person naveen = new Person("Naveen", 34567);
		Person ananth = new Person("Ananth", 45678);
		Person dhina = new Person("Dhina", 56789);
		Person sat = new Person("Sat", 67890);
		Person master = new Person("Master", 78900);
		
		Graph<Person> graphToBeused = AdjacencyMatrixGraph.populateGraph();
		
		/* DFS */
		DepthFirstSearch<Person> dfs = new DepthFirstSearch<Person>(graphToBeused);
		System.out.println(dfs.searchPath(arun, sat));
		
		/* BFS */
		BreadthFirstSearch<Person> bfs = new BreadthFirstSearch<Person>(graphToBeused);
		System.out.println(bfs.searchPath(arun, sat));
	}

	
}
