package tum0r.sql;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLite extends SQL {

	@Override
	public boolean open(String address, String port, String databaseName, String username, String password,
			String encode) {
		return open(address, username, password);
	}

	private boolean open(String path, String username, String password) {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + path, username, password);
			statement = connection.createStatement();
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
