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
		BufferedRecordReader recordReader = null;
		
		try
		{
			recordReader = new BufferedRecordReader(new FileReader(treeRecord));
		}
		catch(Exception e)
		{
			System.out.println("File failed to open.  Staring with an empty tree.");
		}
		
		if(recordReader != null)
		{
			this.header = textToNode(recordReader);  //Loads the file into the tree.
			this.conductor = this.header;
		}
	}
	
	//Writes the tree to the given file.
	public void save(File record)
	{
		BufferedWriter saver;
		
		try
		{
			saver = new BufferedWriter(new FileWriter(record));
		}
		catch(Exception e)
		{
			System.out.println("Save unsuccesful.");
			return;
		}
		
		this.header.save(saver);
		
		try
		{
			saver.close();
		}
		catch(Exception e)
		{
			System.out.println("Failed to close file");
		}
	}
	
	//Used to prepare for new game of questions.
	public void reset()
	{
		this.conductor = this.header;
	}
	
	public void moveYes()
	{
		this.conductor = this.conductor.getYes();
	}
	
	public void moveNo()
	{
		this.conductor = this.conductor.getNo();
	}
	
	//Prints the entire tree in the console.
	public void print()
	{
		if(this.header != null)
		{
			this.header.printSubtree(); //Starts the recursive printing at the header.
		}
	}
	
	//Checks to see if conductor is on an answer node.
	public Boolean hasNext()
	{
		return this.conductor.getYes() != null && this.conductor.getNo() != null;
	}
	
	//Prints either the program's guess or question to the console.
	public void printPrompt()
	{
		if(this.conductor.getIsQuestion())
		{
			System.out.println(this.conductor.getData() + "?");
			
		}
		else
		{
			System.out.println("I think I have it.  Is it a " + this.conductor.getData() + "?");
		}
	}
	
	//After guessing wrong, this is used to add to the decision tree.
	public void add(String newQuestion, String newAnswer)
	{
		node newQuestionNode = new node(true, newQuestion);
		node newAnswerNode = new node(false, newAnswer);
		
		newQuestionNode.setNo(this.conductor);
		newQuestionNode.setYes(newAnswerNode);
		
		if(this.conductor.getParent().getYes() == this.conductor)
		{
			this.conductor.getParent().setYes(newQuestionNode);
		}
		else
		{
			this.conductor.getParent().setNo(newQuestionNode);
		}
		
		newQuestionNode.setParent(this.conductor.getParent());
		newAnswerNode.setParent(newQuestionNode);
		this.conductor.setParent(newQuestionNode);
	}
	
	//Used to load tree from file.
	private node textToNode(BufferedRecordReader recordReader)
	{
		node newNode = null;
		
		try
		{
			newNode = new node(recordReader.readTrimmed().equals("Q:"), recordReader.readTrimmed());
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
				newNode.getYes().setParent(newNode);
				newNode.setNo(textToNode(recordReader));
				newNode.getNo().setParent(newNode);
			}
		}
		
		return newNode;
	}
}
