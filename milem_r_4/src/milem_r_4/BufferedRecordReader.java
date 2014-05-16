package milem_r_4;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedRecordReader extends BufferedReader 
{
	BufferedRecordReader(FileReader savedFile)
	{
		super(savedFile);
	}
	
	String readTrimmed()
	{
		try
		{
			return super.readLine().trim();
		}
		catch (Exception e)
		{
			System.out.println("I failed to read the line.  Recommend terminating program and checking save file.");
			return "AAAAAAA!";
		}
	}
}
