
import java.io.*;
public class Floyed
{
	
	
	public static int [][] getShortWay(int a[][],int n)
	{
		
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					 for(int k=0;k<n;k++)
				{
					a[i][j]=Math.min(a[i][j],(a[i][k]+a[k][j]));
				}
			
			return a;
	}
	
public static void main(String args[])
{   
	
	int i=0,j=0;
	int a[][]={{0,8,5,0},{3,0,100,0},{100,2,0,0}};
	
	int [][]result=Floyed.getShortWay(a, 3);
	
       for(j=0;j<3;j++)
       {
		for(i=0;i<3;i++)		
		{
	     System.out.print(result[i][j]+" ");
		}
		
		System.out.println();
       }
	
      
}
}
