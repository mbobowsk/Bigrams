package logic.types;

public class Token {

	private String word;
	private String lemma;
	private String pos;
	
	public Token(String word, String lemma, String pos) {
		this.word = word;
		this.lemma = lemma;
		this.pos = pos;
	}

	public String getWord() {
		return word;
	}

	public String getLemma() {
		return lemma;
	}

	public String getPos() {
		return pos;
	}

}
