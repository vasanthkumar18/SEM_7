import java.io.*;
import java.lang.*;
import java.util.*;

public class avg
{
	public static void main(String[] args) 
	{
		File f1= new File("/home/vasanth/Desktop/marks.txt");
		double m=0;
		try
		{
			Scanner sc=new Scanner(f1);
			while(sc.hasNextLine())
			{
				String s=sc.nextLine();
				String in[]=s.split(" ");
				m+=Double.parseDouble(in[2]);
				
			}
		}
		catch(Exception e){}
		System.out.println((double)m/46.0);
		
	}
	
}

