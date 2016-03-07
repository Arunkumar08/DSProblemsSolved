package arun.problems.ds;

class Node<T> {
	T data;
	Node<T> next;
	
	public Node() {
		
	}
 	public Node(final T data1) {
		this.data = data1;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public void printChilds() {
		System.out.print(data + " : ");
		Node<T> summaNext = next;
		while (summaNext != null) {	
			System.out.print( summaNext.data + " : ");
			summaNext = summaNext.next;
		}
	}
	
	public void setNode(Node<T> node) {
		this.data = node.data;
		this.next = node.next;
	}
}

public class ReverseLinkedList<T> {
	
	Node<T> reverseHead;
	
	public static void main(String a[]) {
		Node<Integer> ll = new Node<Integer>(1);
		ll.setNext(new Node<Integer>(2));
		ll.getNext().setNext(new Node<Integer>(3));
		ll.getNext().getNext().setNext(new Node<Integer>(4));
		ll.getNext().getNext().getNext().setNext(new Node<Integer>(5));
		System.out.println("Before Reversed");
		ll.printChilds();
		System.out.println();
		ReverseLinkedList<Integer> reverse = new ReverseLinkedList<Integer>();
		Node<Integer> reverseHead = reverse.reverseRecursively(ll);
		System.out.println("After Reversed");
		reverseHead.printChilds();
	}

	public Node<T> reverseListIterative(Node<T> head) {	
		Node<T> current = head;
		Node<T> prev = null;
		Node<T> next = null;
		
		while(current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}
	
	public Node<T> reverseRecursively(Node<T> head) {
		if(head.getNext() == null) {
			reverseHead = head;
			return reverseHead;
		}
		reverseRecursively(head.getNext());
		Node<T> tempToStoreNext = head.getNext();
		tempToStoreNext.setNext(head);
		head.setNext(null);
		return reverseHead;
	}
}
