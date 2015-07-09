package com.bobpaulin.modularity;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.bobpaulin.modularity.api.FileType;
import com.bobpaulin.modularity.api.MediaDetector;
import com.bobpaulin.modularity.api.OcrService;
import com.bobpaulin.modularity.api.PartOfSpeechService;
import com.bobpaulin.modularity.api.PartOfSpeechTag;
import com.bobpaulin.modularity.detector.internal.MediaDetectorImpl;
import com.bobpaulin.modularity.ocr.internal.OcrServiceImpl;
import com.bobpaulin.modularity.pos.internal.PartOfSpeechServiceImpl;

public class Main {

	public static void main(String[] args) throws IOException {
		
		if(args.length < 1)
		{
			System.out.println("java -jar ball-of-mud.jar <file>");
			return;
		}
		
		byte[] fileBytes = Files.readAllBytes(FileSystems.getDefault().getPath(args[0]));
		
		MediaDetector detector = new MediaDetectorImpl();
		
		OcrService ocrService = new OcrServiceImpl();
		
		PartOfSpeechService partOfSpeechService = new PartOfSpeechServiceImpl();
		
		FileType type = detector.detectFileType(fileBytes);
		
		System.out.println("Type is " + type);
		
		String sentence = "";
		
		if(type.equals(FileType.TEXT))
		{
			sentence = new String(fileBytes);
		}
		else if(type.equals(FileType.IMAGE))
		{
			sentence = ocrService.getText(fileBytes);
		}
		
		System.out.println("Sentence: " + sentence);
		
		List<PartOfSpeechTag> posTagList = partOfSpeechService.parseSentence(sentence);
		
		posTagList.forEach(posTag -> System.out.println(posTag));

	}

}
