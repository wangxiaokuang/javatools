package tum0r.sql;

import tum0r.error.DataBaseTypeException;

public class SQLFactory {
	public static SQL getSQL(String type) throws DataBaseTypeException {
		SQL sql = null;
		switch (type.toLowerCase().replace(" ", "")) {
		case "mysql":
			sql = new MySQL();
			break;
		case "sqlserver":
			sql = new SQLServer();
			break;
		case "sqlite":
			sql = new SQLite();
			break;
		default:
			throw new DataBaseTypeException(type);
		}
		return sql;
	}
}
