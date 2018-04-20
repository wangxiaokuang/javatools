package tum0r.algorithm;

public class CombSort<E extends Comparable<E>> {
	public E[] sort(E[] arr, boolean positiveSequence) {
		double m = 1.3;
		boolean flag = false;
		int size = arr.length;
		int n = size;
		E temp;
		while (n > 1 || flag == true) {
			n = Math.max((int) (n / 1.3), 1);
			flag = false;
			for (int i = 0; i + n < size; i++) {
				if (arr[i].compareTo(arr[i + n]) > 0) {
					temp = arr[i];
					arr[i] = arr[i + n];
					arr[i + n] = temp;
				}
			}
		}
		if (!positiveSequence) {
			int index = size - 1;
			for (int i = 0; i < size / 2; i++) {
				temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
				index--;
			}
		}
		return arr;
	}
}
