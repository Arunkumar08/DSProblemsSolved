package arun.problems.ds.arrays;

/**
 * Problem:
 * Given an array of sorted words from Alien dictionary
 * Find out the order of alphabets.
 */
public class OrderOfLettersFromSortedWords {
	
	public Node orderOfLetters(String[] input) {
		if (input.length < 1) {
			System.out.println("Wrong input..");
			return null;
		}
		Node head = null;
		Node recent = new Node();
		Node secondHead = null;
		Node recentSecond = new Node();
		for (int i = 0; i < input.length; i++) {
			char[] letters = input[i].toCharArray();
			if (head == null) {
				head = new Node(letters[0]);
				recent = head;
			} else {
				if (recent.getLetter().equals(letters[0])) {
					char[] prevLetters = input[i - 1].toCharArray();
					boolean notSame = false;
					int j = 1;
					while (!notSame) {
						Node letterNode = new Node(prevLetters[j]);
						if (secondHead == null) {
							secondHead = letterNode;
							recentSecond = secondHead;
						} else {
							recentSecond.setNextNode(letterNode);
							recentSecond = recentSecond.getNextNode();
						}
						if (letters[j] == prevLetters[j]) {
							j++;
						} else {
							notSame = true;
							recentSecond.setNextNode(new Node(letters[j]));
							recentSecond = recentSecond.getNextNode();
						}
					}
				} else {
					recent.setNextNode(new Node(letters[0]));
					recent = recent.getNextNode();
				}
			}
		}
		secondHead.printNodes();
		System.out.println();
		return head;
	}
	
	public static void main(String a[]) {
		String[] inputArr = {"aaa", "abc", "abd"};
		OrderOfLettersFromSortedWords orders = new OrderOfLettersFromSortedWords();
		Node outputOrder = orders.orderOfLetters(inputArr);
		outputOrder.printNodes();
	}
	
}

/* Doubly Linked List to hold the letters */
class Node {
	private Character letter;
	private Node nextNode;
	private Node prevNode;
	public Character getLetter() {
		return letter;
	}
	public void setLetter(Character letter) {
		this.letter = letter;
	}
	public Node getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	public Node getPrevNode() {
		return prevNode;
	}
	public void setPrevNode(Node prevNode) {
		this.prevNode = prevNode;
	}
	
	public Node() {
		
	}
	public Node(Character leter) {
		this.letter = leter;
	}
	
	public void printNodes() {
		Node node = this;
		while(node != null) {
			System.out.print(node.getLetter());
			System.out.print(" -> ");
			node = node.getNextNode();
		}
	}
}
