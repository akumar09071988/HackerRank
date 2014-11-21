import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) 
	{
	  Solution obj = new Solution();
	  try
	  {
		  Scanner in = new Scanner(System.in);
		  int numCopies = Integer.parseInt(in.nextLine());
		  ArrayList<Integer> list = new ArrayList<Integer>();
		  boolean increasing =true;
		  for(int i=0;i<numCopies;i++)
		  {
			  int noNum = in.nextInt();
			  int last=0;
			  for(int k=0;k<noNum;k++)
			  {
				  list.add(in.nextInt());
				  if(last>list.get(list.size()-1))
				  {
					  increasing=false;
				  }
				  last = list.get(list.size()-1);
				 
				  
			  }
		  }
		  Collections.sort(list);
		  ArrayList<Integer> finalList = new ArrayList<Integer>();
		  for(int i=0;i<list.size();i++)
		  {
			  if(i!=0)
			  {
				  if(list.get(i)!=list.get(i-1))
				  {
					  finalList.add(list.get(i));
				  }
			  }
			  else
			  {
				  finalList.add(list.get(i));
			  }
		  }
		  
		  if(increasing)
		  {
			  for(int i=0;i<finalList.size();i++)
			  {
				  System.out.print(finalList.get(i)+" ");
			  }
		  }
		  else
		  {
			  for(int i=finalList.size();i>-1;i--)
			  {
				  System.out.print(finalList.get(i)+" ");
			  }
		  }
	  }
      catch(Exception e)
	  {
    	  e.printStackTrace();
	  }
	}

}
