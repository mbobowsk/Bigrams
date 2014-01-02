package logic.types;

import gate.Annotation;
import gate.FeatureMap;

import java.util.LinkedList;

public class Sentence extends LinkedList<Token> {
	

	public Sentence(LinkedList<Annotation> annotations) {
		super();
		for (Annotation a : annotations) {
			FeatureMap features = a.getFeatures();
			String word = (String) features.get("string");
			String lemma = (String) features.get("stem");
			String pos = (String) features.get("category");
			add(new Token(word, lemma, pos));
		}
	}
}
