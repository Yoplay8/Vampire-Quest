package Test_Program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils
{

	public static String Load_File_As_String(String Path)
	{
		
		StringBuilder Builder = new StringBuilder();
		
		
		try
		{
			
			BufferedReader Br = new BufferedReader(new FileReader(Path));
			String Line;
			
			
			while((Line = Br.readLine()) != null)
				Builder.append(Line + '\n');
			
			
			Br.close();
			
		}
		catch(IOException E)
		{
			
			E.printStackTrace();
		}
		
		
		return Builder.toString();
	}
	
	public static int Parse_Int(String Number)
	{
		
		try
		{
			
			return Integer.parseInt(Number);
			
		}
		catch(NumberFormatException E)
		{
			
			E.printStackTrace();
			return 0;
			
		}

	}
	
}
