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
		
		byte[] fileBytes = Files.readAllBytes(FileSystems.getDefault().getPath(args[0]));
		
		MediaParser mediaParser = new MediaParserImpl();
		
		PartOfSpeechService partOfSpeechService = new PartOfSpeechServiceImpl();
		
		String sentence = mediaParser.parseFile(fileBytes);
		
		System.out.println("Sentence: " + sentence);
		
		List<PartOfSpeechTag> posTagList = partOfSpeechService.parseSentence(sentence);
		
		posTagList.forEach(posTag -> System.out.println(posTag));

	}
	
	public static String[] tokenizeSentence(String sentence)
	{
		return sentence.split(" ");
	}

}
