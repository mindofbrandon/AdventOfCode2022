package com.example.daysix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DaySix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File inputPath = new File("%directory%");
		String line = "";
		List<Character> marker = new LinkedList<>();
		int j = 0;
		try {
			Scanner scanner = new Scanner(inputPath);
			while (scanner.hasNextLine()) {
	            line = scanner.nextLine();
			}
			
			// read through char by char
			for (int i = 0; i < line.length(); i++) {
				
				// if j is divisible by 4, reset marker count?
				if (j == 0) {
					marker.add(line.charAt(i));
					j++;
					continue;
				}
				else if (marker.size() == 4) {
					
					// save last 4 characters and determine if they are all unique
					if (
							marker.get(0) == marker.get(1) ||
							marker.get(0) == marker.get(2) ||
							marker.get(0) == marker.get(3) ||
							marker.get(1) == marker.get(2) ||
							marker.get(1) == marker.get(3) ||
							marker.get(2) == marker.get(3)					

							) 
					{}
					else {
						// char 1760
						System.out.println("index " + i + " is the length and string is " + marker);
						System.exit(0);
					}
					marker.remove(0);

					j = 0;
				}
				
				if (marker.size() != 4) {
					marker.add(line.charAt(i));
					j++;
				}
				else {
					marker.add(line.charAt(i));
					j++;
					marker.remove(0);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
