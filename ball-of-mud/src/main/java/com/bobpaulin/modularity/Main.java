package com.bobpaulin.modularity;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;

import com.bobpaulin.modularity.api.MediaParser;
import com.bobpaulin.modularity.api.PartOfSpeechService;
import com.bobpaulin.modularity.api.PartOfSpeechTag;
import com.bobpaulin.modularity.parser.internal.MediaParserImpl;
import com.bobpaulin.modularity.pos.internal.PartOfSpeechServiceImpl;

public class Main {

	public static void main(String[] args) throws IOException {
		
		if(args.length < 1)
		{
			System.out.println("java -jar ball-of-mud.jar <file>");
			return;
		}
		
		String filePath = args[0];
		
		List<PartOfSpeechTag> posTagList = processFile(filePath);
		
		posTagList.forEach(posTag -> System.out.println(posTag));

	}

	static List<PartOfSpeechTag> processFile(String filePath) throws IOException {
		byte[] fileBytes = Files.readAllBytes(FileSystems.getDefault().getPath(filePath));
		
		MediaParser mediaParser = new MediaParserImpl();
		
		PartOfSpeechService partOfSpeechService = new PartOfSpeechServiceImpl();
		
		String sentence = mediaParser.parseFile(fileBytes);
		
		sentence = sentence.replaceAll("\n", " ");
		
		System.out.println("Sentence: " + sentence);
		
		List<PartOfSpeechTag> posTagList = partOfSpeechService.parseSentence(sentence);
		
		return posTagList;
	}

}
