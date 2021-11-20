import java.io.*;
import java.lang.*;
import java.util.*;

class Person
{
    String roll;
    double a1=0;
    double a2=0;
    double a3=0;
    double a4=0;
    Person(String roll, double a1, double a2, double a3, double a4)
    {
        this.roll=roll;
        this.a1=a1;
        this.a2=a2;
        this.a3=a3;
        this.a4=a4;
        
    }
    public double add()
    {
        return a1+a2+a3+a4;
    }
    
    
}
public class prog
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

		  File f1 = new File("/home/pandu/Desktop/marks.txt");
		  HashMap<String,Double> map=new HashMap<>();
		  try {
			      Scanner sc=new Scanner(f1);
			      while(sc.hasNextLine())
			      {
				  
				  String p=sc.nextLine();
				  //System.out.println(p);
				  String inp[]=p.split(" ");
				  
				  String roll=inp[1];
				  double a1=0;
				  double a2=0;
				  double a3=0;
				  double a4=0;
				  try
				  {
				      a1=Double.parseDouble(inp[2]);
				  }
				  catch(Exception e){}
				  try
				  {
				      a2=Double.parseDouble(inp[3]);
				  }
				  catch(Exception e){}
				  try
				  {
				      a3=Double.parseDouble(inp[4]);
				  }
				  catch(Exception e){}
				  try
				  {
				      a4=Double.parseDouble(inp[5]);
				  }
				  catch(Exception e){}
				  Person cand=new Person(roll,a1,a2,a3,a4);
				  
				  double marks=cand.add();

				  map.put(roll,marks);
		          
		      		}
		      
		  } 
		  catch(Exception e) {}
		  System.out.println("==================================================");

		  
		  HashMap<String, Double> hm1 = sortByValue(map);
 
		// print the sorted hashmap
		int i=1;
		for (Map.Entry<String, Double> en : hm1.entrySet()) 
		{
		    System.out.println(i+" "+ en.getKey() +" "+ en.getValue());
            		i++;
		}
		  

	}
}

