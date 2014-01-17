package logic;

import gate.Annotation;
import gate.AnnotationSet;
import gate.Corpus;
import gate.CorpusController;
import gate.Document;
import gate.Factory;
import gate.Gate;
import gate.util.GateException;
import gate.util.persistence.PersistenceManager;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import logic.Options.BigramType;
import logic.types.ParsedDocument;
import logic.types.Sentence;
import logic.types.Token;
import logic.stats.Stats;
import sql.SQLWrite;


public class Controller {

	private static final String APP_PATH = "res/app.xml";
	public Controller() throws GateException {
		Gate.init();
	}
	
	public void calculate(Options options) throws Exception {
		Stats stats = new Stats();
		
		for (String path : options.getPaths()) {
			ParsedDocument doc = parseDocument(path);
			stats.setDocument(path);
			for(Sentence sentence : doc) {
				stats.newSentence();
				if(options.getBigramType()==BigramType.FOLLOWING_WORDS)
					bigramFollowing(sentence, stats);
				else
					bigramPOS(sentence, stats, options.getPos1(), options.getPos2());

			}
		}
		
		System.out.println("stats has been computed");
		SQLWrite sql = new SQLWrite(options.getFileName());
		stats.saveStats(sql);
		sql.closeConnection();
	}
	
	private ParsedDocument parseDocument(String path) throws Exception {
		File appFile = new File(APP_PATH);
		// load the saved application
		CorpusController application = (CorpusController) PersistenceManager
				.loadObjectFromFile(appFile);

		Corpus corpus = Factory.newCorpus("BatchProcessApp Corpus");
		application.setCorpus(corpus);

		File docFile = new File(path);
		System.out.print("Processing document " + docFile + "...");
		Document doc = Factory.newDocument(docFile.toURL());

		corpus.add(doc);

		application.execute();
		
		AnnotationSet set = doc.getAnnotations();
		
		ParsedDocument document = parse(set);

		corpus.clear();

		// Release the document, as it is no longer needed
		Factory.deleteResource(doc);

		System.out.println("All done");
		
		return document;
	}
	
	// Get sorted list of sentence from all annotations set
	private ParsedDocument parse(AnnotationSet set) {
		
		ParsedDocument document = new ParsedDocument();
		
		AnnotationSet sentences = set.get("Sentence");
		AnnotationSet tokens = set.get("Token");
	
		LinkedList<Annotation> sortedSentences = sortByOffset(sentences);
		
		for (Annotation sentence : sortedSentences) {
			
			Long begin = sentence.getStartNode().getOffset();
			Long end = sentence.getEndNode().getOffset();
			
			AnnotationSet sentenceTokens = tokens.get(begin, end);
			LinkedList<Annotation> sortedSentenceTokens = sortByOffset(sentenceTokens);
			
			document.add(new Sentence(sortedSentenceTokens));
		}
		
		return document;
	}
	
	private LinkedList<Annotation> sortByOffset(AnnotationSet set) {
		LinkedList<Annotation> ret = new LinkedList<Annotation>(set);
		Collections.sort(ret, new gate.util.OffsetComparator());
		return ret;
	}	
	
	private void bigramFollowing(Sentence sentence, Stats stats) {
		Token prev = new Token(null, null, null);
		Token cur = new Token(null, null, null);
		Iterator<Token> itr = sentence.iterator();
		while(itr.hasNext())
		{
			cur = itr.next();
			stats.addWord(cur);
			stats.addBigram(prev, cur);
			prev = cur;
		}
		stats.addBigram(cur, new Token(null, null, null));
	}
	
	private void bigramPOS(Sentence sentence, Stats stats, ArrayList<String> POS1, ArrayList<String> POS2) {
		Token first = new Token(null, null, null);
		Token second = new Token(null, null, null);
		for(int i=0; i<sentence.size(); i++)
		{
			first = sentence.get(i);
			stats.addWord(sentence.get(i));
			if(POS1.contains(first.getPos()))
				for(int j=0; j<sentence.size(); j++) {
					second = sentence.get(j);
					if(POS2.contains(second.getPos()))
						stats.addBigram(first, second);
				}
		}
	}
	

}
