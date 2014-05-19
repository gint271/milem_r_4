/*
 * Author: Ryan Milem
 * 
 * Programming Assignment 4
 * 
 * Date: 5/19/2014
 * 
 * 
 */

package milem_r_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedAnswerReader extends BufferedReader
{
	BufferedAnswerReader(InputStreamReader record)
	{
		super(record);
	}
	
	//Gets the yes/no response for a question or guess and returns true if the answer was yes.
	//Recurses until an answer of y or n is given.
	Boolean getsYes()
	{
		String input;
		
		try
		{
			input = this.readLine();
		}
		catch (Exception e)
		{
			System.out.println("I broke trying to get an answer to the question.");
			return false;
		}
			if(input.equals("y"))
			{
				return true;
			}
			else if(input.equals("n"))
			{
				return false;
			}
			else
			{
				System.out.println("Invalid input.  Please enter a y or a n.");
				return this.getsYes();
			}
		
	}
	
	//Returns the new question to be added to the tree.
	String readQuestion()
	{
		String question = "initial";
		
		try
		{
			question = readLine();
		}
		catch (Exception e)
		{
			System.out.println("Failed to read new question.");
		}
		
		//Removes the ? from the end of the entered question.  This is done to stay consistent in formatting.
		if(question.substring(question.length() - 1).equals("?"))
		{
			question = question.substring(0, question.length() - 1);
		}
		
		//Ensures that the question starts with a capital letter.
		question = question.substring(0,1).toUpperCase() + question.substring(1);
		
		System.out.println(question);
		
		return question;
	}
}
