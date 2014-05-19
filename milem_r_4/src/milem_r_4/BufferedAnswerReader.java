package milem_r_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedAnswerReader extends BufferedReader
{
	BufferedAnswerReader(InputStreamReader record)
	{
		super(record);
	}
	
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
		
		//Removes the ? from the end of the entered question.
		//System.out.println(question.charAt(question.length() - 1));
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
