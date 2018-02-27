package arun.problems.ds.sorting;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> implements Sort<T> {

	@Override
	public T[] sort(T[] collection) {
		
		if(collection.length ==1)
			return collection;

		@SuppressWarnings("unchecked")
		T[] sortedOne = sort((T[]) Arrays.copyOfRange(new Object[collection.length / 2], 0, collection.length / 2));
		@SuppressWarnings("unchecked")
		T[] sortedTwo = sort((T[]) Arrays.copyOfRange(new Object[collection.length / 2], (1 + collection.length / 2), collection.length));
		
		return sortMerger(sortedOne, sortedTwo);
	}

	private T[] sort(T[] collection, int startingIndex, int endIndex) {
		
		if(endIndex - startingIndex == 0)
			return collection;
		
		sort(collection, startingIndex, endIndex / 2);
		sort(collection, (endIndex / 2) + 1, endIndex);
		
		mergeSortedCollection(collection, startingIndex, endIndex);
		
		return collection;
	}
	
	private void mergeSortedCollection(T[] collection,
									   int startingIndex,
									   int endIndex) {
		int firstArraySize = ((endIndex - startingIndex) / 2) + 1;
		int secondArraySize = endIndex - startingIndex - firstArraySize;
		
		/* Create two arrays for iteration. */
		
		T[] firstArray = (T[]) new Object[firstArraySize];
		T[] secondArray = (T[]) new Object[secondArraySize];
		
		
	}

	private T[] sortMerger(T[] sortedOne, T[] sortedTwo) {
	
		int i = 0;
		int j = 0;
		
		@SuppressWarnings("unchecked")
		T[] mergedArray = (T[]) new Object[sortedOne.length + sortedTwo.length];
		int mergerIndex = 0;
		
		while(i < sortedOne.length && j < sortedTwo.length) {
			if(sortedOne[i].compareTo(sortedTwo[j]) < 0) {
				mergedArray[mergerIndex++] = sortedOne[i];
				i++;
			} else if (sortedOne[i].compareTo(sortedTwo[j]) > 0) {
				mergedArray[mergerIndex++] = sortedOne[j];
				j++;
			}
		}
		
		while(i < sortedOne.length) {
			mergedArray[mergerIndex++] = sortedOne[i++];
		}
		
		while(j < sortedOne.length) {
			mergedArray[mergerIndex++] = sortedOne[j++];
		}
		
		return mergedArray;
		
	}
}
