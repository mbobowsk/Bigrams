package sql;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import view.WordModel;
import logic.types.WordStats;

public class SQLRead {
	public static final String DRIVER = "org.sqlite.JDBC";
	private Connection conn;
	public SQLRead(String databaseName) throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		String databaseURL = "jdbc:sqlite:" + databaseName;
		conn = DriverManager.getConnection(databaseURL);
	}
	
	public WordModel getWordModel() throws SQLException {
		ArrayList<WordStats> wordsStats = new ArrayList<WordStats>();
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery( "SELECT * FROM words;" );
		while ( rs.next() ) {
			WordStats wordStats = new WordStats(rs.getString("word"), rs.getInt("count"),
					rs.getInt("numberOfSentences"), rs.getInt("numberOfDocuments"), 
					rs.getDouble("percentOfDocuments"));
			wordsStats.add(wordStats);
		}
		WordModel model = new WordModel(wordsStats);
		return model;
	}
}