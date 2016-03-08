package arun.problems.ds.arrays;

public class FindLargestElementInArraySmallerOrEqualToX {

	/**
	 * Find floor for the given number:
	 * 		1) Largest in given array but smaller than or equal to X
	 * @param array
	 * @param x
	 * @return
	 */
	public int findNumber(final int[] array, int x) {
		return findLargestInArraySmallerOrEqualToX(array, 0, array.length - 1, x);
	}
	
	/**
	 * Use Binary search to find the number in O(log(n)) complexity as the array is sorted.
	 *
	 * @param array
	 * @param startPos
	 * @param endPos
	 * @param x
	 */
	public int findLargestInArraySmallerOrEqualToX(final int[] array,
											   	   final int startPos,
											   	   final int endPos,
											   	   final int x) {
		if(array == null) 
			return -1;
		
		if(endPos < startPos)
			return -1;
		
		if( array[endPos] <= x)
			return array[endPos];
		
		int median = (startPos + endPos) / 2;
		
		if(median == 0 && array[median] <= x)
			return array[median];

		if(array[median] == x) {
			return array[median];
		} else if (array[median] > x) {
			return findLargestInArraySmallerOrEqualToX(array, startPos, median-1, x);
		}
			
		return findLargestInArraySmallerOrEqualToX(array, median + 1, endPos, x);
	}
	
	/**
	 * @param a
	 */
	public static void main(String a[]) {
		final int[] inputArray = {0, 4, 5, 6, 11, 12, 21};
		int x = -1;
		FindLargestElementInArraySmallerOrEqualToX findX = new FindLargestElementInArraySmallerOrEqualToX();
		System.out.println(findX.findNumber(inputArray, x));
	}
}