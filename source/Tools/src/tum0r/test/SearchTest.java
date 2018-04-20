package tum0r.test;

import tum0r.algorithm.BinarySearch;

public class SearchTest {
	public static void test() {
		BinarySearch<Double> binarySearch = new BinarySearch<>();
		Double[] arr = { 1.3, 2.3, 3.3 };
		int index = binarySearch.search(arr, 2.3);
		System.out.println(index);
	}
}
