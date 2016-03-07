package arun.problems.ds.arrays;

public class CheckIfArrayContainsNumber {

	public static void main(String a[]) {
		int input[] = {2,34,56,77,88,90,100,111};
		CheckIfArrayContainsNumber checkIt = new CheckIfArrayContainsNumber();
		System.out.println(checkIt.checkNumberInUnsortedArray(input, 111));	
		}

	/**
	 * @param array
	 * @return
	 */
	public boolean checkNumberInArray(int[] array, boolean sorted, int findMe) {
		if(sorted)
			return checkNumberInSortedArrayRec(0, array.length - 1, array, findMe);
		else
			return true;
	}
	
	/**
	 * Recursive way:
	 * 
	 * If the input array is sorted, then
	 * We can use binary search to find an element in array.
	 * Binary search provides the complexity of O(logN) in worst case
	 * 
	 * Binary search - Check the center number of the array and compares the element
	 * if equal - return true
	 * if greater - divide the problem and call the same method with another array which is of right side of element
	 * if lesser - divide the problem and call the same method with another array which is of left side of the element
	 * And do this in recursive fashion
	 * 
	 * Corner conditions:
	 * if startPosition > endPosition , then return false.
	 * 
	 * @param input
	 * @return
	 */
	public boolean checkNumberInSortedArrayRec(int startPos, int endPos, int input[], int findMe) {
		if(input == null)
			return false;
		if (endPos < startPos) {
			return false;
		}
		int median = (startPos + endPos) / 2;
		if(findMe == input[median])
			return true;
		else if(findMe < input[median])
			return checkNumberInSortedArrayRec(startPos, median - 1, input, findMe);
		else if(findMe > input[median])
			return checkNumberInSortedArrayRec(median + 1 , endPos, input, findMe);
		return false;
	}

	/**
	 * This is the iterative approach of the searching a element in array
	 * using binary search.
	 * 
	 * @param input
	 * @param findMe
	 * @return
	 */
	public boolean checkNumberInSortedArrayItr(int[] input, int findMe) {
		if(input == null)
			return false;
		int startPos = 0;
		int endPos = input.length - 1;
		while(endPos >= startPos) {
			int median = (startPos + endPos) / 2;
			if (findMe == input[median])
				return true;
			else if(findMe > input[median])
				startPos = median + 1;
			else
				endPos = median - 1;
		}
		return false;
	}
	
	/**
	 * This could be done only through sequential search.
	 * Complexity for worst case would be O(n)
	 * @param input
	 * @param findMe
	 * @return
	 */
	public boolean checkNumberInUnsortedArray(int input[], int findMe) {
		if(input == null)
			return false;
		for(int i : input) {
			if(i == findMe)
				return true;
		}
		return false;
	}
}
