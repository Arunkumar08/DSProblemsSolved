package arun.problems.ds.trees;


public class DepthOfBinaryTree<T> {

	public int findDepthOfBinaryTree(Node<T> root) {
		
		if(root == null) {
			return 0;
		}
		
		int leftHeight = findDepthOfBinaryTree(root.left);
		int rightHeight = findDepthOfBinaryTree(root.right);

		System.out.println("Visiting node: " + root.value);
		System.out.println("Left Height: " + leftHeight);
		System.out.println("Right Height: " + rightHeight);
		
		if(leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
	}
	
	public static void main(String a[]) {
		
		Node<Integer> node8 = new Node<Integer>(8, null, null);
		Node<Integer> node7 = new Node<Integer>(7, null, null);
		Node<Integer> node6 = new Node<Integer>(6, null, null);
		Node<Integer> node5 = new Node<Integer>(5, null, null);
		Node<Integer> node4 = new Node<Integer>(4, node8, null);
		Node<Integer> node3 = new Node<Integer>(3, node6, node7);
		Node<Integer> node2 = new Node<Integer>(2, node4, node5);
		Node<Integer> node1 = new Node<Integer>(1, node2, node3);
		
		DepthOfBinaryTree<Integer> depth = new DepthOfBinaryTree<Integer>();
		System.out.println(depth.findDepthOfBinaryTree(node1));
		
	}
}
