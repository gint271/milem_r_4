package milem_r_4;

import java.io.*;

/*
 * Author: Ryan Milem
 * 
 * Programming Assignment #4
 * 
 * Date: 5-13-14
 * 
 * Description: Stores the decision tree for 20 Questions.  Also includes methods for dealing with modifying
 * 		or traversing the tree.
 */

public class QATree 
{
	private node header, conductor;
	
	public QATree()
	{
		
	}
	
	public QATree(File treeRecord)
	{
		try
		{
			BufferedReader recordReader = new BufferedReader(new FileReader(treeRecord));
		}
		catch(Exception e)
		{
			System.out.println("File failed to open.  Staring with an empty tree.");
		}
		
		//todo: Reading the file and building the tree.
	}
	
	void print()
	{
		if(header != null)
		{
			header.print();
		}
	}
}
