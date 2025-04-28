package net.java_school.english;

public class WordCard {
	private String word;
	private String definitions;

	public WordCard() {}

	public WordCard(String word, String definitions) {
		this.word = word;
		this.definitions = definitions;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getDefinitions() {
		return definitions;
	}

	public void setDefinitions(String definitions) {
		this.definitions = definitions;
	}
}
