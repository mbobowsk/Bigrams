package logic;

import gate.Annotation;
import gate.AnnotationSet;
import gate.Corpus;
import gate.CorpusController;
import gate.Document;
import gate.Factory;
import gate.FeatureMap;
import gate.Gate;
import gate.Node;
import gate.annotation.AnnotationImpl;
import gate.util.GateException;
import gate.util.persistence.PersistenceManager;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import logic.types.ParsedDocument;
import logic.types.Sentence;

public class GateController {

	private static final String APP_PATH = "res/app.xml";
	private static final String DOC_PATH = "texts/wash_short.txt";
	
	public GateController() throws GateException {
		Gate.init();
	}
	
	// Na razie zakładamy, że jest jeden dokument
	public ParsedDocument parseDocument(String path) throws Exception {
		File appFile = new File(APP_PATH);
		// load the saved application
		CorpusController application = (CorpusController) PersistenceManager
				.loadObjectFromFile(appFile);

		Corpus corpus = Factory.newCorpus("BatchProcessApp Corpus");
		application.setCorpus(corpus);

		File docFile = new File(DOC_PATH);
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
	
	public static void main(String[] args) throws Exception {
		GateController gc = new GateController();
		gc.parseDocument(DOC_PATH);
	}
	
}