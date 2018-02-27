package arun.problems.ds.trees;

public class Node<T> {

	Node<T> left = null;
	Node<T> right = null;
	
	T value;
	
	/**
	 * @param t
	 * @param left
	 * @param right
	 */
	public Node(T t, Node<T> left, Node<T> right) {
		this.value = t;
		this.left = left;
		this.right = right;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
