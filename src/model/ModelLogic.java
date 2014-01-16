package model;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class ModelLogic {
	
	public static DefaultListModel initPosModel() {
		DefaultListModel m = new DefaultListModel();
		m.addElement(new Pos("CC", "coordinating conjunction"));
		m.addElement(new Pos("CD", "cardinal number"));
		m.addElement(new Pos("DT", "determiner"));
		m.addElement(new Pos("EX", "existential ‘there’"));
		m.addElement(new Pos("FW", "foreign word"));
		m.addElement(new Pos("IN", "preposition or subordinating conjunction"));
		m.addElement(new Pos("JJ", "adjective"));
		m.addElement(new Pos("JJR", "adjective - comparative"));
		m.addElement(new Pos("JJS", "adjective - superlative"));
		m.addElement(new Pos("JJSS", ""));
		m.addElement(new Pos("LRB", ""));
		m.addElement(new Pos("LS", "list item marker"));
		m.addElement(new Pos("MD", "modal"));
		m.addElement(new Pos("NN", "noun"));
		m.addElement(new Pos("NNP", "proper noun - singular"));
		m.addElement(new Pos("NNPS", "proper noun - plural"));
		m.addElement(new Pos("NNS", "noun - plural"));
		m.addElement(new Pos("NP", "proper noun - singular"));
		m.addElement(new Pos("NPS", "proper noun - plural"));
		m.addElement(new Pos("PDT", "predeterminer"));
		m.addElement(new Pos("POS", "possessive ending"));
		m.addElement(new Pos("PP", "personal pronoun"));
		m.addElement(new Pos("PRPR$", ""));
		m.addElement(new Pos("PRP", ""));
		m.addElement(new Pos("PRP$", ""));
		m.addElement(new Pos("RB", "adverb"));
		m.addElement(new Pos("RBR", "adverb - comparative"));
		m.addElement(new Pos("RBS", "adverb - superlative"));
		m.addElement(new Pos("RP", "particle"));
		m.addElement(new Pos("SYM", "symbol"));
		m.addElement(new Pos("TO", "literal to"));
		m.addElement(new Pos("UH", "interjection"));
		m.addElement(new Pos("VBD", "verb - past tense"));
		m.addElement(new Pos("VBG", "verb - gerund or present participle"));
		m.addElement(new Pos("VBN", "verb - past participle"));
		m.addElement(new Pos("VBP", "verb - non-3rd person singular present"));
		m.addElement(new Pos("VB", "verb - base form"));
		m.addElement(new Pos("VBZ", "verb - 3rd person singular present"));
		m.addElement(new Pos("WDT", "‘wh’-determiner"));
		m.addElement(new Pos("WP$", "possessive ‘wh’-pronoun:"));
		m.addElement(new Pos("WP", "‘wh’-pronoun"));
		m.addElement(new Pos("WRB", "‘wh’-adverb"));
		return m;
	}
	
	public static ArrayList<String> getShortNamesFromModel(DefaultListModel model) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i=0; i < model.size(); i++) {
			Pos p = (Pos) model.get(i);
			list.add(p.getShortName());
		}
		return list;
	}
}
