package tum0r.test;

import tum0r.algorithm.YangHui;

public class YangHuiTest {
	public static void test() {
		long[][] arr=YangHui.getRows(1, 5);
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println(YangHui.getValue(4, 4));
	}
}
