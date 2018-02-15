package arun.problems.ds.arrays;

public class SumOfBitDifferenceOfPairs {

	public Integer sumOfDiff(int[] arr) {
		if (arr.length < 1) {
			return 0;
		}
		int bitDiffCountInAllPairs = 0;
		for (int i = 0; i < Integer.BYTES; i++ ) {
			int count = 0;
			for (int j = 0; j < arr.length;  j++) {
				if ((arr[j] & (1 << i)) > 0) {
					count++;
				}
				// Now, count will have number of integers in the input array
				// which has bit set (1) in i'th position. 
			}
			
			// Number of combination of bit difference at i'th position can be calculated as:
			// Count * (Size - Count) * 2 (Reverse combinations for same number)
			bitDiffCountInAllPairs = bitDiffCountInAllPairs + (count * (arr.length - count) * 2);
		}
		return bitDiffCountInAllPairs;
	}
	
	public static void main(String a[]) {
		int[] arr = {1, 3, 2, 4};
		SumOfBitDifferenceOfPairs pairs = new SumOfBitDifferenceOfPairs();
		System.out.println(pairs.sumOfDiff(arr));
	}
}
