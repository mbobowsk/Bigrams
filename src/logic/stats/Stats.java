package logic.stats;
import java.util.*;
import logic.types.Token;
import logic.term.Bigram;

public class Stats {
	private Map<Object, TermStats> wordsStats = new HashMap<Object, TermStats>();
	private Map<Object, TermStats> lemmasStats = new HashMap<Object, TermStats>();
	private Map<Object, TermStats> bigramsStats = new HashMap<Object, TermStats>();
	private Map<Object, TermStats> bigramLemmaStats = new HashMap<Object, TermStats>();
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
		
	}
	
	public void addBigram(Token token1, Token token2) {
		Bigram bigram = new Bigram(token1.getWord(), token2.getWord());
		Bigram bigramLemma = new Bigram(token1.getLemma(), token2.getLemma());
		addTermStats(bigram, bigramsStats, bigramsInSentence);
		addTermStats(bigramLemma, bigramLemmaStats, bigramsLemmaInSentence);
		
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
	
}
