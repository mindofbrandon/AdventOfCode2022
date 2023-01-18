package com.example.dayseven;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DaySeven {

	public static void main(String[] args) {
        
		List<AOCFile> file = new ArrayList<>();
		File inputPath = new File("%directory%");
		String line = "";
		List<String> directories = new ArrayList<>();
		String currentDirectory = "";
		String command = "";
		int totalSize = 0;
		String subDirectory = "";
		List<Directory> directory = new ArrayList<>();	
		
		try {
			
			File fh = new File("%directory%/output.log");  // was used for finding bugs in log
	        PrintStream stream = new PrintStream(fh);
			Scanner scanner = new Scanner(inputPath);
			while (scanner.hasNextLine()) {
	            line = scanner.nextLine();
	            String[] parsed = line.split(" ");

	            // iterate through each space-separated-values in a loop and create a list of directories and files
	            for (int i = 0; i < parsed.length; i++) {
	            	System.out.print(parsed[i] + " ");
	            	
	            	if (parsed[i].equals("$")) {
	            		
	            		i++;
	            		System.out.print(parsed[i] + " ");
	            		command = parsed[i];
	            		if (command.equals("ls"))
	            			System.out.print("\n");
	            		continue;
	            	}
	            	if (parsed[i].equals("cd")) {
	            		currentDirectory = parsed[i];
	            		command = parsed[i];
	            		continue;
	            	}
	            	if (command.equals("cd")) {
	            		
	            		// if command equals cd ..
	            		
	            		if (parsed[i].equals("..")) { // go back until 1 char after /
	            			
	            			while (currentDirectory.charAt(currentDirectory.length()-1) != '/')
		            			currentDirectory = currentDirectory.substring(0, currentDirectory.length()-1);
	            			
		            		if (currentDirectory.equals("/")) {
		            			System.out.print("\nCurrent Directory: " + currentDirectory + "\n");
		            		}
		            		else {
		            			currentDirectory = currentDirectory.substring(0, currentDirectory.length()-1);
		            			System.out.print("\nCurrent Directory: " + currentDirectory + "\n");
		            		}
		            		continue;
	            		}
	            		
	            		if (currentDirectory.equals("")) {
	            			currentDirectory = parsed[i];
	            		}
	            		else if(currentDirectory.equals("/")) {
	            			currentDirectory = currentDirectory + parsed[i];
	            		}
	            		else {
	            			// find directoryname
	            			currentDirectory = currentDirectory + "/" + parsed[i];
	            		}
	            		
	            		// check if directory already exists in list
	            		if (!directories.contains(currentDirectory)) {
	            			directories.add(currentDirectory);
	            			directory.add(new Directory(currentDirectory));
	            		}
	            		System.out.println("\nCurrent Directory: " + currentDirectory);
	            	}
	            	if (parsed[i].equals("ls")) {
	            		command = parsed[i];
	            		continue;
	            	}
	            	
	            	// continue scanning all files/folders in directory
	            	if (command.equals("ls")) {
	            		
	            		// store all files/subDirectories into currentDirectory
	            		
	            		if (parsed[i].equals("dir")) {
	            			// save dir to a list
	            			// create dir object which can contain list of directories?
	            			i++;
	            			if (currentDirectory.equals("/")) {
	            				System.out.print(parsed[i] + "\n");
	            				directories.add(currentDirectory + parsed[i]);
	            				directory.add(new Directory(currentDirectory + parsed[i]));
	            				for (int j = 0; j < directory.size(); j++) { // put sub directory in correct parent
	            					if (directory.get(j).getDirectoryName().equals(currentDirectory)) {
	            						directory.get(j).addDirectory(currentDirectory + parsed[i]);
	            					}
	            				}
		            			continue;
	            			}
	            			else if (!directories.contains(currentDirectory)) {
	            				directories.add(currentDirectory + "/" + parsed[i]);
	            				directory.add(new Directory((currentDirectory + "/" + parsed[i])));
	            				System.out.print(parsed[i] + "\n");
	            			}
	            			else {
	            				System.out.print(parsed[i] + "\n");
	            				for (int j = 0; j < directory.size(); j++) { // put sub directory in correct parent
	            					if (directory.get(j).getDirectoryName().equals(currentDirectory)) {
	            						directory.get(j).addDirectory(currentDirectory + "/"+ parsed[i]);
	            					}
	            				}
	            			}
	            		}
	            		else { // is a file
	            			i++;
	            			System.out.print(parsed[i] + "\n");
	            			for (int j = 0; j < directory.size(); j++) { // put sub directory in correct parent
            					if (directory.get(j).getDirectoryName().equals(currentDirectory)) {
            						// string, int
            						//file.add(new AOCFile(parsed[i], Integer.parseInt(String.valueOf(parsed[i-1]))));
            						directory.get(j).addFile(new AOCFile(parsed[i], Integer.parseInt(String.valueOf(parsed[i-1]))));
            						//directory.get(j).addFile(parsed[i], Integer.parseInt(String.valueOf(parsed[i-1])));
            					}
            				}
	            		}
	            	}
	            }     
			}
			// outside for loop

			// quick listing of all directories and files
			// need to loop from child and go to parent

            System.out.println("");
            System.out.println("");
            System.out.println("");
            
            
            // attempt negative
            for (int i = directory.size()-1; i >= 0; i--) {
            	System.out.println("Directory: " + directory.get(i).getDirectoryName());
            	
            	totalSize = 0;
            	
            	//iterate thru files and determine if less than 100k
            	for (int j = 0; j < directory.get(i).file.size(); j++) {
            		
            		System.out.println("\tFile: <" + directory.get(i).getFileName(j) + "> size: " + directory.get(i).getFile(j).getFileSize());
            		totalSize += directory.get(i).getFile(j).getFileSize();
            	}
            	
            	for (int k = directory.get(i).directories.size()-1; k >= 0; k--) {
            		//System.out.println("\tSubdirectory <" +  directory.get(i).directories.get(k) + "> size: " + directory.get(i).sizeOfDirectory);
            		subDirectory = directory.get(i).directories.get(k);
            		
            		for (int l = 0; l < directory.size(); l++) {
            			if (directory.get(l).getDirectoryName().equals(subDirectory)) { // if subdirectory is in parent directory, add directory size
            				
            				totalSize += directory.get(l).sizeOfDirectory;
                    		System.out.println("\tSubdirectory <" +  directory.get(i).directories.get(k) + "> size: " + directory.get(l).sizeOfDirectory);
            			}
            		}
            	}
            	
            	// if has subdirectory, add files from subdirectory into parent directory total
            	System.out.println(directory.get(i).getDirectoryName() + " size: " + totalSize + "\n");
            	directory.get(i).sizeOfDirectory = totalSize;
            	// if file size is less than 100,000, isTrue
        		if (totalSize <= 100000) {
        			directory.get(i).isUnder = true;
        		}
            }
            totalSize = 0;
            
            // new loop to determine which directories have files < 100,000
            for (int i = 0; i < directory.size(); i++) {
            	if (directory.get(i).isUnder) {
            		System.out.println(directory.get(i).getDirectoryName() + " is under with size of " + directory.get(i).sizeOfDirectory);
            		totalSize += directory.get(i).sizeOfDirectory;
            	}
            }
            
            // 1924220 is too high
            // 1449447 correct answer
            // 1377997 is too low
            
            System.out.println("total size of files under 100k is: " + totalSize);
            
			System.out.println("Done with program");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SecurityException e) {  
	        e.printStackTrace();  
	    }		
	}
}
