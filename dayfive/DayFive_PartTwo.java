package com.example.dayfive;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DayFive_PartTwo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// need to change stack data type to something else
		
		// perhaps now is time to make 2d array/list?
		
				Path inputPath = Paths.get("%directory%");

				List<Stack<Character>> listOfStacks = new ArrayList<Stack<Character>>();
				Stack<Character> tempStack = new Stack<Character>();
				List<String> listOfStrings = new ArrayList<String>();
				List<String> numbers = new ArrayList<String>();
				List<Integer> instructions = new ArrayList<Integer>();
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
							System.out.println("do movements with instr" + instructions);
							// move 5 crates from column 9 (6) to column 4(3)
							
							
							/* [[B, Z, T], 
							 * [V, H, T, D, N, S], 
							 * [B, F, M, D], 
							 * [T, J, G, W, V, Q, L, W], 4
							 * [W, D, G, P, V, F, Q, M], 
							 * [V, Z, Q, G, H, F], 
							 * [Z, S, N, R, L, T, C], 
							 * [Z, H, W, D, J, N, R, M], 
							 * [M, Q, L, F, D, S]] 9 
							 * 
							 * new list should be 
							 * [B, Z, T], 
							 * [V, H, T, D, N, S], 
							 * [B, F, M, D], 
							 * [T, J, G, W, V, Q, L, W, Q, L, F, D, S] -----------
							 * [W, D, G, P, V, F, Q, M], 
							 * [V, Z, Q, G, H, F], 
							 * [Z, S, N, R, L, T, C], 
							 * [Z, H, W, D, J, N, R, M], 
							 * [M] ------------------------------------------------
							
							
							*/
							// new list should be : Z, S, N, R, L, T, C,
							// and: T, J, G, W, V, Q, L, W
							
							// popping crates
							// changes for part 2 should be here
							System.out.println(listOfStacks);
							
							for (int j = 0; j < instructions.get(0); j++) {
								//temp.add(j, listOfStacks.get(instructions.get(1)-1).pop());
								
								int crate1 = instructions.get(1)-1;
								int crate2 = instructions.get(2)-1;
								//System.out.println(instructions.get(1)-1); // get instruction - 1 (column is 0 indexed)
								System.out.println("list of stacks before movement" + listOfStacks);
								// tempStack.push(
								
								
							//tempStack.push(listOfStacks.get(crate2).push(listOfStacks.get(crate1).pop())); // get instruction and pop?
							tempStack.push(listOfStacks.get(crate1).pop()); // get 

							}
							System.out.println("done with instr" + instructions);
							//System.out.println(listOfStacks);
							System.out.println(tempStack);
							
							for (int j = 0; j < instructions.get(0); j++) {
								int crate1 = instructions.get(1)-1;
								int crate2 = instructions.get(2)-1;
								listOfStacks.get(crate2).push(tempStack.pop());
							}
							
							System.out.println("After tempStack pushed into list: " + listOfStacks);
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
							System.out.println("do movement with inst: " + instructions);
							// popping crates
							for (int j = 0; j < instructions.get(0); j++) {
								// pro gamer move
								// pop all of them
								// then push all of them
								tempStack.push(listOfStacks.get(instructions.get(1)-1).pop());
							}
							for (int j = 0; j < instructions.get(0); j++) {
								// pro gamer move
								// pop all of them
								// then push all of them

								listOfStacks.get(instructions.get(2)-1).push((tempStack.pop()));
							}
							System.out.println(listOfStacks);
						}
					}
					
					System.out.println(listOfStacks);
					
					
					for (int i = 0; i < listOfStacks.size(); i++)
						System.out.print(listOfStacks.get(i).peek());
					
					// BRZGFVBTJ	
					System.out.println("\ndone");
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

}
