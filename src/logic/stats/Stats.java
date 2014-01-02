package logic.stats;
import java.sql.SQLException;
import java.util.*;

import logic.types.Token;
import logic.term.Bigram;
import sql.SQLConnection;

public class Stats {
	private Map<Object, TermStats> wordsStats = new HashMap<Object, TermStats>();
	private Map<Object, TermStats> lemmasStats = new HashMap<Object, TermStats>();
	private Map<Object, TermStats> bigramsStats = new HashMap<Object, TermStats>();
	private Map<Object, TermStats> bigramLemmaStats = new HashMap<Object, TermStats>();
	private Map<String, Integer> wordsInDoc = new HashMap<String, Integer>();
	private Map<String, Integer> bigramsInDoc = new HashMap<String, Integer>();
	private String currentDocument;
	private Set<Object> wordsInSentence = new HashSet<Object>();
	private Set<Object> lemmasInSentence = new HashSet<Object>();
	private Set<Object> bigramsInSentence = new HashSet<Object>();
	private Set<Object> bigramsLemmaInSentence = new HashSet<Object>();	
	private int numberOfDocs = 0;
	private int numberOfSentences = 0;
	
	public void setDocument(String doc) {
		currentDocument = doc;
		numberOfDocs++;
		wordsInSentence = new HashSet<Object>();
	}
	
	public void newSentence() {
		wordsInSentence = new HashSet<Object>();
		lemmasInSentence = new HashSet<Object>();
		bigramsInSentence = new HashSet<Object>();
		
		numberOfSentences++;
	}
	
	public void addWord(Token token) {
		addTermStats(token.getWord(), wordsStats, wordsInSentence);
		addTermStats(token.getLemma(), lemmasStats, lemmasInSentence);
		Integer number = wordsInDoc.get(currentDocument);
		if(number==null) {
			number = new Integer(0);
			wordsInDoc.put(currentDocument, number);
		}
			
		number++;
		
	}
	
	public void addBigram(Token token1, Token token2) {
		Bigram bigram = new Bigram(token1.getWord(), token2.getWord());
		Bigram bigramLemma = new Bigram(token1.getLemma(), token2.getLemma());
		addTermStats(bigram, bigramsStats, bigramsInSentence);
		addTermStats(bigramLemma, bigramLemmaStats, bigramsLemmaInSentence);
		Integer number = bigramsInDoc.get(currentDocument);
		if(number==null) {
			number = new Integer(0);
			bigramsInDoc.put(currentDocument, number);
		}	
		number++;
		
	}
	
	private void addTermStats(Object term, Map<Object, TermStats> stats, Set<Object> list)
	{
		TermStats wordStats = stats.get(term);
		if(wordStats == null)
		{
			wordStats = new TermStats();
			stats.put(term, wordStats);
		}
		
		if(list.contains(term))
			wordStats.nextOccurance(currentDocument);
		else
		{
			wordStats.newOccurance(currentDocument);
			list.add(term);
		}
		
		
	}
	
