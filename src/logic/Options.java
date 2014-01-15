package logic;

import java.util.ArrayList;

public class Options {
	
	public enum BigramType {
		FOLLOWING_WORDS,
		SENTENCE
	}
	
	// List of files to process
	private ArrayList<String> paths;
	
	private BigramType bigramType;
	// Part-of-speech selection for both words
	// List of pos: http://gate.ac.uk/sale/tao/splitap7.html#x37-764000G
	private ArrayList<String> pos1;
	private ArrayList<String> pos2;
	
	private String fileName;
	
	public Options(ArrayList<String> paths, BigramType bigramType,
			ArrayList<String> pos1, ArrayList<String> pos2,
			String fileName) {
		this.paths = paths;
		this.bigramType = bigramType;
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.fileName = fileName;
	}
	
	public ArrayList<String> getPaths() {
		return paths;
	}
	public BigramType getBigramType() {
		return bigramType;
	}
	public ArrayList<String> getPos1() {
		return pos1;
	}
	public ArrayList<String> getPos2() {
		return pos2;
	}

	public String getFileName() {
		return fileName;
	}
	
}
