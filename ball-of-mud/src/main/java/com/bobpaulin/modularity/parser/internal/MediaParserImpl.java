package com.bobpaulin.modularity.parser.internal;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.DefaultParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.ocr.TesseractOCRParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import com.bobpaulin.modularity.api.MediaParser;

public class MediaParserImpl implements MediaParser{
	
	private Parser parser;
	
	public MediaParserImpl() {
		DefaultParser defaultParser = new DefaultParser();
    	TesseractOCRParser tessParser = new TesseractOCRParser();
    	parser = new AutoDetectParser(tessParser, defaultParser);
	}
	
	@Override
	public String parseFile(byte[] file) {
		String result = "";
        try 
        {
        	InputStream  bais = new ByteArrayInputStream(file);
        	
        	ParseContext parseContext = new ParseContext();
        	
        	Metadata meta = new Metadata();
        	BodyContentHandler handler = new BodyContentHandler();
           
			parser.parse(bais, handler, meta, parseContext);
            result = handler.toString();
 
        } 
        catch (SAXException e)
        {
        	System.err.println(e.getMessage());
        }
        catch (TikaException e) {
        	System.err.println(e.getMessage());
		}
        catch(IOException e)
        {
        	System.err.println(e.getMessage());
        }
        
        
        
        return result.trim();
	}
}
