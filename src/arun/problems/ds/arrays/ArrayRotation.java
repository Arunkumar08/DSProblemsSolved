package arun.problems.ds.arrays;

/**
 * Rotate the array by n.
 */
public class ArrayRotation<T> {

	
	public static void main(String a[]) {
		ArrayRotation<Integer> rotate = new ArrayRotation<Integer>();
		Integer array[] = {3,8,5,6,7,10,9};
		rotate.rotateArrayByReversing(array, 2);
	}
	
	/**
	 * O(n) + Temp(Size)
	 * @param array
	 * @param rotateBy
	 */
	public void rotateUseTempArray(T[] array, int rotateBy) {
		System.out.println("Incoming array:");
		printArray(array);
		if (rotateBy > 0 
				&& rotateBy < array.length) {
			@SuppressWarnings("unchecked")
			T[] tempArray = (T[]) new Object[rotateBy];
			/*
			 * Store elements till the rotation point in temp array
			 */
			for (int i=0; i < rotateBy; i++) {
				tempArray[i] = array[i];
			}
			/*
			 * Shift the rest of the elements to left.
			 * After that, copy the contents of temp array to right.
			 */
			for (int i = 0; i < array.length; i++) {
				if (i < (array.length - rotateBy)) {
					array[i] = array[rotateBy + i];
				} else {
					array[i] = tempArray[(i + rotateBy) - array.length];
				}
			}
		}
		System.out.println("Outgoing array: ");
		printArray(array);
	}
	
	/**
	 * O(length * n)
	 * @param array
	 * @param rotateBy
	 */
	public void rotateOneByOne(T[] array, int rotateBy) {
		System.out.println("Incoming array:");
		printArray(array);
		if (rotateBy > 0 
				&& rotateBy < array.length) {
			for (int i=0; i < rotateBy; i++) {
				T temp = array[0];
				for (int j = 0; j < array.length - 1; j++) {
					array[j] = array[j+1];
				}
				array[array.length - 1] = temp;
			}
		}
		System.out.println("Outgoing array: ");
		printArray(array);
	}
	
	/**
	 * O(n)
	 * 
	 * @param array
	 * @param rotateBy
	 */
	public void rotateArrayByReversing(T[] array, int rotateBy) {
		System.out.println("Incoming array:");
		printArray(array);
		if (rotateBy > 0 
				&& rotateBy < array.length) {
			reverseArray(array, 0, rotateBy - 1);
			reverseArray(array, rotateBy, array.length - 1);
			reverseArray(array, 0, array.length - 1);
		}
		System.out.println("Outgoing array: ");
		printArray(array);
	}

	public void reverseArray(T[] array, int start, int end) {
		while(start < end) {
			T temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
	}
	
	public void printArray(T[] array) {
		for(T a : array) {
			System.out.print(a);
			System.out.print(" ");
		}
		System.out.println();
	}
}
