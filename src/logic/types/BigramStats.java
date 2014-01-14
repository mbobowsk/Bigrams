package logic.types;

public class BigramStats {
	
	private final String word1;
	private final String word2;
	private final int count;
	private final int sentenceCount;
	private final int docCount;
	private final double docPercent;
	
	public BigramStats(String word1, String word2, int count, int sentenceCount, int docCount,
			double docPercent) {
		this.word1 = word1;
		this.word2 = word2;
		this.count = count;
		this.sentenceCount = sentenceCount;
		this.docCount = docCount;
		this.docPercent = docPercent;
	}
	
	public String getWord1() {
		return word1;
	}
	
	public String getWord2() {
		return word2;
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
