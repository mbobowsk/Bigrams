package test;

import gate.Document;
import gate.Corpus;
import gate.CorpusController;
import gate.AnnotationSet;
import gate.DocumentContent;
import gate.FeatureMap;
import gate.Gate;
import gate.Factory;
import gate.SimpleDocument;
import gate.util.*;
import gate.util.persistence.PersistenceManager;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.OutputStreamWriter;

public class GateTest {

	private static final String APP_PATH = "res/app.xml";
	private static final String DOC_PATH = "texts/wash_short.txt";

	public static void main(String[] args) throws Exception {

		Gate.init();

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

		corpus.clear();

		String docXMLString = null;

		docXMLString = doc.toXml();

		// Release the document, as it is no longer needed
		Factory.deleteResource(doc);

		// output the XML to <inputFile>.out.xml
		String outputFileName = docFile.getName() + ".out.xml";
		File outputFile = new File(docFile.getParentFile(), outputFileName);

		// Write output files using the same encoding as the original
		FileOutputStream fos = new FileOutputStream(outputFile);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		OutputStreamWriter out;
		out = new OutputStreamWriter(bos);

		out.write(docXMLString);

		out.close();

		System.out.println("All done");
	}

}