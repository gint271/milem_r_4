package milem_r_4;

import java.io.File;
import java.util.Scanner;

public class milemRyanHW4 {

	public static void main(String[] args) 
	{
		File record = new File("F:\\record.txt");
		Scanner keyboard = new Scanner(System.in);
		QATree myTree = new QATree(record);
		String addedNoun;
		String addedQuestion;
		
		while(myTree.hasNext())
		{
			myTree.printPrompt();
			if(keyboard.next().equals("y"))
			{
				myTree.moveYes();
			}
			else
			{
				myTree.moveNo();
			}
		}
		
		myTree.printPrompt();
	
		if(keyboard.next().equals("y"))
		{
			System.out.println("I win!");
		}
		else
		{
			System.out.println("Darn");
			System.out.println("What were you thinking of?");
			addedNoun = keyboard.next();
			
			System.out.println("Enter a question for which yes would be the correct noun, and no would be the noun I guessed.");
			addedQuestion = "";
			while(keyboard.hasNext())
			{
				addedQuestion = addedQuestion + " " + keyboard.next();
			}
			System.out.println(addedQuestion);
		}
		
	}

}
