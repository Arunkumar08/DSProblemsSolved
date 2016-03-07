package arun.problems.ds.arrays;

public class FindExtraOrMissedNumberInSequence {
	
	/**
	 * Input array is an AP, which has a extra number mistakenly added.
	 * Example: 1,2,3,...45,45,...n
	 * 
	 * @param input
	 * @param maxLimit - maximum number till AP
	 * @return
	 */
	public int findExtraNumberInSeriesArray(int input[]) {
		if (input == null)
		{
			return 0;
		}
		/*
		 * Find the max number
		 */
		int maxInSeq = input[input.length - 1];
		
		/**
		 * The sum of sequence of limit 'n' can be found using the following formula:
		 * n*(n+1) / 2
		 */
		int expectedSum = maxInSeq * (maxInSeq + 1) / 2;
		
		/*
		 * Now find the sum of the existing array contents
		 */
		int sumOfInputArray = 0;
		for (int i = 0; i < input.length; i++) {
			sumOfInputArray = sumOfInputArray + input[i];
		}
		return sumOfInputArray - expectedSum;
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public int findMissedNumberInSequence(int input[]) {
		if(input == null) {
			return 0;
		}
		/*
		 * Find the max number
		 */
		int maxInSeq = input[input.length - 1];
		
		/**
		 * The sum of sequence of limit 'n' can be found using the following formula:
		 * n*(n+1) / 2
		 */
		int expectedSum = maxInSeq * (maxInSeq + 1) / 2;
		
		/*
		 * Now find the sum of the existing array contents
		 */
		int sumOfInputArray = 0;
		for (int i = 0; i < input.length; i++) {
			sumOfInputArray = sumOfInputArray + input[i];
		}
		return expectedSum - sumOfInputArray;
	}
}
