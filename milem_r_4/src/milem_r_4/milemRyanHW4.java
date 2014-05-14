package milem_r_4;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

public class milemRyanHW4 {

	public static void main(String[] args) 
	{
		File record = new File("F:\\record.txt");
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		QATree myTree = new QATree(record);
		String addedNoun;
		String addedQuestion;
		
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
				
				
			}
		}
		catch(Exception e)
		{
			System.out.println("Failed to get new questions/noun from console.");
			return;
		}
		
	}

}
