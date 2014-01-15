package logic.types;

public class TfidfBigramStats {
	
	private final String word1;
	private final String word2;
	private final String doc;
	private final double value;
	
	public TfidfBigramStats(String word1, String word2, String doc, double tfidf) {
		this.word1 = word1;
		this.word2 = word2;
		this.doc = doc;
		this.value = tfidf;
	}

	public String getWord1() {
		return word1;
	}
	
	public String getWord2() {
		return word2;
	}
	
	public String getDoc() {
		return doc;
	}

	public double getValue() {
		return value;
	}
}
