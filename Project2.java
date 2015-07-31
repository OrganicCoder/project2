package game;

import java.io.*;
import java.util.Scanner;

public class Project2 {

	public static void main(String[] args) 
	{
		char letter; // used for box input
		String userChar, playingChar, computerChar;
		char box1, box2, box3, box4, box5, box6, box7, box8, box9;
		String charPosition; 
	
		//sample table. (Update: include letter in table)
		String row1 = "    1   2   3  \n";
		String row2 = "A |   |   |   |\n";
		String row3 = "B |   |   |   |\n";
		String row4 = "C |   |   |   |\n";
		String rowB = "  -------------\n";
		
		//sample table display. 
		System.out.println(row1 + rowB + row2 + rowB + row3 + rowB + row4 + rowB);
		
		System.out.println("Do you want to play with X or O? ");
	
		Scanner scan = new Scanner(System.in);
		
		//user's choice of character
		userChar = scan.next();
		
		while(userChar != "")
		{
			if(userChar.equalsIgnoreCase("X"))
			{
				playingChar = "O";
				computerChar = "X";
			}
			else if(userChar.equalsIgnoreCase("O"))
			{
				playingChar = "X";
				computerChar = "O";
			}
			else
			{
				//Letter attempt #2
				System.out.println("You can only choose X or O... what's it gonna be?!");
				userChar = scan.next();
			}
		}
			
		

	}

}
