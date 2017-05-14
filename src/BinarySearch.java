public class BinarySearch 
{
	public static void main(String args[])
	{
	int a[]={1,2,3,4,5,6,7,8,9,10};
	int index=BinarySearch.binarySearch(a, 0, a.length, 10);
	System.out.println(index);
	}
	/* <���ֲ����㷨>
	 * @author caolizhu
	 * @param a[]   Ҫ���ҵ�����
	 * @param start ���ҷ�Χ����ʼ����
	 * @param end   ���ҷ�Χ�Ľ�������
	 * @param value Ҫ���ҵ�ֵ
	 * @return Ԫ���������е�����λ�ã�ʧ�ܷ��أ�-1
	 */
	public static int binarySearch(int a[], int start, int end, int value) 
	{
		//���û�ҵ�Ԫ�ط���-1
		if(start>=end)
		{
			return -1;
		}
		
		//ͨ�����ַ��ݹ������ҪѰ�ҵ�Ԫ��
		int middle = (start + end) / 2;
		if (a[middle] == value) 
		{
			return middle;
		} 
		else if (a[middle] > value)
		{		
				
			return binarySearch(a,start,middle-1,value);
		}
		else 
		{
			return binarySearch(a,middle+1,end,value);
		}

	}
}