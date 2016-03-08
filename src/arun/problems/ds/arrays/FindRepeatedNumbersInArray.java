package arun.problems.ds.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class FindRepeatedNumbersInArray {

	public static void main(String a[] ) {
		Scanner sc = new Scanner(System.in);
		sc.next();
		sc.close();
		String[] values = {"{[}]"};
		Braces(values);
	}
	
	static String[] Braces(String[] values) {
        if(values == null || values.length == 0)
            return null;
        final String[] resultArray = new String[values.length];
        final Map<Character, Character> braceMap = new HashMap<Character, Character>();
        braceMap.put('(', ')');
        braceMap.put('[', ']');
        braceMap.put('{', '}');
        for(int i = 0; i < values.length; i++) {
            if(isBraceVStringValid(values[i], braceMap)) {
                resultArray[i] = "YES";
            } else {
                resultArray[i] = "NO";
            }
        }
        return resultArray;
    }

    static boolean isBraceVStringValid(final String value, final Map<Character, Character> braceMap) {
        boolean result = false;
        final Stack usageStack = new Stack();
        char[] characters = value.toCharArray();
        for(char character : characters) {
            if(usageStack.isEmpty()) {
                usageStack.push(character);
            } else {
                if (braceMap.get(usageStack.peek()) == character) {
                    usageStack.pop();
                } else {
                    usageStack.push(character);
                }
            }
        }
        if(usageStack.isEmpty()) {
            result = true;
        }
        return result;
    }
}
