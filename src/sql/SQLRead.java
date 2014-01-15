package sql;


import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import view.BigramModel;
import view.WordModel;
import logic.types.BigramStats;
import logic.types.WordStats;

public class SQLRead extends SQLConnection {
	
	public SQLRead(String databaseName) throws ClassNotFoundException, SQLException {
		super(databaseName);
	}

	
	public WordModel getWordModel(boolean lemma) throws SQLException {
		ArrayList<WordStats> wordsStats = new ArrayList<WordStats>();
		
		Statement stmt = conn.createStatement();
		String word;
		if(!lemma)
			word = "words";
		else
			word = "lemmas";
		ResultSet rs = stmt.executeQuery( "SELECT * FROM "+word+";" );
		while ( rs.next() ) {
			WordStats wordStats = new WordStats(rs.getString("word"), rs.getInt("count"),
					rs.getInt("numberOfSentences"), rs.getInt("numberOfDocuments"), 
					rs.getDouble("percentOfDocuments"));
			wordsStats.add(wordStats);
		}
		WordModel model = new WordModel(wordsStats);
		return model;
	}
	
	public BigramModel getBigramModel(boolean lemma) throws SQLException {
		ArrayList<BigramStats> bigramsStats = new ArrayList<BigramStats>();
		
		Statement stmt = conn.createStatement();
		String bigram;
		if(!lemma)
			bigram = "bigrams";
		else
			bigram = "bigramsLemma";
		ResultSet rs = stmt.executeQuery( "SELECT * FROM "+bigram+";" );
		while ( rs.next() ) {
			BigramStats wordStats = new BigramStats(rs.getString("word1"), rs.getString("word2"), rs.getInt("count"),
					rs.getInt("numberOfSentences"), rs.getInt("numberOfDocuments"), 
					rs.getDouble("percentOfDocuments"), rs.getDouble("percentOfSentencew1"),
					rs.getDouble("percentOfSentencew2"), rs.getDouble("percentOfSentence"));
			bigramsStats.add(wordStats);
		}
		BigramModel model = new BigramModel(bigramsStats);
		return model;
	}
	
}