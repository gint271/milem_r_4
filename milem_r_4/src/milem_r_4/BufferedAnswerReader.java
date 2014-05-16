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
}
