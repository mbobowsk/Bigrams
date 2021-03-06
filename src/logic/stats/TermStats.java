package logic.stats;
import java.util.*;


public class TermStats {
	private int count=0;
	private int numberOfSentence=0;
	private int numberOfDocuments=0;
	private Map<String, Integer> documents = new HashMap<String, Integer>();
	
	public void newOccurance(String document) {
		count++;
		numberOfSentence++;
		Integer countInDoc = documents.get(document);
		if(countInDoc==null) {
			numberOfDocuments++;
			documents.put(document, new Integer(1));
		}
		else
			documents.put(document, ++countInDoc);
	}
	
	public void nextOccurance(String document) {
		count++;
		Integer countInDoc = documents.get(document);
		countInDoc++;
		documents.put(document, ++countInDoc);
	}

	public int getCount() {
		return count;
	}

	public int getNumberOfSentence() {
		return numberOfSentence;
	}

	public int getNumberOfDocuments() {
		return numberOfDocuments;
	}

	public int getDocuments(String doc) {
		Integer number = documents.get(doc);;
		if (number==null)
			number=0;
		return number;
	}
	

	
}
