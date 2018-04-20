package tum0r.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class SQL {

	protected Connection connection = null;
	protected Statement statement = null;
	protected ResultSet resultSet = null;

	abstract public boolean open(String address, String port, String databaseName, String username, String password,
			String encode);

	abstract public boolean close();

	abstract public String[][] query(String command);

	abstract public boolean update(String command);
}