	public void saveStats(SQLConnection sql) throws SQLException {
		for(Map.Entry<Object, TermStats> entry: wordsStats.entrySet()) {
			TermStats v = entry.getValue();
			sql.addWordStats((String)entry.getKey(), v.getCount(), v.getNumberOfSentence(), v.getNumberOfDocuments(), (double)v.getNumberOfDocuments()/(double)numberOfDocs);
			for(Map.Entry<String, Integer> entry2: wordsInDoc.entrySet()) {
				String doc = entry2.getKey();
				double tfidf = calcTDIF(doc, v, wordsInDoc);
				sql.addWordTFIDFStats((String)entry.getKey(), doc, tfidf);
				
			}
		}

		for(Map.Entry<Object, TermStats> entry: lemmasStats.entrySet()) {
			TermStats v = entry.getValue();
			sql.addLemmaStats((String)entry.getKey(), v.getCount(), v.getNumberOfSentence(), v.getNumberOfDocuments(), (double)v.getNumberOfDocuments()/(double)numberOfDocs);
			for(Map.Entry<String, Integer> entry2: wordsInDoc.entrySet()) {
				String doc = entry2.getKey();
				double tfidf = calcTDIF(doc, v, wordsInDoc);
				sql.addLemmaTFIDFStats((String)entry.getKey(), doc, tfidf);
				
			}
		}
		
		for(Map.Entry<Object, TermStats> entry: bigramsStats.entrySet()) {
			TermStats v = entry.getValue();
			Bigram bigram = (Bigram)entry.getKey();
			TermStats word1Stats = wordsStats.get(bigram.getWord1());
			TermStats word2Stats = wordsStats.get(bigram.getWord2());
			double word1NumberOfSentence;
			double word2NumberOfSentence;
			if (word1Stats == null)
				word1NumberOfSentence = 0;
			else
				word1NumberOfSentence = word1Stats.getNumberOfSentence();
			if (word2Stats == null)
				word2NumberOfSentence = 0;
			else
				word2NumberOfSentence = word2Stats.getNumberOfSentence();			
			sql.addBigramStats(bigram.getWord1(), bigram.getWord2(), v.getCount(), v.getNumberOfSentence(), v.getNumberOfDocuments(), (double)v.getNumberOfDocuments()/(double)numberOfDocs,
					(double)v.getNumberOfSentence()/(double)numberOfSentences,
					word1NumberOfSentence/(double)numberOfSentences, 
					word2NumberOfSentence/(double)numberOfSentences);
			for(Map.Entry<String, Integer> entry2: bigramsInDoc.entrySet()) {
				String doc = entry2.getKey();
				double tfidf = calcTDIF(doc, v, bigramsInDoc);
				sql.addBigramTFIDFStats(bigram.getWord1(), bigram.getWord2(), doc, tfidf);
				
			}
		}
		
		
		for(Map.Entry<Object, TermStats> entry: bigramLemmaStats.entrySet()) {
			TermStats v = entry.getValue();
			Bigram bigram = (Bigram)entry.getKey();
			TermStats word1Stats = lemmasStats.get(bigram.getWord1());
			TermStats word2Stats = lemmasStats.get(bigram.getWord2());
			double word1NumberOfSentence;
			double word2NumberOfSentence;
			if (word1Stats == null)
				word1NumberOfSentence = 0;
			else
				word1NumberOfSentence = word1Stats.getNumberOfSentence();
			if (word2Stats == null)
				word2NumberOfSentence = 0;
			else
				word2NumberOfSentence = word2Stats.getNumberOfSentence();		
			sql.addBigramLemmaStats(bigram.getWord1(), bigram.getWord2(), v.getCount(), v.getNumberOfSentence(), v.getNumberOfDocuments(), (double)v.getNumberOfDocuments()/(double)numberOfDocs,
					(double)v.getNumberOfSentence()/(double)numberOfSentences, word1NumberOfSentence/(double)numberOfSentences, 
					word2NumberOfSentence/(double)numberOfSentences);
			for(Map.Entry<String, Integer> entry2: bigramsInDoc.entrySet()) {
				String doc = entry2.getKey();
				double tfidf = calcTDIF(doc, v, bigramsInDoc);
				sql.addBigramTFIDFStats(bigram.getWord1(), bigram.getWord2(), doc, tfidf);
				
			}
		}
		
		sql.commit();
		
	}
	
	private double calcTDIF(String doc, TermStats term, Map<String, Integer> termInDoc) {
		double termInDocuments = term.getDocuments(doc);
		double allTermInDocuments = termInDoc.get(doc);
		double documentsWithTerm = term.getNumberOfDocuments();
		double tfidf = (termInDocuments/allTermInDocuments)*Math.log10(numberOfDocs/documentsWithTerm);	
		return tfidf;
		
	}
	
}
