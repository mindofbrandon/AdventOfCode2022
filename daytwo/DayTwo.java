package com.example.daytwo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DayTwo {

	public static void main(String[] args) {
		/*
		 * First column is opponent: A for Rock, B for Paper, and C for Scissors
		 * Second column is you: X for Rock, Y for Paper, and Z for Scissors
		 * The score for a single round is the score for the shape you selected
		 * (1 for Rock, 2 for Paper, and 3 for Scissors)
		 * plus the score for the outcome of the round
		 * (0 if you lost, 3 if the round was a draw, and 6 if you won).
		 */

		File inputPath = new File("%directory%");
		
		// create two hashmaps that correspond with opponent and your selection
		// string is A, B, C OR X, Y, Z
		// integer is the amount of points received from selection
		// outcome (0 if you lost, 3 if the round was a draw, and 6 if you won).
		HashMap<String, Integer> opponent = new HashMap<String, Integer>();
		HashMap<String, Integer> you = new HashMap<String, Integer>();
		HashMap<String, String> move = new HashMap<String, String>();
		move.put("A", "rock");
		move.put("X", "rock");
		move.put("B", "paper");
		move.put("Y", "paper");
		move.put("C", "scissors");
		move.put("Z", "scissors");
		you.put("rock", 1);
		you.put("paper", 2);
		you.put("scissors", 3);
		
		int points = 0;
		int total = 0;
		
		String opponentMove = null;
		String yourMove = null;
		
		try {
			Scanner scanner = new Scanner(inputPath);
			while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parsed = line.split(" ");

                // after string is parsed, perform the "battle"
                // opponent is A
                // you is X
                /*
                 * A beats Z
                 * B beats X
                 * C beats Y
                 * 
                 * X beats C
                 * Y beats A
                 * Z beats B
                 * 
                 * A ties X
                 * B ties Y
                 * C ties Z
                 * 
                 */
                
                
                // map moves to strings
                for (Map.Entry<String, String> entry : move.entrySet()) {
                	String key = entry.getKey();
                	String value = entry.getValue();
                	
                	
                	// cannot use if key == parsed[0] because == compares instances in java, not value
                	if (key.equals(parsed[0])) {
                		opponentMove = key;
                		System.out.println("Opponent Move is " + opponentMove);
                		opponentMove = move.getOrDefault(key, value);
                		break;
                	}
                }
                
                for (Map.Entry<String, String> entry : move.entrySet()) {
                	String key = entry.getKey();
                	String value = entry.getValue();
                	
                	if (key.equals(parsed[1])) {
                		yourMove = key;
                		System.out.println("Your move is " + yourMove);
                		yourMove = move.getOrDefault(key, value);
                		break;
                	}
                }
                
                if (((opponentMove.equals("rock")) && (yourMove.equals("rock"))) || ((opponentMove.equals("paper")) && (yourMove.equals("paper"))) || ((opponentMove.equals("scissors"))) && (yourMove.equals("scissors"))) {
                	
                	// tie
                	// points = your move + tie (3)
                	points = 3 + you.get(yourMove);
                	System.out.println("Its a Tie! Score is " );
                	total += points;
                } 
                
                else if ((opponentMove.equals("rock")) && (yourMove.equals("scissors")) || ((opponentMove.equals("paper")) && (yourMove.equals("rock"))) || ((opponentMove.equals("scissors"))) && (yourMove.equals("paper"))) {
                	// opponent wins
                	points = 0 + you.get(yourMove);
                	System.out.println("You lost! Score is " );
                	total += points;
                }
                
                else if ((yourMove.equals("rock")) && (opponentMove.equals("scissors")) || ((yourMove.equals("paper")) && (opponentMove.equals("rock"))) || ((yourMove.equals("scissors"))) && (opponentMove.equals("paper"))) {
                	// opponent loses aka you win
                	points = 6 + you.get(yourMove);
                	System.out.println("You won! Score is " );
                	total += points;
                }                
            }
			
			System.out.println("Done");
			System.out.println("Total points earned: " + total);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
