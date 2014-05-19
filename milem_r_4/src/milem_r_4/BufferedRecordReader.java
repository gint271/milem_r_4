/*
 * Author: Ryan Milem
 * 
 * Programming Assignment 4
 * 
 * Date: 5/19/2014
 * 
 * Used to get the text from the save file.
 */

package milem_r_4;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedRecordReader extends BufferedReader 
{
	BufferedRecordReader(FileReader savedFile)
	{
		super(savedFile);
	}
	
	//Was originally used when file was formatted with tabs.  Kept in case craziness happens.
	//Removes any whitespace at the start or end of string.
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
