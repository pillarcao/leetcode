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
	
	//��ǹؼ�Ԫ��
	int mark=end;
	int temp=0;
	
	if(i>j)return;
	
	while(i<j)
	{
		while(i<j && a[i]<=a[mark])i++;
		//������Ԫ�ص�λ��
		temp=a[i];
		a[i]=a[mark];
		a[mark]=temp;
		//���������±�ǹؼ�Ԫ�ص�λ��
		mark=i;
		
		while(i<j && a[j]>=a[mark])j--;
		//������Ԫ�ص�λ��
		temp=a[j];
		a[j]=a[mark];
		a[mark]=temp;
		//���������±�ǹؼ�Ԫ�ص�λ��
		mark=j;
		
	}

	System.out.println("һ�ο��Ž��");
	for(int e:a)
	{    
		
		System.out.print(e+" ");
		
	}
	
	//�ݹ����
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