package com.example.dayone;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DayOne {

	public static void main(String[] args) {
		Path inputPath = Paths.get("%path/added/here%");
		List<Integer> list = new ArrayList<>();
		int max = 0;
		int newVal = 0;
		int initialVal = 0;
		try {
			BufferedReader reader = Files.newBufferedReader(inputPath);
			String line = reader.readLine();
			
			while (line != null) {
				if (line.isEmpty()) {
					System.out.println("empty line");
					
					// for list of values in list, sum together and save to initialVal
					for(int listVal : list)
						initialVal += listVal;
					
					// set previous val to initial val
					// new val set as 0 when program starts
					newVal = initialVal;
					
					// if new sum of vals from list is greater than current max, max val is now newVal
					if (newVal > max) {
						max = newVal;
					}
					
					list.clear();
					initialVal = 0;
				}
				else {
					System.out.println(line);
					list.add(Integer.valueOf(line));
				}
				// read next line
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		System.out.println("Elf who needs more calories is: ");
		// desired val is 68442
		System.out.println(max);
	}
}
