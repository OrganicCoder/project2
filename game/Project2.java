package game;

import java.io.*;
import java.util.Scanner;

public class Project2 
{
	private static Scanner scan = new Scanner(System.in); //Scanner to be used in any method
	
	public static void main(String[] args) 
	{
		char letter; //used for box input
		String userChar, playingChar, computerChar, charPosition;

		char[][] table = new char[][]{
			{'?', '?', '?'},
			{'?', '?', '?'},
			{'?', '?', '?'}
		};

		//display table
		displayTable(table);

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
				playingChar = "X";
				computerChar = "O";
				
				chooseMove(playingChar);
				charPosition = scan.next();
			}
			else if(userChar.equalsIgnoreCase("O"))
			{
				playingChar = "O";
				computerChar = "X";
				
				chooseMove(playingChar);
				charPosition = scan.next();
			}
			else
			{
				System.out.println("You have entered an invalid letter. Please select either X or O: ");
			}
					
		} while(!(userChar.equalsIgnoreCase("X") || userChar.equalsIgnoreCase("O")));

	}
	
	public static void chooseMove(String charChoice)
	{
		System.out.println("\nWhere would you like to place your " + charChoice + "?");
		System.out.println("(choose position from the table displayed below. Example: A1) \n");
		displayInitialTable();	
		System.out.println("Position: ");
	}
	
	public static void displayInitialTable()
	{
		//sample table. (Update: include letter in table)  --> Alex displayTable(char box[][])!
		String row1 = "     1     2     3   \n";
		String row2 = "A |     |     |     |\n";
		String row3 = "B |     |     |     |\n";
		String row4 = "C |     |     |     |\n";
		String rowB = "  ------------------- \n";
		
		String table = row1 + rowB + row2 + rowB + row3 + rowB + row4 + rowB;
		
		//sample table display. 
		System.out.println(table);
	}

	//IN PROGRESS
	//checks if space is available
	public static boolean isSpaceAvailable()
	{
		return false;
	}

	//display formatted table
	public static void displayTable(char box[][])
	{
		System.out.println("  1 2 3");
		System.out.println( "A " + box[0][0] + "|" + box[0][1] + "|" + box[0][2]);
		System.out.println( "-------");
		System.out.println( "B " + box[1][0] + "|" + box[1][1] + "|" + box[1][2]);
		System.out.println( "-------");
		System.out.println( "C " + box[2][0] + "|" + box[2][1] + "|" + box[2][2]);
	}
}
