package arun.problems.ds.sorting;

public class InsertionSort<T extends Comparable<T>> implements Sort<T> {

	@Override
	public T[] sort(T[] collection) {

		for (int i = 1; i < collection.length ; i++) {
			
			int j = i;
			T elementAtJ = collection[j];
			
			while (j > 1 && (collection[j-1].compareTo(elementAtJ) > 0)) {
				collection[j] = collection[j-1];
				j--;
			}
			collection[j] = elementAtJ;
		}
		return collection;
	}

}
