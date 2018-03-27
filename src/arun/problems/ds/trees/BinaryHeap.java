package arun.problems.ds.trees;

import java.lang.reflect.Array;
import java.rmi.NoSuchObjectException;
import java.util.Arrays;

public class BinaryHeap<T extends Comparable<T>> {
	
	private T[] data;
	private Integer size = 0;
	private Integer capacity = 10;
	
	private boolean isMinHeap = true;
	
	private Class<T> type;
	
	@SuppressWarnings("unchecked")
	public BinaryHeap(Class<T> type) {
		this.type = type;
		data = (T[]) Array.newInstance(type, capacity);
	}
	
	@SuppressWarnings("unchecked")
	public BinaryHeap(Class<T> type, boolean isMin) {
		this.type = type;
		data = (T[]) Array.newInstance(type, capacity);
		isMinHeap = isMin;
	}
	
	public T peekPriority() throws NoSuchObjectException {
		if (size == 0) {
			throw new NoSuchObjectException("No objects");
		}
		return data[size - 1];
	}
	
	public Integer leftChildIndex(Integer index) {
		return 2 * index + 1;
	}
	
	public Integer rightChildIndex(Integer index) {
		return  2 * index + 2;
	}
	
	public Integer parentIndex(Integer index) {
		return (index - 1) / 2;
	}
	
	public void insert(T element) {
		// Check the capacity
		capacityCheckAndInc();
		data[size++] = element;
		// We have added the element as last element.
		// Now, move it up if needed by comparing its parents.
		percolateUp();
	}
	
	public T pollPriority() {
		// This will return the root and delete the root.
		T elem = data[0];
		data[0] = data[size - 1];
		// Now we have moved the last element to the root.
		// Percolate down, so that it moves to its proper position.
		// Compare its children and swap accordingly.
		data[size - 1] = null;
		size--;
		percolateDown();
		// Compress the capacity if needed.
		return elem;
	}
	
	private void percolateDown() {
		Integer runIndex = 0;
		// Till the last element, worst case (where there is no children)
		while (runIndex != size) {
			// Find the smallest/greater of its children
			Integer swapIndex;
			swapIndex = leftChildIndex(runIndex);
			Integer rightIndex = rightChildIndex(runIndex);
			if (swapIndex > (size - 1)) {
				break;
			}
			if (rightIndex < (size - 1)) {
				if (isMinHeap) {
					if (data[swapIndex].compareTo(data[rightIndex]) > 0) {
						swapIndex = rightIndex;
					}
				} else {
					if (data[swapIndex].compareTo(data[rightIndex]) < 0) {
						swapIndex = rightIndex;
					}
				}
			}
			if (swapNeeded(runIndex, swapIndex, true)) {
				swap(runIndex, swapIndex);
			} else {
				break;
			}
			runIndex = swapIndex;
		}	
	}
	
	private void percolateUp() {
		Integer runIndex = size - 1;
		while (runIndex > 0) {
			Integer parentIndex = parentIndex(runIndex);
			if (swapNeeded(runIndex, parentIndex, false)) {
				swap(runIndex, parentIndex);
			} else {
				// Its in order, parent is either greater/lesser than this.
				break;
			}
			runIndex = parentIndex;
		}
	}
	
	private boolean swapNeeded(Integer runIndex, Integer parentIndex, boolean reverse) {
		boolean minHeap = reverse ? !isMinHeap : isMinHeap;
		if (minHeap) {
			return data[runIndex].compareTo(data[parentIndex]) < 0;
		} else {
			return data[runIndex].compareTo(data[parentIndex]) > 0;
		}
	}

	private void swap(Integer one, Integer two) {
		T tempVal = data[one];
		data[one] = data[two];
		data[two] = tempVal;
	}
	
	private void capacityCheckAndInc() {
		if (size == capacity) {
			data = Arrays.copyOf(data, capacity*2);
			capacity = capacity*2;
		}
	}
	
	public void printHeap() {
		System.out.println(Arrays.toString(data));
	}
	
	// This sorting O(nlogn) including the first time feeding of
	// data into the heap.
	public void sort() {
		if(!isMinHeap) {
			// Every iteration takes O(logn) time complexity
			// As it has to re-arrange the Heap everytime.
			while(size > 1) {
				T top = data[0];
				data[0] = data[size - 1];
				data[size - 1] = top;
				size--;
				percolateDown();
			}
			printHeap();
		}
	}
	
	public static void main(String a[]) {
		BinaryHeap<Integer> heap = new BinaryHeap<Integer>(Integer.class, false);
		heap.insert(1);
		heap.insert(5);
		heap.insert(3);
		heap.insert(2);
		heap.insert(0);
		heap.insert(11);
		heap.insert(17);
		heap.insert(90);
		heap.insert(100);
		heap.insert(67);
		
		heap.printHeap();
		
		heap.sort();
	}
}
