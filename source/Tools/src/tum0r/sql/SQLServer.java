package tum0r.sql;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLServer extends SQL {

	@Override
	public boolean open(String address, String port, String databaseName, String username, String password,
			String encode) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(
					"jdbc:sqlserver://" + address + ":" + port + ";DatabaseName=" + databaseName, username, password);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean close() {
		return Execute.close(connection, statement, resultSet);
	}

	@Override
	public String[][] query(String command) {
		return Execute.query(resultSet, statement, command);
	}

	@Override
	public boolean update(String command) {
		return Execute.update(statement, command);
	}

}
