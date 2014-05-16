package milem_r_4;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

public class milemRyanHW4 {

	public static void main(String[] args) 
	{
		File record;
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		QATree myTree;
		String addedNoun;
		String addedQuestion;
		String input = "y";
	
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
			myTree.reset();
		
			while(myTree.hasNext())
			{
				myTree.printPrompt();
				try{
					if(keyboard.readLine().equals("y"))
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
			
			myTree.printPrompt();
		
			try{
				if(keyboard.readLine().equals("y"))
				{
					System.out.println("I win!");
				}
				else
				{
					System.out.println("Darn");
					System.out.println("What were you thinking of?");
					addedNoun = keyboard.readLine();
					
					System.out.println("Enter a question for which yes would be the correct noun, and no would be the noun I guessed.");
					
					addedQuestion = keyboard.readLine();
					System.out.println(addedQuestion);
					
					myTree.add(addedQuestion, addedNoun);
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
		catch (Exception e)
		{
			System.out.println("Failed to close file.");
		}
		myTree.save(record);
	}

}
