package tum0r.test;

import java.util.Random;

import tum0r.algorithm.BubbleSort;
import tum0r.algorithm.CombSort;
import tum0r.algorithm.FastSort;
import tum0r.algorithm.MergeSort;

public class SortTest {
	public static void test() {
		// BubbleSort<Integer> bubble = new BubbleSort<>();
		// FastSort<Integer> fastRow = new FastSort(Integer.class);
		// MergeSort<Integer> merge = new MergeSort<>(Integer.class);
		CombSort<Integer> comb = new CombSort<>();
		int length = 10;
		Random random = new Random();
		Integer[] arr = { 0, 0, 5, 1, 7, 8, 11, 6, 0, 0, 1, 1, 3, 9, 14, 4 };
		// char[] arr = { 'a', 'c', 'h', 'b', 'j', 'g' };
		// Integer[] arr = new Integer[length];
		// for (int count = 0; count < arr.length; count++) {
		// arr[count] = random.nextInt(length);
		// }
		// for (int i = 0; i < arr.length; i++) {
		// System.out.print(arr[i] + " ");
		// }
		// System.out.println();
		long t1 = System.currentTimeMillis();
		// arr = (Integer[]) bubble.sort(arr, true);
		// arr = fastRow.sort(arr, false);
		// arr = merge.sort(arr, true);
		comb.sort(arr, false);
		long t2 = System.currentTimeMillis();
		// for (int i = 0; i < arr.length; i++) {
		// System.out.print(arr[i] + " ");
		// }
		// System.out.println();
		System.out.println(t2 - t1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
