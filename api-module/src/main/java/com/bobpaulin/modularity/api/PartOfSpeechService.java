package com.bobpaulin.modularity.api;

import java.util.List;

public interface PartOfSpeechService {
	public List<PartOfSpeechTag> parseSentence(String sentence);
}
