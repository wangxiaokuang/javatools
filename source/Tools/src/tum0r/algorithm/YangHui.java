package tum0r.algorithm;

public class YangHui {
	public static long[][] getRows(int start, int stop) {
		long[][] result = new long[stop - start][];
		long temp = 1l;
		for (int row = start; row <= stop - 1; row++) {
			temp = 1l;
			result[row - 1] = new long[row];
			for (int column = 1; column <= row; column++) {
				result[row - 1][column - 1] = temp;
				temp = temp * (row - column) / column;
			}
		}
		return result;
	}

	public static long getValue(int n, int m) {
		if (m > n || m <= 0 || n <= 0) {
			return -1l;
		}
		long res = 1;
		for (int count = 1; count < m; count++) {
			res = res * (n - count) / count;
		}
		return res;
	}
}
