package arun.problems.ds.arrays;

public class FindMaxAndMinNumbersInArray {
	
	public static void main(String a[]) {
		int[] arr = null;
		FindMaxAndMinNumbersInArray find = new FindMaxAndMinNumbersInArray();
		find.findMinAndMaxNumbersInArray(arr);
	}

	public void findMinAndMaxNumbersInArray(int[] input) {
		if (input == null) {
			System.out.println("Wrong input");
			return;
		}
		int minValue = input[0];
		int maxValue = input[0];
		for(int i = 1; i < input.length ; i++) {
			if( input[i] > maxValue)
				maxValue = input[i];
			else if(input[i] < minValue)
				minValue = input[i];
		}
		System.out.println("Smallest element in the array is: "+minValue);
		System.out.println("Largest element in the array is: "+maxValue);
	}
}
