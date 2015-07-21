package com.bobpaulin.modularity.control.internal;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;

import com.bobpaulin.modularity.api.MediaParser;
import com.bobpaulin.modularity.api.PartOfSpeechService;
import com.bobpaulin.modularity.api.PartOfSpeechTag;

public class ControlCommand {
	
	private MediaParser mediaParser;
	
	private PartOfSpeechService posService;
	
	public void convert(String filePath) throws IOException
	{
		List<PartOfSpeechTag> posTagList = processFile(filePath);
		
		posTagList.forEach(posTag -> System.out.println(posTag));
	}
	
	List<PartOfSpeechTag> processFile(String filePath) throws IOException {
		byte[] fileBytes = Files.readAllBytes(FileSystems.getDefault().getPath(filePath));
		
		String sentence = mediaParser.parseFile(fileBytes);
		
		sentence = sentence.replaceAll("\n", " ");
		
		System.out.println("Sentence: " + sentence);
		
		List<PartOfSpeechTag> posTagList = posService.parseSentence(sentence);
		
		return posTagList;
	}
	
	public void setMediaParser(MediaParser mediaParser) {
		this.mediaParser = mediaParser;
	}
	
	public void setPosService(PartOfSpeechService posService) {
		this.posService = posService;
	}
}
