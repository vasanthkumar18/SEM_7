import java.io.*;
import java.lang.*;
import java.util.*;

public class work
{
    public static HashMap<String, Double> sortByValue(HashMap<String, Double> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Double> > list =
               new LinkedList<Map.Entry<String, Double> >(hm.entrySet());
 
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Double> >() {
            public int compare(Map.Entry<String, Double> o1,
                               Map.Entry<String, Double> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
         
        // put data from sorted list to hashmap
        HashMap<String, Double> temp = new LinkedHashMap<String, Double>();
        for (Map.Entry<String, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    
	public static void main(String[] args) 
	{

		  File f1 = new File("/home/vasanth/Desktop/ppl.txt");
		  File f2 = new File("/home/vasanth/Desktop/roll.txt");
		  HashMap<String,Double> map=new HashMap<>();
		  HashMap<String,String> hm=new HashMap<>();
		  try 
		  {
			      Scanner sc=new Scanner(f1);
			      while(sc.hasNextLine())
			      {
				  
				  String p=sc.nextLine();
				  //System.out.println(p);
				  String inp[]=p.split(" ");
				  int len=inp.length;
				  String roll=inp[1];
				  double marks=Double.parseDouble(inp[len-1]);

				  map.put(roll,marks);
		          
		      		}
		      
		  } 
		  catch(Exception e) {}
		  
		  try 
		  {
			      Scanner sc=new Scanner(f2);
			      while(sc.hasNextLine())
			      {
				  
				  String p=sc.nextLine();
				  //System.out.println(p);
				  String inp[]=p.split(" ");
				  int len=inp.length;
				  String roll=inp[1];
				  String name="";
				  for(int i=2;i<len-1;i++)
				  {
				  	name+=inp[i]+" ";
				  }

				  hm.put(roll,name);
				  
		          
		      		}
		      
		  } 
		  catch(Exception e) {}
		  
		  
		  //System.out.println("==================================================");
		  //System.out.println(map);
		  HashMap<String, Double> hm1 = sortByValue(map);
 
		// print the sorted hashmap
		int i=1;
		for (Map.Entry<String, Double> en : hm1.entrySet()) 
		{
		    String roll=en.getKey();
		    System.out.print(i+" "+roll+" "+ en.getValue());
		    for(String s: hm.keySet())
		    {
		    	if(s.equals(roll))
		    	{
		    		System.out.println(" "+hm.get(s));
		    		break;	
		    	}
		    }
            	    i++;
		}
		  

	}
}

