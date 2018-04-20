package tum0r.test;

import tum0r.algorithm.Permutation;
import tum0r.error.PermutationStepException;

public class PermutationTest {
	public static void test() {
		Permutation<Integer> permutation = new Permutation<>(Integer.class);
		Integer[] array = { 1, 2, 3 };
		int step = 5;
		try {
			for (int i = 0; i < step; i++) {
				array = permutation.next(array);
				for (int count = 0; count < array.length; count++) {
					System.out.print(array[count] + " ");
				}
				System.out.println();
			}
		} catch (PermutationStepException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println(permutation.indexOf(array));
		System.out.println();
		Permutation<String> permutation2 = new Permutation<>(String.class);
		String[] array2 = { "A", "B", "C" };
		int step2 = 7;
		try {
			for (int i = 0; i < step2; i++) {
				array2 = permutation2.next(array2);
				for (int count = 0; count < array2.length; count++) {
					System.out.print(array2[count] + " ");
				}
				System.out.println();
			}
		} catch (PermutationStepException e) {
			e.printStackTrace();
		}
	}
}
