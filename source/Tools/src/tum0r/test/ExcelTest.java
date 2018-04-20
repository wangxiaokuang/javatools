package tum0r.test;

import tum0r.file.Excel;

public class ExcelTest {
	public static void test() {
		Excel excel = new Excel();

		// read
		// String[][] result = excel.read("",
		// "工作表1");
		// for (int i = 0; i < result.length; i++) {
		// for (int j = 0; j < result[i].length; j++) {
		// System.out.print(result[i][j]+" ");
		// }
		// System.out.println();
		// }

		// save
		String[][] temp = { { "1", "2", "3" }, { "1" } };
		excel.save("", "Sheet1", temp);
	}
}
