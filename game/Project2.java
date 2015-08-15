package game;

import java.io.*;
import java.util.Scanner;

public class Project2 {

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

		//prompt user to pick their piece
		System.out.println("Do you want to play with X or O? ");

		//user's choice of character
		Scanner scan = new Scanner(System.in);		
		userChar = scan.next();

		//validate the user's choice input
		while(userChar != "")
		{
			if(userChar.equalsIgnoreCase("X"))
			{
				playingChar = "X";
				computerChar = "O";
			}
			else if(userChar.equalsIgnoreCase("O"))
			{
				playingChar = "O";
				computerChar = "X";
			}
			else
			{
				// attempt to read letter again
				System.out.println("You can only choose X or O... what's it gonna be?!");
				userChar = scan.next();
			}
		}

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
