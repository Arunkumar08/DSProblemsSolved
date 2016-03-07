package arun.problems.ds.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class FindPairsWhichAccountsForGivenSum {

	public static void main(String a[]) {
		int[] input = { -5, -2, -3, -4, 0, 2, 4, 8, 3, 7, 1, 3, 4, 11 };
		FindPairsWhichAccountsForGivenSum sumPair = new FindPairsWhichAccountsForGivenSum();
		// sumPair.printPairs(input, 6);
		sumPair.prinPairsOofNComplexity(input, 6);
	}

	/**
	 * Sort the array --> Complexity of this solution is O(NLogN) Have two
	 * pointers. one moves forward, other movers from backward. Sum up both
	 * pointer: If sum exceeds the given number: Then move the backward pointer
	 * and repeat the operation If sum is lower than the given number: Move the
	 * forward pointer and try If the sum is equal: Then print the numbers in
	 * the pointers And also move both the pointers.
	 * 
	 * @param input
	 * @param sum
	 */
	public void printPairs(int input[], int sum) {
		if (input == null || input.length < 2)
			System.out.println("Wrong Input");

		Arrays.sort(input);

		int i = 0;
		int j = input.length - 1;

		while (i < j) {
			if ((input[i] + input[j]) == sum) {
				System.out
						.println("Pair: (" + input[i] + ", " + input[j] + ")");
				i++;
				j--;
			} else if ((input[i] + input[j]) > sum)
				j--;
			else
				i++;
		}
	}

	/**
	 * Another way of doing it is to use Hashset. Complexity of this will be
	 * O(LogN) And this approach needs extra space complexity of O(LogN).
	 * 
	 * Logic involves: Use HashSet to store the values. For every value check
	 * the target pair(sum - value) is available in Set If not available then
	 * add to the Set. If available, then print the pair :)
	 * 
	 * @param input
	 * @param sum
	 */
	public void prinPairsOofNComplexity(int[] input, int sum) {
		if (input == null || input.length < 2)
			return;

		HashSet<Integer> uniqueSet = new HashSet<Integer>();
		for (int number : input) {
			int targetPair = sum - number;
			if (uniqueSet.contains(targetPair)) {
				System.out
						.println("Pair: (" + number + ", " + targetPair + ")");
			} else {
				uniqueSet.add(number);
			}
		}
	}
}
