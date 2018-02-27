package arun.problems.ds.sorting;

public class QuickSort<T extends Comparable<T>> implements Sort<T> {

	@Override
	public T[] sort(T[] collection) {
		sort(collection, 0, collection.length-1);
		return collection;
	}

	private void sort(T[] collection, int begin, int end) {
		if(begin < end) {
			int pivotElement = partitionAndGetPivot(collection, begin, end);
			System.out.println(begin+","+end);
			sort(collection, begin, pivotElement - 1);
			sort(collection, pivotElement + 1, end);
		}
	}

	private int partitionAndGetPivot(T[] collection, int begin, int end) {
		
		int left = begin;
		int right = end;
		int pivot = begin;
		
		while(left < right) {
			while(collection[left].compareTo(collection[pivot]) >= 0)
				left++;
			
			while(collection[right].compareTo(collection[pivot]) < 0)
				right--;
			
			/* We reached here means. pivot element struck between low and high.*/
			if(left < right) {
				T temp = collection[left];
				collection[left] = collection[right];
				collection[right] = temp;
			}
		}
		
		/* We found the place for the pivot element. Right should be place to which pivot should be moved to. So swap the elements. */
		T temp = collection[right];
		collection[right] = collection[pivot];
		collection[pivot] = temp;
		
		return right;
	}

}
