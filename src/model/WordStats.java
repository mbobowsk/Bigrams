package model;

public class WordStats {
	
	private final String word;
	private final int count;
	private final int sentenceCount;
	private final int docCount;
	private final double docPercent;
	
	public WordStats(String word, int count, int sentenceCount, int docCount,
			double docPercent) {
		this.word = word;
		this.count = count;
		this.sentenceCount = sentenceCount;
		this.docCount = docCount;
		this.docPercent = docPercent;
	}
	
	public String getWord() {
		return word;
	}
	
	public int getCount() {
		return count;
	}

	public int getSentenceCount() {
		return sentenceCount;
	}

	public int getDocCount() {
		return docCount;
	}

	public double getDocPercent() {
		return docPercent;
	}
	
}
