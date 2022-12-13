package com.example.daythree;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class DayThree {

	public static void main(String[] args) {

		File inputPath = new File("%directory%");
		HashMap<Character, Integer> charValue= new HashMap<Character, Integer>();
		int j = 1;
		String firstHalf = null;
		String secondHalf = null;
		char saveChar = '0';
		int total = 0;
		
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

		// create map with priority values
		for (int i = 0; i < alphabet.length(); i++) {
			charValue.put(alphabet.charAt(i), j);
			j += 1;
		}
		
		try {
			Scanner scanner = new Scanner(inputPath);
			while (scanner.hasNextLine()) {
                String line = scanner.nextLine();       
                firstHalf = line.substring(0, line.length()/2);
                secondHalf = line.substring(line.length()/2);
                System.out.println("first string: " + firstHalf);
                System.out.println("second string: " + secondHalf);
                
                // check all chars in secondHalf with chars in firstHalf
        		for (int x = 0; x < firstHalf.length(); x++) {
        			for (int y = 0; y < secondHalf.length(); y++) {
            			if (secondHalf.charAt(y) == firstHalf.charAt(x)) {
            				saveChar = secondHalf.charAt(y);
            			}
        			}
        		}
        		System.out.println("found repeating character: " + saveChar);
				total += charValue.get(saveChar);
				System.out.println("value: " + charValue.get(saveChar) + "\nnew total: " + total);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
