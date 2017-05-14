public class BinarySearch 
{
	public static void main(String args[])
	{
	int a[]={1,2,3,4,5,6,7,8,9,10};
	int index=BinarySearch.binarySearch(a, 0, a.length, 10);
	System.out.println(index);
	}
	/* <二分查找算法>
	 * @author caolizhu
	 * @param a[]   要查找的序列
	 * @param start 查找范围的起始索引
	 * @param end   查找范围的结束索引
	 * @param value 要查找的值
	 * @return 元素在序列中的索引位置，失败返回：-1
	 */
	public static int binarySearch(int a[], int start, int end, int value) 
	{
		//如果没找到元素返回-1
		if(start>=end)
		{
			return -1;
		}
		
		//通过二分法递归查找需要寻找的元素
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