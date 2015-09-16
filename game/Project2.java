package game;

import java.io.*;
import java.util.Scanner;

public class Project2 
{
	private static Scanner scan = new Scanner(System.in); //Scanner to be used in any method
	
	private static char[][] table = new char[][]{
		{'?', '?', '?'},
		{'?', '?', '?'},
		{'?', '?', '?'}
	};
	
	public static void main(String[] args) 
	{
		char letter; //used for table input
		String userChar, computerChar, charPosition;
		boolean available;
		boolean winner = false;
		boolean tie = false;
		int turns = 0; //counter
		
		
		//display table
		//displayTable(table);

		//Welcome message
		System.out.println("\nWelcome to the classic game of Tic Tac Toe\n");

		//prompt user to pick their piece
		System.out.println("Do you want to play with X or O? ");

		//validate the user's choice input
		do
		{
			//user's choice of character
			userChar = scan.next();
				
			if(userChar.equalsIgnoreCase("X"))
			{
				computerChar = "O";
			}
			else if(userChar.equalsIgnoreCase("O"))
			{
				computerChar = "X";
			}
			else
			{
				System.out.println("You have entered an invalid letter. Please select either X or O: ");
			}
					
		} while(!(userChar.equalsIgnoreCase("X") || userChar.equalsIgnoreCase("O")));
		
		do{
			// choose position
			do
			{
				chooseMovePrompt(userChar);
				displayInitialTable();
				System.out.println("Position: ");
				charPosition = scan.next();
				available = isSpaceAvailable(charPosition, userChar.charAt(0));
				
				// tell user the space is taken
				if(!available)
				{
					System.out.println("Space is taken. Try a different position.");
				}
				
				//System.out.println("\nNow it's the computer's move\n");
				
			} while(!(charPosition.equalsIgnoreCase("a1") || charPosition.equalsIgnoreCase("a2") || charPosition.equalsIgnoreCase("a3") ||
					charPosition.equalsIgnoreCase("b1") || charPosition.equalsIgnoreCase("b2") || charPosition.equalsIgnoreCase("b3") ||
					charPosition.equalsIgnoreCase("c1") || charPosition.equalsIgnoreCase("c2") || charPosition.equalsIgnoreCase("c3")) || !available);
			
			System.out.println("\nNow it's the computer's move\n");
			
			//computer's move
			
			displayTable();
			
		} while(!winner && !tie);
	} //main
	
	public static void computerMove(char compChoice)
	{
		// get list of available spaces
		
		
		// pick and assign one from the list, randomly
		
	}
	
	public static void chooseMovePrompt(String charChoice)
	{
		System.out.println("\nWhere would you like to place your " + charChoice + "?");
		System.out.println("(choose position from the table displayed below. Example: A1) \n");
	}
	
	public static void displayInitialTable()
	{
		//sample table. (Update: include letter in table)  --> Alex displayTable(char table[][])!
		String row1 = "     1     2     3   \n";
		String row2 = "A |     |     |     |\n";
		String row3 = "B |     |     |     |\n";
		String row4 = "C |     |     |     |\n";
		String rowB = "  ------------------- \n";
		
		String table = row1 + rowB + row2 + rowB + row3 + rowB + row4 + rowB;
		
		//sample table display. 
		System.out.println(table);
	}

	//checks if space is available
	public static boolean isSpaceAvailable(String choice, char piece)
	{
		// capitalize choice
		choice = choice.toUpperCase();
		
		switch(choice)
		{
		case "A1":
			if(table[0][0] == '?')
			{
				table[0][0] = piece;
				return true;
			}
			else
				return false;
			
		case "A2":
			if(table[0][1] == '?')
			{
				table[0][1] = piece;
				return true;
			}
			else
				return false;
			
		case "A3":
			if(table[0][2] == '?')
			{
				table[0][2] = piece;
				return true;
			}
			else
				return false;
			
		case "B1":
			if(table[1][0] == '?')
			{
				table[1][0] = piece;
				return true;
			}
			else
				return false;
			
		case "B2":
			if(table[1][1] == '?')
			{
				table[1][1] = piece;
				return true;
			}
			else
				return false;
			
		case "B3":
			if(table[1][2] == '?')
			{
				table[1][2] = piece;
				return true;
			}
			else
				return false;
			
		case "C1":
			if(table[2][0] == '?')
			{
				table[2][0] = piece;
				return true;
			}
			else
				return false;
			
		case "C2":
			if(table[2][1] == '?')
			{
				table[2][1] = piece;
				return true;
			}
			else
				return false;
			
		case "C3":
			if(table[2][2] == '?')
			{
				table[2][2] = piece;
				return true;
			}
			else
				return false;
		default:
			//
		}
		
		return false;
	}

	//display formatted table
	public static void displayTable()
	{
		System.out.println("  1 2 3");
		System.out.println( "A " + table[0][0] + "|" + table[0][1] + "|" + table[0][2]);
		System.out.println( "-------");
		System.out.println( "B " + table[1][0] + "|" + table[1][1] + "|" + table[1][2]);
		System.out.println( "-------");
		System.out.println( "C " + table[2][0] + "|" + table[2][1] + "|" + table[2][2]);
	}
}
