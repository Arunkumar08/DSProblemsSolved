package arun.problems.ds.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExpressionStringCorrectness {

	public Map<Character, Character> expressionMap;
	public ExpressionStringCorrectness() {
		expressionMap = new HashMap<Character, Character>();
		expressionMap.put('}', '{');
		expressionMap.put(')', '(');
		expressionMap.put(']', '[');
		expressionMap.put('>', '<');
	}
	public boolean expresssionString(String input) {
		if (input == null || input.equals("")) {
			System.out.println("Invalid input; ");
			return false;
		}
		char[] chars = input.toCharArray();
		Stack<Character> charStack = new Stack<Character>();
		for (int i=0; i < chars.length; i++) {
			Character charOppVal = expressionMap.get(chars[i]);
			// Check if it is valid expression character
			if (!expressionMap.keySet().contains(chars[i])
					&& !expressionMap.values().contains(chars[i])) {
				System.out.print("Invalid input; ");
				return false;
			}
			if (!charStack.isEmpty()) {
				if (charOppVal == null) {
					charStack.push(chars[i]);
				} else if (charOppVal == charStack.peek()) {
					charStack.pop();
				} else {
					return false;
				}
			} else {
				charStack.push(chars[i]);
			}
		}
		return true;
	}
	
	public static void main(String a[]) {
		ExpressionStringCorrectness exp = new ExpressionStringCorrectness();
		System.out.println(exp.expresssionString("<{}[]ad>"));
		System.out.println(exp.expresssionString("[][]"));
		System.out.println(exp.expresssionString("([[]])"));
	}
}
