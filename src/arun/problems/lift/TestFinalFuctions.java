package arun.problems.lift;

import arun.problems.ds.trees.Node;

public class TestFinalFuctions {
	
	public void check1(final Node<String> node) {
		
		Node<String>[] nodeArray = (Node<String>[]) new Object[10];
		
		nodeArray[0].getLeft();
	}
	
	public static void main(String a[]) {
		TestFinalFuctions func = new TestFinalFuctions();
		func.check1(null);
	}
}
