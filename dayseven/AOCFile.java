package com.example.dayseven;

public class AOCFile {

	String fileName;
	int fileSize;

	
	public AOCFile(String fName, int fSize) {
		fileName = fName;
		fileSize = fSize;
	}
	
	
	public AOCFile() {
		// TODO Auto-generated constructor stub
	}

	public void setFileSize(int fSize) {
		fileSize = fSize;
	}
	
	public int getFileSize() {
		return fileSize;
	}
	
}
