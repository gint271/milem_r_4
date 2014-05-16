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
		System.out.println(question.charAt(question.length() - 1));
		if(question.charAt(question.length() - 1) == '?')
		{
			question = question.substring(1);
		}
		
		//Makes the first letter of the question capital.
		if(question.charAt(0) < 91)
		{
			question = (question.charAt(0) - 32) + question.substring(1);
		}
		
		return question;
	}
}
