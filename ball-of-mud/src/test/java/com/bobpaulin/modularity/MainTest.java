package com.bobpaulin.modularity;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Test;

import com.bobpaulin.modularity.api.PartOfSpeechTag;

public class MainTest {

	@Test
	public void testIntegration() throws IOException, URISyntaxException {
		
		File file = new File("src/test/resources/testDoc.txt");
		List<PartOfSpeechTag> results = Main.processFile(file.getAbsolutePath());
		
		assertEquals("Should have 4 Parts of Speach", 4, results.size());
	}

}
