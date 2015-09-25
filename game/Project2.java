package game;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Project2 
{
	private static Scanner scan = new Scanner(System.in); //Scanner to be used in any method
	
	private static Random random = new Random();
	
	private static char[][] table = new char[][]{
		{'?', '?', '?'},
		{'?', '?', '?'},
		{'?', '?', '?'}
	};
	
	public static void main(String[] args) 
	{
		char userChar = ' ';
		char computerChar = ' ';
		char playAgain = ' ';
		String charPosition = "";
		boolean positionAvailable = false;
		boolean winner = false;
		boolean tie = false;
		int gameMode = 0;
		int turnCounter = 0;
		
		//Welcome message
		System.out.println("\nWelcome to the classic game of Tic Tac Toe");
		
		// start the game loop
		do{
		
			//reset all variables
			userChar = ' ';
			computerChar = ' ';
			playAgain = ' ';
			charPosition = "";
			positionAvailable = false;
			winner = false;
			tie = false;
			turnCounter = 0;
			table = new char[][]{
				{'?', '?', '?'},
				{'?', '?', '?'},
				{'?', '?', '?'}
			};
			
			//prompt user to choose game mode
			System.out.println("Choose game mode (either 1 or 2):\n 1. Player vs. Player \n 2. Player vs. Computer\n");
			gameMode = scan.nextInt();
		/*	
			if(modeChoice == 1)
			{
				//go to pvp mode
			}
			else if(modeChoice == 2)
			{
				//go to comp mode
			}
			else
			{
				System.out.println("Please choose a valid game mode: ");
			}
		*/
			//prompt user to pick their piece
			System.out.println("\nDo you want to play with X or O? ");
	
			//validate the user's choice input
			String playerChoices = playerPick();
			
			//player character is first char of playerChoices string. computer character is second char.
			userChar = playerChoices.charAt(0);
			computerChar = playerChoices.charAt(1);
			
			//game loop
			do{
				//choose a valid position
				choosePosition(userChar, charPosition, positionAvailable);
				
				turnCounter++;
				
				char winningPlayer = ' ';
				winningPlayer = checkWinner();
	
				//check if player has won
				if(winningPlayer == 'o' || winningPlayer == 'x' ||
				   winningPlayer == 'O' || winningPlayer == 'X')
				{
					winner = true;
					System.out.println("Player " + winningPlayer + " won!");
				}
				
				//if no winner, allow computer to move
				if(!winner && turnCounter < 9)
				{
					System.out.println("\nNow it's the computer's move\n");
					
					//sleep method for computer's move to simulate thinking
					try 
					{
						int time = random.nextInt(3) + 2; //chooses random time between 2-5 seconds
					    TimeUnit.SECONDS.sleep(time); //pauses for that amount of time
					} 
					catch (InterruptedException e) 
					{
					    //Handle exception
						System.out.println("The computer's brain shut off :(");
					}
					
					//computer's move
					computerMove(computerChar);
					
					displayTable();
					
					turnCounter++;
					
					winningPlayer = checkWinner();
					
					//check if computer has won
					if(winningPlayer == 'o' || winningPlayer == 'x' ||
					   winningPlayer == 'O' || winningPlayer == 'X')
					{
						winner = true;
						System.out.println("Player " + winningPlayer + " won!");
					}
					
				}
				
				//check for tie condition
				else if(!winner && turnCounter == 9)
				{
					System.out.println("It's a TIE!");
					tie = true;
				}
				
			  //while game is still playable
			} while(!winner && !tie && turnCounter <=9);
			
			System.out.println("\nGame Over!\n\nPlay Again? (Y/N)");
			playAgain = (scan.next()).charAt(0);
			
		} while(playAgain == 'y' || playAgain == 'Y');
		
		System.out.println("\nThanks for playing!");
	} //end of main
	
	public static String playerPick()
	{
		String choices = "";
		String userChar = "";
		String computerChar = "";
		
		do
		{
			//user's choice of character
			userChar = scan.next();
				
			if(userChar.equalsIgnoreCase("X"))
			{
				computerChar = "O";
				choices = userChar + computerChar;
				 
			}
			else if(userChar.equalsIgnoreCase("O"))
			{
				computerChar = "X";
				choices = userChar + computerChar;
			}
			else //invalid input
			{
				System.out.println("\nYou have entered an invalid letter. Please select either X or O: ");
			}
					
		} while(!(userChar.equalsIgnoreCase("X") || userChar.equalsIgnoreCase("O")));
		
		return choices;
	}
	
	public static void chooseMovePrompt(char charChoice)
	{
		System.out.println("\nWhere would you like to place your " + charChoice + "?");
		System.out.println("(choose position from the table displayed below. Example: A1)\n");
	}
	
	public static void choosePosition(char userChar, String charPosition, boolean available)
	{
		do
		{
			chooseMovePrompt(userChar);
			displayTable();
			
			System.out.println("Position: ");
			charPosition = scan.next();
			System.out.println();
			
			available = isSpaceAvailable(charPosition, userChar);
			
			//check user entered valid position
			if(!(charPosition.equalsIgnoreCase("a1") || charPosition.equalsIgnoreCase("a2") || charPosition.equalsIgnoreCase("a3") ||
				charPosition.equalsIgnoreCase("b1") || charPosition.equalsIgnoreCase("b2") || charPosition.equalsIgnoreCase("b3") ||
				charPosition.equalsIgnoreCase("c1") || charPosition.equalsIgnoreCase("c2") || charPosition.equalsIgnoreCase("c3")))
			{
				System.out.println("\nThat is not a valid position, please select again.");
			}
			else
			{	
				// tell user the space is taken
				if(!available)
				{
					System.out.println("\nSpace is taken. Try a different position.");
				}
			}
			
			displayTable();
			
		} while(!(charPosition.equalsIgnoreCase("a1") || charPosition.equalsIgnoreCase("a2") || charPosition.equalsIgnoreCase("a3") ||
				charPosition.equalsIgnoreCase("b1") || charPosition.equalsIgnoreCase("b2") || charPosition.equalsIgnoreCase("b3") ||
				charPosition.equalsIgnoreCase("c1") || charPosition.equalsIgnoreCase("c2") || charPosition.equalsIgnoreCase("c3")) || !available);
	}

	public static boolean isSpaceAvailable(String position, char piece)
	{
		// capitalize choice
		position = position.toUpperCase();
		String pi = piece + "";
		pi = pi.toUpperCase();
		piece = pi.charAt(0);
		
		switch(position)
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
	
	public static char checkWinner()
	{
		//a1
		if(table[0][0] != '?')
		{
			if(table[0][0] == table[0][1] && table[0][1] == table[0][2])
			{
				return table[0][0];
			}
			if(table[0][0] == table[1][1] && table[1][1] == table[2][2])
			{
				return table[0][0];
			}
			if(table[0][0] == table[1][0] && table[1][0] == table[2][0])
			{
				return table[0][0];
			}
		}
		
		//b2
		if(table[1][1] != '?')
		{
			if(table[1][1] == table[0][2] && table[0][2] == table[2][0])
			{
				return table[1][1];
			}
			else if(table[1][1] == table[1][0] && table[1][0] == table[1][2])
			{
				return table[1][1];
			}
			else if(table[1][1] == table[0][1] && table[0][1] == table[2][1])
			{
				return table[1][1];
			}
		}
		
		//c3
		if(table[2][2] != '?')
		{
			if(table[2][2] == table[2][1] && table[2][1] == table[2][0])
			{
				return table[2][2];
			}
			else if(table[2][2] == table[1][2] && table[1][2] == table[0][2])
			{
				return table[2][2];
			}
		}
		
		//catch all
		return ' ';
	}
		
	public static void computerMove(char compChoice)
	{
		// get list of available spaces
		List<String> availableMoves = new ArrayList<String>();
		
		if(table[0][0] == '?')
		{
			availableMoves.add("a1"); //0
		}
		if(table[0][1] == '?')
		{
			availableMoves.add("a2"); //1
		}
		if(table[0][2] == '?')
		{
			availableMoves.add("a3"); //2
		}
		if(table[1][0] == '?')
		{
			availableMoves.add("b1"); //3
		}
		if(table[1][1] == '?')
		{
			availableMoves.add("b2"); //4
		}
		if(table[1][2] == '?')
		{
			availableMoves.add("b3"); //5
		}
		if(table[2][0] == '?')
		{
			availableMoves.add("c1"); //6
		}
		if(table[2][1] == '?')
		{
			availableMoves.add("c2"); //7
		}
		if(table[2][2] == '?')
		{
			availableMoves.add("c3"); //8
		}
		
		//choose random index from list
		int index = random.nextInt(availableMoves.size()-1);
		
		//get computer position
		String listContent = availableMoves.get(index);
		
		//decide computer's move
		if(listContent.equals("a1"))
		{
			table[0][0] = compChoice;
		}
		else if(listContent.equals("a2"))
		{
			table[0][1] = compChoice;
		}
		else if(listContent.equals("a3"))
		{
			table[0][2] = compChoice;
		}
		else if(listContent.equals("b1"))
		{
			table[1][0] = compChoice;
		}
		else if(listContent.equals("b2"))
		{
			table[1][1] = compChoice;
		}
		else if(listContent.equals("b3"))
		{
			table[1][2] = compChoice;
		}
		else if(listContent.equals("c1"))
		{
			table[2][0] = compChoice;
		}
		else if(listContent.equals("c2"))
		{
			table[2][1] = compChoice;
		}
		else if(listContent.equals("c3"))
		{
			table[2][2] = compChoice;
		}
	}	

	public static void displayTable()
	{
		String row1 = "     1     2     3   \n";
		String row2 = "A |  " + table[0][0] +   "  |  " + table[0][1] + "  |  " + table[0][2] + "  |\n";
		String row3 = "B |  " + table[1][0] +   "  |  " + table[1][1] + "  |  " + table[1][2] + "  |\n";
		String row4 = "C |  " + table[2][0] +   "  |  " + table[2][1] + "  |  " + table[2][2] + "  |\n";
		String rowB = "  ------------------- \n";
		
		String table = row1 + rowB + row2 + rowB + row3 + rowB + row4 + rowB;
		
		//sample table display. 
		System.out.println(table);
	}

	//checks if space is available & updates the table
}
