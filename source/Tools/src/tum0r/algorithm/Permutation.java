package tum0r.algorithm;

import java.lang.reflect.Array;

import tum0r.error.PermutationStepException;

public class Permutation<E extends Comparable<E>> {
	private Class<E> type;
	private long max;

	public Permutation(Class<E> type) {
		this.type = type;
	}

	public long indexOf(E[] array) {
		long index = 0;
		int length = array.length;
		for (int i = 0; i < length; i++) {
			long sum = 0;
			E temp = array[i];
			for (int j = i + 1; j < length; j++) {
				if (temp.compareTo(array[j]) > 0) {
					sum++;
				}
			}
			if (sum == 0) {
				continue;
			}
			for (int n = length - i - 1; n >= 1; n--) {
				sum *= n;
			}
			index += sum;
		}
		return index + 1;
	}

	public E[] steps(E[] array, int n) throws PermutationStepException {
		return operator(array, n);
	}

	public E[] next(E[] array) throws PermutationStepException {
		return operator(array, 1);
	}

	private E[] operator(E[] array, int step) throws PermutationStepException {
		if (step <= 0) {
			throw new PermutationStepException(String.valueOf(step));
		}
		int length = array.length;
		for (int count = 0; count < step; count++) {
			boolean live = false;
			for (int i = length - 2; i >= 0; i--) {
				if (array[i].compareTo(array[i + 1]) < 0) {
					live = true;
					int index = i + 1;
					for (int j = length - 1; j > i; j--) {
						if (array[j].compareTo(array[i]) > 0 && array[j].compareTo(array[index]) < 0) {
							index = j;
						}
					}
					E temp = array[index];
					array[index] = array[i];
					array[i] = temp;
					E[] arr = (E[]) Array.newInstance(type, length - i - 1);
					for (int k = i + 1; k < length; k++) {
						arr[k - i - 1] = array[k];
					}
					MergeSort<E> mergeSort = new MergeSort<>(type);
					arr = mergeSort.sort(arr, true);
					for (int k = i + 1; k < length; k++) {
						array[k] = arr[k - i - 1];
					}
					break;
				}
			}
			if (!live) {
				MergeSort<E> mergeSort = new MergeSort<>(type);
				array = mergeSort.sort(array, true);
			}
		}
		return array;
	}
}
