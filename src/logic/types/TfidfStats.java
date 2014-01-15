package logic.types;

public class TfidfStats {
	
	private final String word;
	private final String doc;
	private final double value;
	
	public TfidfStats(String word, String doc, double tfidf) {
		this.word = word;
		this.doc = doc;
		this.value = tfidf;
	}

	public String getWord() {
		return word;
	}

	public String getDoc() {
		return doc;
	}

	public double getValue() {
		return value;
	}
}
