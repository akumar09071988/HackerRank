import java.util.Scanner;


public class Main1 {
	
	
	
	public String palindromePossible(String input)
	{
		String result="YES";
		int length = input.length();
		int deleted =0;
		int lastsequence=length-1;
		for(int i=0;i<=(length/2);i++)
		{
			if(input.charAt(i)==input.charAt(lastsequence))
			{
				lastsequence-=1;
			}
			else if(input.charAt(i)!=input.charAt(lastsequence))
			{
				
				if(input.charAt(i)!=input.charAt(lastsequence-1))
				{
					deleted+=1;
//					if(input.charAt(i+1)!=input.charAt(lastsequence))
//					{
//						result="NO";
//						break;	
//					}
//					else if(input.charAt(i+1)==input.charAt(lastsequence))
//					{
//						deleted+=1;
//						i+=1;
//						lastsequence-=1;
//					}
					
				}
				else
				{
					deleted+=1;
					lastsequence-=2;
				}
			}
			if(deleted>1)
			{
				result="NO";
				break;	
			}
		}
		return result;
	}

	public static void main(String[] args) 
	{

		 Main1 obj = new Main1();
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
			 e.printStackTrace();
		 }

	}

}
