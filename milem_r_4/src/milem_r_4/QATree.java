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
	private node header;
	
	public QATree(File treeRecord)
	{		
		BufferedReader recordReader = null;
		
		try
		{
			recordReader = new BufferedReader(new FileReader(treeRecord));
		}
		catch(Exception e)
		{
			System.out.println("File failed to open.  Staring with an empty tree.");
		}
		
		if(recordReader != null)
		{
			this.header = textToNode(recordReader);
		}
	}
	
	public void print()
	{
		if(header != null)
		{
			header.print(); //Starts the recursive printing at the header.
		}
	}
	
	private node textToNode(BufferedReader recordReader)
	{
		node newNode = null;
		
		try
		{
			newNode = new node(recordReader.readLine().equals("Q:\n"), recordReader.readLine());
		}
		catch (Exception e)
		{
			System.out.println("No next line? Maybe?");
		}
		
		if(newNode != null)
		{
			if(newNode.getIsQuestion())
			{
				newNode.setYes(textToNode(recordReader));
				newNode.setNo(textToNode(recordReader));
			}
		}
		
		return newNode;
	}
}
