import java.util.Scanner;


public class Main {
	
	
//	public String palindromePossible(String input)
//	{
//		String retString ="YES";
//		int[][] editDistMatrix = new int[input.length()+1][input.length()+1];
//		for(int i=0;i<editDistMatrix.length;i++)
//		{
//			editDistMatrix[0][i]= editDistMatrix[i][0] =i;
//		}
//		
//		int length = input.length();
//		for(int row =1;row<editDistMatrix.length;row++)
//		{
//			for(int col =1;col<editDistMatrix[row].length;col++)
//			{
//				if(input.charAt(length-row)==input.charAt(col-1))
//				{
//					editDistMatrix[row][col]=editDistMatrix[row-1][col-1];
//				}
//				else
//				{
//					editDistMatrix[row][col] = min(editDistMatrix[row-1][col],editDistMatrix[row-1][col-1],editDistMatrix[row][col-1])+1;
//				}
//			}
//		}
//		System.out.println(editDistMatrix[input.length()][input.length()]);
//		printMatrix(editDistMatrix);
//		return retString;
//	}
	
	public String palindromePossible(String input)
	{
		String retString="YES";
	    int length = input.length();
	    int [][] sequence = new int[length+1][length+1];
	     for(int i=0;i<=length;i++)
	     {
	    	 for(int j=0;j<=length;j++)
	    	 {
	    		 if (i == 0 || j == 0)
	    		 {
	    		 sequence[i][j] = 0;
	    		 }
	    		 else if (input.charAt(i-1) == input.charAt(length-j))
	    		 {
	    		 sequence[i][j] = sequence[i-1][j-1] + 1;
	    		 }
	    		 else
	    		 {
	    		 sequence[i][j] = max(sequence[i-1][j], sequence[i][j-1]);
	    		 }
	    	 }
	     }
	     //System.out.println(sequence[length-1][length-1]);
	     //printMatrix(sequence);
		if(sequence[length][length]<input.length()-1)
		{
			retString="NO";
		}
	     return retString;
	}
	
	private int max(int a, int b)
	{
	return (a > b)? a : b;
	}
	
    public void printMatrix(int[][] input)
    {
    	for(int i=0;i<input.length;i++)
    	{
    		for(int k=0;k<input[i].length;k++)
    		{
    			System.out.print(input[i][k]+" ");
    		}
    		System.out.println(" ");
    	}
    }
	
	public int min(int a,int b,int c)
	{
		if(a<b)
		{
			if(a<c)
			{
				return a;
			}
			else
			{
				return c;
			}
		}
		else
		{
			if(b<c)
			{
				return b;
			}
			else
			{
				return c;
			}
		}
		
	}

	public static void main(String[] args)
	{
		Main obj = new Main();
		try
		{
			Scanner in1 = new Scanner(System.in);
			int noTestCases=Integer.parseInt(in1.nextLine());
			String[] result = new String[noTestCases];
			for(int i=0;i<noTestCases;i++)
			 {
				 String input = in1.nextLine();
			     result[i] = obj.palindromePossible(input); 
			 }
			
			for(int i=0;i<result.length;i++)
			{
				System.out.println(result[i]);
			}
		}
		catch(Exception e)
		{
			
		}

	}

}
