package arrayandsort;


public class TestSort {
	
	
	
	//二维数组选择排序
	public static void SelectSort2(int a[][])
	{
		
		for(int i=0;i<a.length;i++)
		{
			
			int temp=0;
			for(int j=0;j<a.length;j++)
			{
				
				if(a[i][1]<a[j][1])
				{
					temp=a[i][1];
					a[i][1]=a[j][1];
					a[j][1]=temp;
					
					temp=a[i][0];
					a[i][0]=a[j][0];
					a[j][0]=temp;
					
				}
			}
		}
		
	}
	
	
	//二维数组冒泡排序
	public static void PopSort2(int a[][])
	{
		
		for(int i=0;i<a.length;i++)
		{
			
			int temp=0;
			for(int j=0;j<a.length-i-1;j++)
			{
				
				if(a[j][1]>a[j+1][1])
				{
					temp=a[j+1][1];
					a[j+1][1]=a[j][1];
					a[j][1]=temp;
					
					temp=a[j+1][0];
					a[j+1][0]=a[j][0];
					a[j][0]=temp;
					
				}
			}
		}
		
	}
	
	
	
	//二维快速排序
	public static void quickSort2(int a[][],int start,int end)
	{
		int i=start;
		int j=end;
		int mark=end;
		int temp;
		
		if(i>=j)return;
		
		while(i<j)
		{
			while(i<j && a[i][1]<=a[mark][1])i++;
			
			temp=a[i][1];
			a[i][1]=a[mark][1];
			a[mark][1]=temp;
			
			temp=a[i][0];
			a[i][0]=a[mark][0];
			a[mark][0]=temp;
			
			
			mark=i;
			
			
			while(i<j && a[j][1]>=a[mark][1])j--;
			
			temp=a[j][1];
			a[j][1]=a[mark][1];
			a[mark][1]=temp;
			
			temp=a[j][0];
			a[j][0]=a[mark][0];
			a[mark][0]=temp;
			
			mark=j;
			
			quickSort2(a,start,mark-1);
			quickSort2(a,mark+1,end);
		}
		
	
		
		
	}
	
	//一维快速排序
	public static void quickSort(int a[],int start,int end)
	{
		int i=start;
		int j=end;
		int mark=end;
		int temp;
		
		if(i>=j)return;
		
		while(i<j)
		{
			while(i<j && a[i]<=a[mark])i++;
			
			temp=a[i];
			a[i]=a[mark];
			a[mark]=temp;
			
			mark=i;
			
			
			while(i<j && a[j]>=a[mark])j--;
			
			temp=a[j];
			a[j]=a[mark];
			a[mark]=temp;
			
			mark=j;
			
			quickSort(a,start,mark-1);
			quickSort(a,mark+1,end);
		}
		
	
		
		
	}
	
	
	//选择排序
	public static void SelectSort(int a[])
	{
		int tem=0;
		for(int i=0;i<a.length;i++)
	     {
	    	 for(int j=0;j<a.length;j++)
	    	 {
	    		 
	    		 
				if (a[i]>=a[j])
				{
	    			 tem=a[i];
	    		     a[i]=a[j];
	    		     a[j]=tem;
				}
	    		   
				
	    	 }
	        
	     }
		
	
	}
	
	
	// 冒泡排序
	public static void PopSort(int a[])
	{
		
		int temp;
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length-i-1;j++)
			{
				if(a[j]>a[j+1])
				{
					temp=a[j+1];
					a[j+1]=a[j];
					a[j]=temp;
				}
			}
		}
	}
	
	
	
	public static void main(String[] args) 
	{
		
		
		//System.out.println(2^3);
		
		int []a={2,3,4,5,6,5,4,3,2,45,69,96,6,45,96};
		
		int [][] test={{1,3},{2,5},{3,4},{4,9},{5,2},{6,1},{7,12},{8,3},{9,5},{10,7}};
		
		System.out.println(test.length);
		
		PopSort(a);
		//PopSort2(test);
		quickSort2(test,0,test.length-1);
		
		for(int e:a)
		{
			System.out.print(e+" ");
		}
		System.out.println();
		
		System.out.println("-----------------------");
	
		for(int [] t:test)
		{
			
			for(int e:t){
				System.out.print(e+" ");
			}
			System.out.println();
		}
		
	}

}

