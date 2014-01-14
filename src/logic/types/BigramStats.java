package logic.types;

public class BigramStats {
	
	private final String word1;
	private final String word2;
	private final int count;
	private final int sentenceCount;
	private final int docCount;
	private final double docPercent;
	private final double Ps1;
	private final double Ps2;
	private final double Px;
	public BigramStats(String word1, String word2, int count, int sentenceCount, int docCount,
			double docPercent, double Ps1, double Ps2, double Px) {
		this.word1 = word1;
		this.word2 = word2;
		this.count = count;
		this.sentenceCount = sentenceCount;
		this.docCount = docCount;
		this.docPercent = docPercent;
		this.Ps1 = Ps1;
		this.Ps2 = Ps2;
		this.Px = Px;
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

	public double getPs1() {
		return Ps1;
	}

	public double getPs2() {
		return Ps2;
	}

	public double getPx() {
		return Px;
	}

	
}
