package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection {

	public static final String DRIVER = "org.sqlite.JDBC";
	private Connection conn;
	private Statement stat;
	private PreparedStatement  insertWord;
	private PreparedStatement  insertWordTFIDF;
	private PreparedStatement  insertLemma;
	private PreparedStatement  insertLemmaTFIDF;
	private PreparedStatement  insertBigram;
	private PreparedStatement  insertBigramTFIDF;
	private PreparedStatement  insertBigramLemma;
	private PreparedStatement  insertBigramLemmaTFIDF;
	
	public SQLConnection(String databaseName) throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		String databaseURL = "jdbc:sqlite:" + databaseName;
		conn = DriverManager.getConnection(databaseURL);
		stat = conn.createStatement();
		conn.setAutoCommit(false);
		createTables();
		insertWord = conn.prepareStatement("insert into words values (?,?,?,?,?)");
		insertWordTFIDF = conn.prepareStatement("insert into wordsTFIDF values (?,?,?)");
		insertLemma = conn.prepareStatement("insert into lemmas values (?,?,?,?,?)");
		insertLemmaTFIDF = conn.prepareStatement("insert into lemmasTFIDF values (?,?,?)");
		
		insertBigram = conn.prepareStatement("insert into bigrams values (?,?,?,?,?,?,?,?,?)");
		insertBigramTFIDF = conn.prepareStatement("insert into bigramsTFIDF values (?,?,?,?)");
		insertBigramLemma = conn.prepareStatement("insert into bigramsLemma values (?,?,?,?,?,?,?,?,?)");
		insertBigramLemmaTFIDF = conn.prepareStatement("insert into bigramsLemmaTFIDF values (?,?,?,?)");
	}
	
	private void createTables() throws SQLException
	{
		String createWords = "CREATE TABLE IF NOT EXISTS words (word varchar(255) PRIMARY KEY, count int, numberOfSentences int, numberOfDocuments int, percentOfDocuments real)";
		String createWordsTFIDF = "CREATE TABLE IF NOT EXISTS wordsTFIDF (word varchar(255), document varchar(255), tfidf real)";

		String createLemmas = "CREATE TABLE IF NOT EXISTS lemmas (word varchar(255) PRIMARY KEY, count int, numberOfSentences int, numberOfDocuments int, percentOfDocuments real)";
		String createLemmasTFIDF = "CREATE TABLE IF NOT EXISTS lemmasTFIDF (word varchar(255), document varchar(255), tfidf real)";
		
		String createBigrams = "CREATE TABLE IF NOT EXISTS bigrams "
				+ "(word1 varchar(255), word2 varchar(255), count int, numberOfSentences int, numberOfDocuments int, percentOfDocuments real, "
				+ "percentOfSentence real, percentOfSentencew1 real, percentOfSentencew2 real)";
		String createBigramsTFIDF = "CREATE TABLE IF NOT EXISTS bigramsTFIDF (word1 varchar(255), word2 varchar(255), document varchar(255), tfidf real)";
		
		String createBigramsLemma = "CREATE TABLE IF NOT EXISTS bigramsLemma "
				+ "(word1 varchar(255), word2 varchar(255), count int, numberOfSentences int, numberOfDocuments int, percentOfDocuments real, "
				+ "percentOfSentence real, percentOfSentencew1 real, percentOfSentencew2 real)";
		String createBigramsLemmaTFIDF = "CREATE TABLE IF NOT EXISTS bigramsLemmaTFIDF (word1 varchar(255), word2 varchar(255), document varchar(255), tfidf real)";
		
		stat.execute(createWords);
		stat.execute(createWordsTFIDF);
		stat.execute(createLemmas);
		stat.execute(createLemmasTFIDF);
		stat.execute(createBigrams);
		stat.execute(createBigramsTFIDF);
		stat.execute(createBigramsLemma);
		stat.execute(createBigramsLemmaTFIDF);
		conn.commit();
	}
	
	public void addWordStats(String word, int count, int numberOfSentences, int numberOfDocuments, double percentOfDocuments) throws SQLException {
		insertWord.setString(1, word);
		insertWord.setInt(2, count);
		insertWord.setInt(3, numberOfSentences);
		insertWord.setInt(4, numberOfDocuments);
		insertWord.setDouble(5, percentOfDocuments);
		insertWord.addBatch();
	}
	
	public void addWordTFIDFStats(String word, String document,  double tfidf) throws SQLException {
		insertWordTFIDF.setString(1, word);
		insertWordTFIDF.setString(2, document);
		insertWordTFIDF.setDouble(3, tfidf);
		insertWordTFIDF.addBatch();
	}
	
	public void addLemmaStats(String word, int count, int numberOfSentences, int numberOfDocuments, double percentOfDocuments) throws SQLException {
		insertLemma.setString(1, word);
		insertLemma.setInt(2, count);
		insertLemma.setInt(3, numberOfSentences);
		insertLemma.setInt(4, numberOfDocuments);
		insertLemma.setDouble(5, percentOfDocuments);
		insertLemma.addBatch();
	}
	
	public void addLemmaTFIDFStats(String word, String document,  double tfidf) throws SQLException {
		insertLemmaTFIDF.setString(1, word);
		insertLemmaTFIDF.setString(2, document);
		insertLemmaTFIDF.setDouble(3, tfidf);
		insertLemmaTFIDF.addBatch();
	}
	
	
	public void addBigramStats(String word1, String word2, int count, int numberOfSentences, int numberOfDocuments, double percentOfDocuments,
			double percentOfSentence, double percentOfSentencew1, double percentOfSentencew2) throws SQLException {
		insertBigram.setString(1, word1);
		insertBigram.setString(2, word2);
		insertBigram.setInt(3, count);
		insertBigram.setInt(4, numberOfSentences);
		insertBigram.setInt(5, numberOfDocuments);
		insertBigram.setDouble(6, percentOfDocuments);
		insertBigram.setDouble(7, percentOfSentence);
		insertBigram.setDouble(8, percentOfSentencew1);
		insertBigram.setDouble(9, percentOfSentencew2);
		insertBigram.addBatch();
	}
	
	public void addBigramTFIDFStats(String word1, String word2, String document,  double tfidf) throws SQLException {
		insertBigramTFIDF.setString(1, word1);
		insertBigramTFIDF.setString(2, word2);
		insertBigramTFIDF.setString(3, document);
		insertBigramTFIDF.setDouble(4, tfidf);
		insertBigramTFIDF.addBatch();
	}
	
	
	public void addBigramLemmaStats(String word1, String word2, int count, int numberOfSentences, int numberOfDocuments, double percentOfDocuments,
			double percentOfSentence, double percentOfSentencew1, double percentOfSentencew2) throws SQLException {
		insertBigramLemma.setString(1, word1);
		insertBigramLemma.setString(2, word2);
		insertBigramLemma.setInt(3, count);
		insertBigramLemma.setInt(4, numberOfSentences);
		insertBigramLemma.setInt(5, numberOfDocuments);
		insertBigramLemma.setDouble(6, percentOfDocuments);
		insertBigramLemma.setDouble(7, percentOfSentence);
		insertBigramLemma.setDouble(8, percentOfSentencew1);
		insertBigramLemma.setDouble(9, percentOfSentencew2);
		insertBigramLemma.addBatch();
	}
	
	public void addBigramLemmaTFIDFStats(String word1, String word2, String document,  double tfidf) throws SQLException {
		insertBigramLemmaTFIDF.setString(1, word1);
		insertBigramLemmaTFIDF.setString(2, word2);
		insertBigramLemmaTFIDF.setString(3, document);
		insertBigramLemmaTFIDF.setDouble(4, tfidf);
		insertBigramLemmaTFIDF.addBatch();
	}
	
	public void commit() throws SQLException {
		insertWord.executeBatch();
		insertWordTFIDF.executeBatch();
		insertLemma.executeBatch();
		insertLemmaTFIDF.executeBatch();
		
		insertBigram.executeBatch();
		insertBigramTFIDF.executeBatch();
		insertBigramLemma.executeBatch();
		insertBigramLemmaTFIDF.executeBatch();
		conn.commit();
	}
	
	public void closeConnection() throws SQLException {
		conn.close();
	}
	
}
