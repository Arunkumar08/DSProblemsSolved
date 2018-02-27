package arun.problems.ds.sorting;

public class BubbleSort<T extends Comparable<T>> implements Sort<T>{

	@Override
	public T[] sort(T[] collection) {
		
		if(collection == null
				|| collection.length == 1)
			return collection;
		
		int pass = 0;
		while(pass < collection.length - 2) {
			for(int i = 0; i < collection.length -1; i++) {
				if (collection[i].compareTo(collection[i+1]) > 0) {
					T temp = collection[i];
					collection[i] = collection[i+1];
					collection[i+1] = temp;
				}
			}
			pass++;
		}
		
		return collection;
		
	}


}
