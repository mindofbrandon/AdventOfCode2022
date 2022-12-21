package com.example.dayfive;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DayFive {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Path inputPath = Paths.get("%directory%");

		List<Stack<Character>> listOfStacks = new ArrayList<Stack<Character>>();
		List<String> listOfStrings = new ArrayList<String>();
		List<String> numbers = new ArrayList<String>();
		List<Integer> instructions = new ArrayList<Integer>();
		List<Character> temp = new ArrayList<Character>();
		String amount = "";
		int k = 0;
		
		// TODO: pretty print row of stacks 
		try {
			BufferedReader reader = Files.newBufferedReader(inputPath);
			String line;
			while (reader.ready()) {
				line = reader.readLine();
				listOfStrings.add(line);
			}
			numbers.add(listOfStrings.get(8));


			// TODO: put this in a loop
			listOfStacks.add(new Stack<Character>());
			listOfStacks.add(new Stack<Character>());
			listOfStacks.add(new Stack<Character>());
			listOfStacks.add(new Stack<Character>());
			listOfStacks.add(new Stack<Character>());
			listOfStacks.add(new Stack<Character>());
			listOfStacks.add(new Stack<Character>());
			listOfStacks.add(new Stack<Character>());
			listOfStacks.add(new Stack<Character>());
			
			// for length of stringlist
			for (int i = 7; i >= 0; i--) {
				
				k = 0;
				// create a stack each iteration
				
				// get first stack column
				
				// for each character in one line on stringlist
				for (int j = 0; j < numbers.get(0).length(); j++) {
					
					if (j % 4 == 1) {
						
						// java pass by reference/pass by value is NOT the same as C++... noted.
						// another for loop to push whole column
						// get char at line i, column j
						if (listOfStrings.get(i).charAt(j) != ' ')
							listOfStacks.get(k).push(listOfStrings.get(i).charAt(j));
						
						k += 1;
					}
				}
			}
			
			System.out.println("done putting characters in each stack");
			System.out.println(listOfStacks);
			
			// do the movements of boxes
			// Integer.parseInt
			for (int i = 10; i < listOfStrings.size(); i++) {
				amount = "";
				instructions.clear();
				if (listOfStrings.get(i).length() == 18) {
					for (int j = 0; j < 18; j++) {
						if (j == 5 || j == 12 || j == 17) {
							instructions.add(Integer.parseInt(String.valueOf(listOfStrings.get(i).charAt(j)))); 
						}
					}
					// do movements
					//System.out.println("done with instr");
					// move 1 crate from coluumn 7 (6) to column 4(3)
					// new list should be : Z, S, N, R, L, T, C,
					// and: T, J, G, W, V, Q, L, W
					
					// popping crates
					for (int j = 0; j < instructions.get(0); j++) {
						//temp.add(j, listOfStacks.get(instructions.get(1)-1).pop()); 
						listOfStacks.get(instructions.get(2)-1).push(listOfStacks.get(instructions.get(1)-1).pop());
					}					
				}
				
				else if (listOfStrings.get(i).length() == 19) {
					for (int j = 0; j < 19; j++) {
						if (j == 5) {
							amount += listOfStrings.get(i).charAt(j);
						}
						if (j == 6) {
							amount += listOfStrings.get(i).charAt(j);
							instructions.add(Integer.parseInt(String.valueOf(amount)));
						}
						
						if (j == 13 || j == 18) {
							instructions.add(Integer.parseInt(String.valueOf(listOfStrings.get(i).charAt(j)))); 
						}
					}
					// do movements
					//System.out.println("done with instr");
					// popping crates
					for (int j = 0; j < instructions.get(0); j++) {
						// pro gamer move
						listOfStacks.get(instructions.get(2)-1).push(listOfStacks.get(instructions.get(1)-1).pop());
					}
				}
			}
			
			System.out.println(listOfStacks);
			
			for (int i = 0; i < listOfStacks.size(); i++)
				System.out.println(listOfStacks.get(i).peek());
			
			// NTWZZWHFV
			
			System.out.println("done");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
