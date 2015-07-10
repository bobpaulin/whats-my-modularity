package com.bobpaulin.modularity.ocr.internal;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import com.bobpaulin.modularity.api.OcrService;

public class OcrServiceImpl implements OcrService {
	public String getText(byte[] image) {
		Tesseract instance = Tesseract.getInstance(); // JNA Direct Mapping
        instance.setDatapath(new File("/data/tessdata").getAbsolutePath());
        String result = "";
        try 
        {
        	InputStream  bais = new ByteArrayInputStream(image);
        	result = instance.doOCR(ImageIO.read(bais));
        } 
        catch (TesseractException e) 
        {
        	System.err.println(e.getMessage());
        }
        catch(IOException e)
        {
        	System.err.println(e.getMessage());
        }
        return result.trim();
	}
}
