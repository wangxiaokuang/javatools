package tum0r.algorithm;

public class BubbleSort<E extends Comparable<E>> {
	public E[] sort(E[] array, boolean positiveSequence) {
		E temp;
		boolean flag;
		int size = array.length;
		for (int first = 0; first < size; first++) {
			flag = true;
			for (int second = first; second < size; second++) {
				if (array[first].compareTo(array[second]) > 0) {
					temp = array[second];
					array[second] = array[first];
					array[first] = temp;
					flag = false;
				}
			}
			if (flag) {
				break;
			}
		}
		if(!positiveSequence) {
			int index = size -1;
			for(int i=0;i<size/2;i++) {
				temp = array[i];
				array[i] = array[index];
				array[index] = temp;
				index--;
			}
		}
		return array;
	}
}
