package com.example.dayfour;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayFour {

	public static void main(String[] args) {

		File inputPath = new File("%directory%");

		int total = 0;
		
		try {
			Scanner scanner = new Scanner(inputPath);
			while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            String[] parsed = line.split(",");
	            System.out.println("first elf: " + parsed[0]);
	            System.out.println("second elf: " + parsed[1]);
	            String[] firstElf = parsed[0].split("-"); 
	            String[] secondElf = parsed[1].split("-");
	    		List firstRange = new ArrayList<>();
	    		List secondRange = new ArrayList<>();
	            
	            // if substring is in full string, then one range fully covers the other
	            
	            // create first range
	            for (int i = Integer.parseInt(firstElf[0]); i <= Integer.parseInt(firstElf[1]); i++) {
	            	firstRange.add(i);
	            }
	            System.out.println("created first range: " + firstRange);
	            // create second range
	            for (int i = Integer.parseInt(secondElf[0]); i <= Integer.parseInt(secondElf[1]); i++) {
	            	secondRange.add(i);
	            }
	            System.out.println("created second range: " + secondRange);
	            
	            // if first range smaller than second range, check for all numbers in first range with second range
	            if (firstRange.size() < secondRange.size()) {
	            	System.out.println("first range smaller than second range");
	            	done:
	            	for(int i = 0; i < secondRange.size(); i++) {
	            		for (int j = 0; j < firstRange.size(); j++) {
	            			if (secondRange.containsAll(firstRange)) {
	            				System.out.println("first range contains all second range");
	            				total += 1;
	            				// this might not be best practice? not very familiar with java best practices
	            				break done;
	            			}
	            		}
	            	}
	            } else if (firstRange.size() > secondRange.size()) {
	            	System.out.println("second range smaller than first range");
	            	done:
	            	for(int i = 0; i < firstRange.size(); i++) {
	            		for (int j = 0; j < secondRange.size(); j++) {
	            			if (firstRange.containsAll(secondRange)) {
	            				System.out.println("second range contains all first range");
	            				total += 1;
	            				break done;
	            			}
	            		}
	            	}
	            } else {
	            	System.out.println("same size ranges");
	            	done:
	            	for(int i = 0; i < firstRange.size(); i++) {
	            		for (int j = 0; j < secondRange.size(); j++) {
	            			if (firstRange.containsAll(secondRange)) {
	            				System.out.println("first range contains all second range");
	            				total += 1;
	            				break done;
	            			}
	            		}
	            	}
	            }
	            System.out.println("Done with program - total dupes: " + total);     
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
