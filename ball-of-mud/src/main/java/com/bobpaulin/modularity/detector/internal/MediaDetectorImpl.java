package com.bobpaulin.modularity.detector.internal;

import org.apache.tika.Tika;

import com.bobpaulin.modularity.api.FileType;
import com.bobpaulin.modularity.api.MediaDetector;

public class MediaDetectorImpl implements MediaDetector{
	
	private Tika tika;
	
	public MediaDetectorImpl() {
		this.tika = new Tika();
	}
	
	public FileType detectFileType(byte[] file) {
		String mediaType = tika.detect(file);
		return FileType.getFileType(mediaType);
	}
}
