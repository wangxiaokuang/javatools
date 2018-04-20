package tum0r.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class Execute {

	public static String[][] query(ResultSet resultSet, Statement statement, String command) {
		String[][] result = null;
		try {
			resultSet = statement.executeQuery(command);
			ArrayList<ArrayList> arrayList = new ArrayList<>();
			int columnNumber = resultSet.getMetaData().getColumnCount();
			ArrayList temp = new ArrayList<>();
			for (int column = 0; column < columnNumber; column++) {
				temp.add(resultSet.getMetaData().getColumnName(column + 1));
			}
			arrayList.add(temp);

			while(resultSet.next()){
				temp=new ArrayList<>();
				for(int column=0;column<columnNumber;column++) {
						try {
							temp.add(resultSet.getString(column + 1));
						} catch (Exception e) {
							temp.add("");
						}
				}
				arrayList.add(temp);
			}
			result = new String[arrayList.size()][];
			Iterator out = arrayList.iterator();
			int i=0;
			while(out.hasNext()) {
				int j=0;
				result[i]=new String[temp.size()];
				Iterator in = ((ArrayList)out.next()).iterator();
				while(in.hasNext()) {
					result[i][j]=(String) in.next();
					j++;
				}
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean update(Statement statement, String command) {
		try {
			if (statement.executeUpdate(command) == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean close(Connection connection, Statement statement, ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
