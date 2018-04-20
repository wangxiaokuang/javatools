package tum0r.algorithm;

import java.lang.reflect.Array;

public class FastSort<E extends Comparable<E>> {
	private Class<E> type;

	public FastSort(Class<E> type) {
		this.type = type;
	}

	public E[] sort(E[] array, boolean positiveSequence) {
		int length = array.length;
		if (length == 1) {
			return array;
		}
		int left = 0;
		int right = length - 1;
		int now = right;
		E temp;
		if (positiveSequence) {
			while (left <= right) {
				if (now == left - 1) {
					if (array[now].compareTo(array[right]) > 0) {
						temp = array[now];
						array[now] = array[right];
						array[right] = temp;
						now = right;
					}
					right--;
				} else {
					if (array[now].compareTo(array[left]) < 0) {
						temp = array[now];
						array[now] = array[left];
						array[left] = temp;
						now = left;
					}
					left++;
				}
			}
		} else {
			while (left <= right) {
				if (now == left - 1) {
					if (array[now].compareTo(array[right]) < 0) {
						temp = array[now];
						array[now] = array[right];
						array[right] = temp;
						now = right;
					}
					right--;
				} else {
					if (array[now].compareTo(array[left]) > 0) {
						temp = array[now];
						array[now] = array[left];
						array[left] = temp;
						now = left;
					}
					left++;
				}
			}
		}
		if (length > 1) {
			E[] arr1 = (E[]) Array.newInstance(type, now);
			E[] arr2 = (E[]) Array.newInstance(type, length - now - 1);
			for (int i = 0; i < now; i++) {
				arr1[i] = array[i];
			}
			for (int i = now + 1; i < length; i++) {
				arr2[i - now - 1] = array[i];
			}
			arr1 = sort(arr1, positiveSequence);
			arr2 = sort(arr2, positiveSequence);
			for (int i = 0; i < now; i++) {
				array[i] = arr1[i];
			}
			for (int i = now + 1; i < length; i++) {
				array[i] = arr2[i - now - 1];
			}
		}
		return array;
	}
}
