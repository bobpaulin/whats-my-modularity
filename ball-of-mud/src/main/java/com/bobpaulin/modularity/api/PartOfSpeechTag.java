package com.bobpaulin.modularity.api;

public class PartOfSpeechTag {
	private String word;
	private String partOfSpeechTag;
	
	public PartOfSpeechTag() {
	}
	
	public PartOfSpeechTag(String word, String partOfSpeechTag) {
		this.word = word;
		this.partOfSpeechTag = partOfSpeechTag;
	}
	
	public String getWord() {
		return word;
	}
	
	public String getPartOfSpeechTag() {
		return partOfSpeechTag;
	}
	
	public void setPartOfSpeechTag(String partOfSpeechTag) {
		this.partOfSpeechTag = partOfSpeechTag;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	@Override
	public String toString() {
		return "Word: " + this.word + " POS: " + partOfSpeechTag;
	}
}
