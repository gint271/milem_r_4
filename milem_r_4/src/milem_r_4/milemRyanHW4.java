package milem_r_4;

import java.io.File;
import java.util.Scanner;

public class milemRyanHW4 {

	public static void main(String[] args) 
	{
		File record = new File("F:\\record.txt");
		Scanner keyboard = new Scanner(System.in);
		
		QATree myTree = new QATree(record);
		
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
		
		
	}

}
