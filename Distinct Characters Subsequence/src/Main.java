import java.util.Scanner;


public class Main {

	
	
	
	public int countLengthUnique(String input)
	{
		//StringBuffer sequence= new StringBuffer();
		int sequenceLength =0;
		int [] charCountSequence = new int[26];
		int length = input.length();
		for(int i=0;i<length;i++)
		{
			char c =input.charAt(i);
			//System.out.println(c+" "+(c%'a'));
			//System.out.println(charCountSequence[c%'a']);
			if(charCountSequence[c%'a']==1)
			{
				continue;
			}
			else
			{
				charCountSequence[c%'a']+=1;
				sequenceLength++;
				//sequence.append(c);
			}
			
		}
		return sequenceLength ;
		//System.out.println(sequence.toString());
	}
	
	
	
	
	public static void main(String[] args) 
	{
		
	   Main obj = new Main();	
	   try
	   {
		   
		   Scanner in1 = new Scanner(System.in);
		   int noTestCases=Integer.parseInt(in1.nextLine());
		   int[] result = new int[noTestCases];
		   for(int i=0;i<noTestCases;i++)
		   {
			   String input = in1.nextLine();
			   //System.out.println(input);
			   result [i]=obj.countLengthUnique(input);
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
