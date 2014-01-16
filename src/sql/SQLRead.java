package sql;


import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BigramModel;
import model.BigramStats;
import model.TfidfBigramModel;
import model.TfidfBigramStats;
import model.TfidfModel;
import model.TfidfStats;
import model.WordModel;
import model.WordStats;

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
	
	public TfidfModel getTfidfModel(boolean lemma) throws SQLException {
		Statement stmt = conn.createStatement();
		String word;
		ArrayList<TfidfStats> tfidfStats = new ArrayList<TfidfStats>();
		if(!lemma)
			word = "wordsTFIDF";
		else
			word = "lemmasTFIDF";
		ResultSet rs = stmt.executeQuery( "SELECT * FROM "+word+";" );
		while ( rs.next() ) {
			TfidfStats stats = new TfidfStats(rs.getString("word"), rs.getString("document"), rs.getDouble("tfidf"));
			tfidfStats.add(stats);
			
		}
		TfidfModel model = new TfidfModel(tfidfStats);
		return model;
		
	}
		public TfidfBigramModel getBigramTfidfModel(boolean lemma) throws SQLException {
			Statement stmt = conn.createStatement();
			String word;
			ArrayList<TfidfBigramStats> tfidfbigramStats = new ArrayList<TfidfBigramStats>();
			if(!lemma)
				word = "bigramsTFIDF";
			else
				word = "bigramsLemmaTFIDF";
			ResultSet rs = stmt.executeQuery( "SELECT * FROM "+word+";" );
			while ( rs.next() ) {
				TfidfBigramStats stats = new TfidfBigramStats(rs.getString("word1"), rs.getString("word2"), rs.getString("document"), rs.getDouble("tfidf"));
				tfidfbigramStats.add(stats);
				
			}
			TfidfBigramModel model = new TfidfBigramModel(tfidfbigramStats);
			return model;
	}
	
	
}