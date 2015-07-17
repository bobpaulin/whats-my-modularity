package com.bobpaulin.modularity.pos.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

import com.bobpaulin.modularity.api.PartOfSpeechService;
import com.bobpaulin.modularity.api.PartOfSpeechTag;

public class PartOfSpeechServiceImpl implements PartOfSpeechService {
	
	private POSTaggerME tagger;
	
	private Properties posConverter;
	
	public PartOfSpeechServiceImpl()
	{
		InputStream modelIn = null;

		try {
		  modelIn = getClass().getResourceAsStream("/en-pos-maxent.bin");
		  POSModel model = new POSModel(modelIn);
		  tagger = new POSTaggerME(model);
		  posConverter = new Properties();
		  posConverter.load(getClass().getResourceAsStream("/pos-convert.properties"));
		  
		}
		catch (IOException e) {
		  // Model loading failed, handle the error
		  e.printStackTrace();
		}
		finally {
		  if (modelIn != null) {
		    try {
		      modelIn.close();
		    }
		    catch (IOException e) {
		    }
		  }
		}
	}
	public List<PartOfSpeechTag> parseSentence(String sentence) {
		List<PartOfSpeechTag> result = new ArrayList<PartOfSpeechTag>();
		String[] sentenceTokens = sentence.split(" ");
		String[] tags = tagger.tag(sentenceTokens);
		for(int tokenPosition = 0; tokenPosition < sentenceTokens.length; tokenPosition++)
		{
			result.add(new PartOfSpeechTag(sentenceTokens[tokenPosition], posConverter.getProperty(tags[tokenPosition])));
		}
		return result;
	}
}
