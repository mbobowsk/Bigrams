package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
	private static final String DRIVER = "org.sqlite.JDBC";
	protected Connection conn;
	
	public SQLConnection(String databaseName) throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		String databaseURL = "jdbc:sqlite:" + databaseName;
		conn = DriverManager.getConnection(databaseURL);
	}
	
	public void closeConnection() throws SQLException {
		conn.close();
	}
	
}
