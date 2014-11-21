import java.util.ArrayList;
import java.util.Scanner;


public class Solution {
	
	class Nodes
	{
		ArrayList<Integer> adjList = new ArrayList<Integer>();
		int nodeNum =0;
		int a;
		int b;
		
	}
	
    class dfs
    {
    	int [] edgeTo;
    	boolean [] marked;
    	boolean found =false;
    	int target=-1;
    	public dfs(int s,int sink)
    	{
    		edgeTo = new int[Solution.this.numNodes+1];
    		marked = new boolean[Solution.this.numNodes+1];
    		edgeTo[s]=-1;
    		target = sink;
    		dfsSearch(s);
    	}
    	
    	public void dfsSearch(int s)
    	{
    		//System.out.println(s);
    		if(!marked[s])
    		{
    			marked[s]=true;
    			if(s == this.target)
    			{
    				found =true;
    			}
    			if(!found)
    			{
    				ArrayList<Integer> list = Solution.this.nodeArray[s].adjList;
        			for(int i=0;i<list.size();i++)
        			{
        				int node = list.get(i);
        				if(!marked[node])
        				{
        					edgeTo[node]=s;
        					if(found)
        					{
        						break;
        					}
        					dfsSearch(node);
        				}
        			}	
    			}
    			
    		}
    	}
    }
	
	int numNodes= 0;
	Nodes [] nodeArray ;
	ArrayList<Integer> resultList = new ArrayList<Integer>();
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution obj = new Solution();
		try
		{
			Scanner in = new Scanner(System.in);
			obj.numNodes = Integer.parseInt(in.nextLine());
			obj.nodeArray = new Nodes[obj.numNodes+1];
			for(int i=0;i<obj.numNodes;i++)
			{
				Nodes node = obj .new Nodes();
				node.nodeNum=i+1;
				node.a = in.nextInt();
				node.b = in .nextInt();
			//	System.out.println(node.nodeNum+" "+node.a+" "+node.b);
				obj.nodeArray[i+1]=node;
			}
			
			for(int i=0;i<obj.numNodes-1;i++)
			{
				int node1 = in.nextInt();
				int node2 = in.nextInt();
				//System.out.println(node1+" "+node2);
				obj.nodeArray[node1].adjList.add(node2);
				obj.nodeArray[node2].adjList.add(node1);
			}
			int numQueries = in.nextInt();
			in.nextLine();
		//	System.out.println("numQueries "+numQueries);
			for(int i=0;i<numQueries;i++)
			{
				String str = in.nextLine();
			//	System.out.println(str);
				String  command =str.split(" ")[0];
				if(command.equalsIgnoreCase("1"))
				{
					int source = Integer.parseInt(str.split(" ")[1]);
					int destination = Integer.parseInt(str.split(" ")[2]);
					int a =Integer.parseInt(str.split(" ")[3]);
					int b = Integer.parseInt(str.split(" ")[4]);
					obj.execute1(source, destination, a, b);
				}
				else
				{
					int source = Integer.parseInt(str.split(" ")[1]);
					int destination = Integer.parseInt(str.split(" ")[2]);
					int a =Integer.parseInt(str.split(" ")[3]);
					obj.execute2(source, destination, a);
				}
			}
			
			for(int i=0;i<obj.resultList.size();i++)
			{
				System.out.println(obj.resultList.get(i));
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	
	
	public void execute1(int source,int destination,int a,int b)
	{
		dfs dfs = new dfs(source,destination);
		int [] edgeTo = dfs.edgeTo;
        int i=destination;
        while(i!=source)
        {
        	this.nodeArray[i].a = a;
        	this.nodeArray[i].b =b;
        	i=edgeTo[i];
        }
        this.nodeArray[i].a=a;
        this.nodeArray[i].b=b;
	}
	
	public void execute2(int source,int destination,int a )
	{
		dfs dfs = new dfs(source,destination);
		int [] edgeTo = dfs.edgeTo;
		int [] next = new int[this.numNodes+1];
        int i=destination;
        
        while(i!=source)
        {
        	int temp=i;
        	i=edgeTo[i];
        	next[i]=temp;
        }
        
        
        while(i!=destination)
        {
           a = (this.nodeArray[i].a*a)+this.nodeArray[i].b;
           //a= a%((10^9)+7);
           i = next[i];
        }
        a = (this.nodeArray[i].a*a)+this.nodeArray[i].b;
        a= a%((10^9)+7);
        this.resultList.add(a);
	}
	
	

}
//for checking purpose
/*for(int i=0;i<obj.numNodes;i++)
{
	ArrayList<Integer> listLocal = obj.nodeArray[i+1].adjList;
	System.out.println(obj.nodeArray[i+1].nodeNum+" nodeNum has ");
	for(int k=0;k<listLocal.size();k++)
	{
		System.out.print(listLocal.get(k)+" - ");
	}
	System.out.println();
}*/