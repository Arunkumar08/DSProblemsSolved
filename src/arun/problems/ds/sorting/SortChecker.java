package arun.problems.ds.sorting;

public class SortChecker {

	public static void main(String a[]) {
		Integer[] unSortedArray = {2, 54, 6 , 1, 9};
		//Sort<Integer> sort = new BubbleSort<Integer>();
		Sort<Integer> sort = new QuickSort<Integer>();
		
		Integer[] sortedArray = sort.sort(unSortedArray);		
		for(Integer item : sortedArray) {
			System.out.print(item + ", ");
		}
	}
}
