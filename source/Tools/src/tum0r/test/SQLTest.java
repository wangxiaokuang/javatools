package tum0r.test;

import tum0r.error.DataBaseTypeException;
import tum0r.sql.SQL;
import tum0r.sql.SQLFactory;

public class SQLTest {
	public static void test() {
		try {
			// SQL sql = SQLFactory.getSQL("mysql");
			// sql.open("127.0.0.1", "3306", "GUET", "root", "@Sz48Z64", "utf-8");
			SQL sql = SQLFactory.getSQL("sql server");
			sql.open("172.16.224.143", "1433", "student", "sa", "123", "student");
			// String command = "select * from student where 姓名='梁文韬'";
			String command = "select * from manager";
			String[][] res = sql.query(command);
			// String[][] res = sql.query("select * from manager where username='" + command
			// + "'");
			sql.close();
			for (int i = 0; i < res.length; i++) {
				for (int j = 0; j < res[i].length; j++) {
					System.out.print(res[i][j] + " ");
				}
				System.out.println();
			}
		} catch (DataBaseTypeException e) {
			e.printStackTrace();
		}
		// try {
		// SQL sql = SQLFactory.getSQL("sqlite");
		// sql.open("test.db", null, null, null, null, null);
		// sql.update("create table if not exists student(id int,name char(5))");
		// sql.update("insert into student values(345,'567')");
		// String[][] res = sql.query("select * from student");
		// sql.close();
		// for (int i = 0; i < res.length; i++) {
		// for (int j = 0; j < res[i].length; j++) {
		// System.out.print(res[i][j] + " ");
		// }
		// System.out.println();
		// }
		// } catch (DataBaseTypeException e) {
		// e.printStackTrace();
		// }
	}
}
