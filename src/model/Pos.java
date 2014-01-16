package model;

public class Pos {
	
	private final String shortName;
	private final String description;
	
	public Pos(String shortName, String description) {
		this.shortName = shortName;
		this.description = description;
	}

	public String getShortName() {
		return shortName;
	}

	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return shortName + " (" + description + ")";
	}
}
