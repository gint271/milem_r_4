/*
 * Author: Ryan Milem
 * 
 * Programming Assignment 4
 * 
 * Date: 5/19/2014
 * 
 * Handles overall interaction between the user's commands and the various classes for the "20 Questions" game.
 */

package milem_r_4;

import java.io.File;
import java.io.InputStreamReader;

public class milemRyanHW4 {

	public static void main(String[] args) 
	{
		File record; //The file in which the answers and questions for the game is saved.
		BufferedAnswerReader keyboard = new BufferedAnswerReader(new InputStreamReader(System.in));
		QATree myTree;
		String addedNoun;
		String addedQuestion;
		String input = "y"; //Stores the string the user just typed in.  Mainly used for looping the game.
	
		System.out.println("Enter the path of the record to be loaded.");
		
		try
		{
			record = new File(keyboard.readLine());
		}
		catch(Exception e)
		{
			System.out.println("Failed to open file.");
			return;
		}
		
		if(record.canRead() && record.canWrite())
		{
			myTree = new QATree(record);
		}
		else
		{
			System.out.println("Can't read or can't write file.");
			return;
		}
		
		while(input.equals("y"))
		{
			//Revert back to the top of the tree.
			myTree.reset();
		
			//Loops until the bottom of the tree is reached.
			while(myTree.hasNext())
			{
				myTree.printPrompt(); //Asks the node's question.
				try{
					if(keyboard.getsYes())
					{
						myTree.moveYes();
					}
					else
					{
						myTree.moveNo();
					}
				}
				catch(Exception e)
				{
					System.out.println("Failed to get answer.");
					return;
				}
			}
			
			myTree.printPrompt(); //Prints the node's guess.
		
			try{
				if(keyboard.getsYes())
				{
					System.out.println("I win!");
				}
				else
				{
					System.out.println("Darn");
					System.out.println("What were you thinking of?");
					addedNoun = keyboard.readLine();
					
					System.out.println("Enter a question for which yes would be the correct noun, and no would be the noun I guessed.");
					
					addedQuestion = keyboard.readQuestion();
					
					myTree.add(addedQuestion, addedNoun); //Adds the new question an noun to the tree.
				}
			}
			catch(Exception e)
			{
				System.out.println("Failed to get new questions/noun from console.");
				return;
			}
	
			System.out.println("Do you want to play again?");
			
			try
			{
				input = keyboard.readLine();
			}
			catch(Exception e)
			{
				System.out.println("Failed to read user input.");
				return;
			}
		}
		
		try
		{
			keyboard.close();
		}
		catch (Exception f)
		{
			System.out.println("Failed to close file.");
		}
		myTree.save(record);
	}
}
