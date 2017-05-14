public class QuickSort
{
public static void main(String args[])
{
	int a[]={27,43,62,12,14,22,16,88,75,42,3,5,2 , 3,  5,  4 , 6, 9 ,83 ,4, 7, 10};
	QuickSort.quickSort(a, 0, 21);
}
public static void  quickSort(int a[],int start,int end)
{
	int i=start;
	int j=end;
	
	//标记关键元素
	int mark=end;
	int temp=0;
	
	if(i>j)return;
	
	while(i<j)
	{
		while(i<j && a[i]<=a[mark])i++;
		//交换两元素的位置
		temp=a[i];
		a[i]=a[mark];
		a[mark]=temp;
		//交换后重新标记关键元素的位置
		mark=i;
		
		while(i<j && a[j]>=a[mark])j--;
		//交换两元素的位置
		temp=a[j];
		a[j]=a[mark];
		a[mark]=temp;
		//交换后重新标记关键元素的位置
		mark=j;
		
	}

	System.out.println("一次快排结果");
	for(int e:a)
	{    
		
		System.out.print(e+" ");
		
	}
	
	//递归调用
	if(mark-1>=start)
	{
		quickSort(a,start,mark-1);
	}

	
	if(mark+1<=end)
	{
		quickSort(a,mark+1,end);
	}
	
}
}