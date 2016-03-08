package arun.problems.ds.arrays;

import java.util.Stack;

public class PrintNextBiggestNumberForEachElement {

	
	public static void main(String a[]) {
		int[] input = {2};
		PrintNextBiggestNumberForEachElement print = new PrintNextBiggestNumberForEachElement();
		print.printNextBiggest(input);
	}
	
	/**
	 * The brute force for this problem will end up in O(N^2)
	 * Better solution could be implemented using a Stack.
	 * 
	 * Logic:
	 * =====
	 * Initialize the stack with first element and follow the steps:
	 * 
	 * Iterate through the array from 2nd element
	 * Step1: Make element as next, compare the stacks top element with next
	 * Step2: While stack element is less than next, then next is the next element for the popped element
	 * Step3: Keep popping the element from the stack as long as it is empty or
	 * 		  If next is less than stack element
	 * Step4: Push the next to stack, so that next element can be for that element.
	 * Step5: After the completion of array iteration, pop out all the elements in the stack and pritn "-1".
	 * 		  As no bigger number found for those.
	 * 
	 * 
	 * 
	 * @param input
	 */
	public void printNextBiggest(int[] input) {
		if (input == null)
			return;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(input[0]);
		for(int i = 1; i < input.length; i++) {
			int bigNext = input[i];
			while(!stack.isEmpty()) {
				int number = stack.peek();
				if(bigNext > number) {
					System.out.println(number + " --> " + bigNext);
					stack.pop();
				} else {
					break;
				}
			}
			stack.push(bigNext);
		}
		while(!stack.isEmpty()) {
			System.out.println(stack.pop() + " --> -1" );
		}
	}
}
