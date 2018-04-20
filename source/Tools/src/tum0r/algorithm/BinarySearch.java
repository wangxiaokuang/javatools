package tum0r.algorithm;

public class BinarySearch<E extends Comparable<E>> {

	public int search(E[] array, E want) {
		int left = 0;
		int right = array.length - 1;
		int index = array.length / 2;
		while (left <= right) {
			if (want.compareTo(array[index]) == 0) {
				break;
			} else if (want.compareTo(array[index]) < 0 && left != right) {
				if (array[left].compareTo(array[right]) <= 0) {
					right = index - 1;
				} else {
					left = index + 1;
				}
			} else if (want.compareTo(array[index]) > 0 && left != right) {
				if (array[left].compareTo(array[right]) <= 0) {
					left = index + 1;
				} else {
					right = index - 1;
				}
			} else {
				index = -1;
				break;
			}
			index = (right - left) / 2 + left;
		}
		return index;
	}
}
