package milem_r_4;

import java.io.File;

public class milemRyanHW4 {

	public static void main(String[] args) 
	{
		File record = new File("F:\\record.txt");
		
		QATree myTree = new QATree(record);
		myTree.print();
	}

}
