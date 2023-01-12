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
		int x = 0;
		int flag = 0;
		try {
			Scanner scanner = new Scanner(inputPath);
			while (scanner.hasNextLine()) {
	            line = scanner.nextLine();
			}
			
			// read through char by char
			for (int i = 0; i < line.length(); i++) {
				flag = 0;
				// if j is divisible by 4, reset marker count?
				if (x == 0) {
					marker.add(line.charAt(i));
					x++;
					continue;
				}
				else if (marker.size() == 4) {
					
					// save last 4 characters and determine if they are all unique
					// nested for loop to check all characters one by one
					for (int j = 0; j < marker.size(); j++) {
						
						if (flag == 1)
							break;
							
						System.out.println("current string: " + marker);
						System.out.println("testing char <" + marker.get(j) + "> against all other chars");
						
						for (int k = 0; k < marker.size(); k++) {
							
							//System.out.println("testing char <" + marker.get(j) + "> with char [" + marker.get(k) + "]");
							if (marker.get(j) == marker.get(k) && (j != k)) {
								flag = 1;
								System.out.println(marker + " is not a unique string");
								break;
							}
						}
					}
					if (flag == 0) {
						// char 1760
						System.out.println("index " + i + " is the length and string is " + marker);
						System.exit(0);
					}
					marker.remove(0);
					x = 0;
				}
				
				if (marker.size() != 4) {
					marker.add(line.charAt(i));
					x++;
				}
				else {
					marker.add(line.charAt(i));
					x++;
					marker.remove(0);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
