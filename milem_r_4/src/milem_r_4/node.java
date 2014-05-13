package milem_r_4;

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
	
	public node(String passData, Boolean passIsQuestion)
	{
		this.data = passData;
		this.isQuestion = passIsQuestion;
	}
	
	public void print()
	{
		System.out.println(this.data);
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
}
