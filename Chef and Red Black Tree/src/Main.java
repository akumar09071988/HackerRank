import java.util.Scanner;


public class Main {
	
	static String operation1 ="Qb";
	static String operation2 ="Qr";
	static String operation3 ="Qi";
	int timesChange          = 0;
	
	public int findCommonParentHeight(int node1,int node2)
	{
		int parent1 = node1/2;
		int parent2 = node2/2;
		int height=0;
		while(true)
		{
			if(parent1==parent2)
			{
				break;
			}
			else
			{
				parent1 = parent1/2;
				parent2 = parent2/2;
				height++;
			}
		}
		return height;
	}
	
	public int qbOperation(int height,int parentHeight)
	{
		int numLevels = (height - parentHeight) +1;
	    if(height%2==0)
	    {
	    	numLevels --;
	    }
	    
	    if(parentHeight%2==0)
	    {
	    	numLevels--;
	    }
	    numLevels = numLevels/2;
	    return 2 *numLevels;
	}
	
	public int qrOperation(int height,int parentHeight)
	{
		int numLevels = (height - parentHeight) +1;
	    if(height%2==0)
	    {
	    	numLevels --;
	    }
	    
	    if(parentHeight%2==0)
	    {
	    	numLevels--;
	    }
	    
	    return 2 *numLevels;
	}
	
	public void executeOperations(String input,int node1,int node2)
	{
		if(input.equalsIgnoreCase(operation3))
		{
			
		}
		else
		{
			int height1 = findHeight(node1);
			int height2 = findHeight(node2);
			if(height1==height2)
			{
				int parentheight = findCommonParentHeight(node1, node2);
				if(input.equalsIgnoreCase(operation1))
				{
					int numBlackNodes = qbOperation(height1, parentheight);
				}
			}
			else
			{
				if(height1<height2)
				{
					int tempNode2 = decreaseHeight(height1, node2);
					int parentheight = findCommonParentHeight(node1, tempNode2);
				}
				else
				{
					int tempNode1 = decreaseHeight(height2, node1);
					int parentheight = findCommonParentHeight(tempNode1, node2);
				}
			}
		}
	}
	
	public int decreaseHeight(int height,int node)
	{
         while(true)
         {
        	 node= node/2;
        	 if(findHeight(node)==height)
        	 {
        		 break;
        	 }
         }
		
         return node;
		
	}
	
	public int findHeight(int node1)
	{
		int height   = 0;
		int seed     = 1;
		int numNodes = 1;
		while(true)
		{
			if(node1<=seed)
			{
				break;
			}
			else
			{
				numNodes = numNodes*2;
				seed     = seed+numNodes;
				height   +=1;
			}
		}
		return height;
	}
	
	
	public static void main(String[] args)
	{
	   Main obj = new Main();
	   try
	   {
		   Scanner in = new Scanner(System.in);
		   int numOperations =Integer.parseInt(in.nextLine());
	       for(int i=0;i<numOperations;i++)
	       {
	    	   String input       = in.nextLine();
	    	   System.out.println(input);
	    	   String opeationStr = input.split(" ")[0];
	           int node1          =  0;
	           int node2          =  0;
	    	   if(!opeationStr.equalsIgnoreCase(operation3))
	    	   {
	    		   node1         = Integer.parseInt(input.split(" ")[1]);
		   		   node2         = Integer.parseInt(input.split(" ")[2]);
		   	          
	    	   }
	    	   obj.executeOperations(input,node1,node2);
	   		  
	       }
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }

	}

}
