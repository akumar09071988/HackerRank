import java.util.Scanner;


public class Solution {
	
	public void calcMinEnergy(int[] buildingsHeightArr)
	{
		int numBuildings = buildingsHeightArr.length;
		float currentEnergy =0;
		float requirredCurrEnergy =0;
		float minEnergy =0;
		currentEnergy = buildingsHeightArr[numBuildings-1]/2;
		for(int i=numBuildings-3;i>-1;i--)
		{
		   	if(currentEnergy<buildingsHeightArr[i+1])
		   	{
		   		currentEnergy = (buildingsHeightArr[i+1]+currentEnergy)/2;
		   		
		   	}
		   	else
		   	{
		   	   int diff = (int) (currentEnergy - buildingsHeightArr[i+1])/2;
		   	   //System.out.println(diff+" diff");
		   	   currentEnergy=currentEnergy-diff;
		   	}
		  
		   	if((currentEnergy*10)%10!=0)
			{
		   		currentEnergy =(int)currentEnergy+1;	
			}
		  // 	System.out.println(currentEnergy+" -");
		}
		if(currentEnergy<buildingsHeightArr[0])
		{
			currentEnergy = (buildingsHeightArr[0]+currentEnergy)/2;
		}
		else
		{
			   int diff = (int) (currentEnergy - buildingsHeightArr[0])/2;
		   	 //  System.out.println(diff+" diff1");
		   	   currentEnergy=currentEnergy-diff;
		}
		if((currentEnergy*10)%10!=0)
		{
	   		currentEnergy =(int)currentEnergy+1;	
		}
		int finalEnergy = (int) currentEnergy;
		System.out.println(finalEnergy);
		
	}

	public static void main(String[] args) {
	   Solution obj = new Solution();
	   try
	   {
		   
		   Scanner in = new Scanner(System.in);
		   int numBuildings = Integer.parseInt(in.nextLine());
		   int [] buildingsHeightArr = new int[numBuildings];
		   for(int i=0;i<numBuildings;i++)
		   {
			   buildingsHeightArr[i] = in.nextInt();
			   //System.out.println(buildingsHeightArr[i]);
		   }
		   
		   obj.calcMinEnergy(buildingsHeightArr);
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }

	}

}
