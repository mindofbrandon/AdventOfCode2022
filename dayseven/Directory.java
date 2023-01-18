package com.example.dayseven;

import java.util.ArrayList;
import java.util.List;

public class Directory {

	String directoryName;
	
	List<String> directories = new ArrayList<>();
	
	List<AOCFile> file = new ArrayList<>();
	
	Boolean isUnder = false;
	
	int sizeOfDirectory;
	
	public Directory(String n) {
		directoryName = n;
	}
	
	public Directory() {
		// TODO Auto-generated constructor stub
	}

	public void setDirectoryName(String n) {
		directoryName = n;
	}
	
	public String getDirectoryName() {
		return directoryName;
		
	}
	
	public void addDirectory(String dir) {
		directories.add(dir);
	}
	
	public void addFile(AOCFile f) {
		file.add(f);
	}
	
	public String getFileName(int j) {
		return file.get(j).fileName;
	}
	
	public AOCFile getFile(int f) {
		return file.get(f);
	}	
}
