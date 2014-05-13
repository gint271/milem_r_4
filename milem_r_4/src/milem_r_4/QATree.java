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
			this.conductor = this.header;
		}
	}
	
	public void moveYes()
	{
		this.conductor = this.conductor.getYes();
	}
	
	public void moveNo()
	{
		this.conductor = this.conductor.getNo();
	}
	
	public void print()
	{
		if(header != null)
		{
			header.printSubtree(); //Starts the recursive printing at the header.
		}
	}
	
	public Boolean hasNext()
	{
		
		return conductor.getYes() != null && conductor.getNo() != null;
	}
	
	public void printPrompt()
	{
		if(conductor.getIsQuestion())
		{
			System.out.println(conductor.getData());
			
		}
		else
		{
			System.out.println("Is it a " + conductor.getData() + "?");
		}
	}
	
	private node textToNode(BufferedReader recordReader)
	{
		node newNode = null;
		
		try
		{
			newNode = new node(recordReader.readLine().equals("Q:"), recordReader.readLine());
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
