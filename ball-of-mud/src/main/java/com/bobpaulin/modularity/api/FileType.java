package com.bobpaulin.modularity.api;

public enum FileType {
	IMAGE,TEXT,UNKNOWN;
	
	public static FileType getFileType(String mediaType)
	{
		FileType result = FileType.UNKNOWN;
		if(mediaType != null && mediaType.startsWith("image"))
		{
			result = FileType.IMAGE;
		}
		else if(mediaType != null && mediaType.startsWith("text"))
		{
			result = FileType.TEXT;
		}
		return result;
	}
}
