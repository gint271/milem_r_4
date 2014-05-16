package milem_r_4;

import java.io.BufferedWriter;

/*
 * Author: Ryan Milem
 * 
 * Programming Assignment #4
 * 
 * Date: 5-13-14
 * 
 * Description: Stores either a question or a guess for the 20 questions game.
 */

public class node 
{
	private String data;
	private Boolean isQuestion;
	private node yes, no, parent; //Stores the nodes for if the question is answered "y" or "n".
	
	public node(Boolean passIsQuestion, String passData)
	{
		this.data = passData;
		this.isQuestion = passIsQuestion;
		
		if(!this.isQuestion)
		{
			this.yes = null;
			this.no = null;
		}
	}
	
	public void printSubtree()
	{
		System.out.println(this.data);
		if(this.yes != null)
		{
			this.yes.printSubtree();
		}
		if(this.no != null)
		{
			this.no.printSubtree();
		}
	}
	
	public void save(BufferedWriter recordWriter, int tabs)
	{
		try
		{
			for(int i = 0; i<tabs; i++)
			{
				recordWriter.write("\t", 0, "\t".length());
			}
			
			if(this.isQuestion)
			{
				recordWriter.write("Q:", 0, "Q:".length());
				recordWriter.newLine();
			}
			else
			{
				
				recordWriter.write("A:", 0, "A:".length());
				recordWriter.newLine();
			}
			
			for(int i = 0; i<tabs; i++)
			{
				recordWriter.write("\t", 0, "\t".length());
			}
			recordWriter.write(this.data, 0, this.data.length());
			recordWriter.newLine();
		}
		catch(Exception e)
		{
			System.out.println("Failed to write single node's data.");
			return;
		}
		if(this.yes != null)
		{
			this.yes.save(recordWriter, tabs+1);
		}
		if(this.no != null)
		{
			this.no.save(recordWriter, tabs+1);
		}
	}
	
	public String getData()
	{
		return this.data;
	}
	
	public void setYes(node passYes)
	{
		this.yes = passYes;
	}
	
	public void setNo(node passNo)
	{
		this.no = passNo;
	}
	
	public void setParent(node passParent)
	{
		this.parent = passParent;
	}
	
	public Boolean getIsQuestion()
	{
		return this.isQuestion;
	}
	
	public node getParent()
	{
		return this.parent;
	}
	
	public node getYes()
	{
		return this.yes;
	}
	
	public node getNo()
	{
		return this.no;
	}
}
