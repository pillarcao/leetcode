
import java.util.Scanner;

/**
 * ĳ�ξۻᣬ�λ���Ա����ΪN(50<=N<=1000)���ֱ�������1��N��ʾ������Ա���ۻ���ԱҪ�ֳ�С�飬ÿС���������ܳ���M��3<=M<=50����
 * ����ÿС�����������ÿ�����������ѹ�ϵ������1������һλN��ͬһ�飬����1��N�������ѹ�ϵ������1�ͱ������������ˣ�
 * ��ͨ�����������Լ������ѹ�ϵ�����հ�N���뵽�Լ���С�����֪���λ�����N��С���������M�����ѹ�ϵͼ�����£���
 * ��1�ҵ�N����С·��������ﵽС������Ŷ�����ʱ�������ҵ�N���򷵻�-1��

 

�������ѹ�ϵ��

1-3         3-6         5-1

5-4         4-3         5-2

4-2         2-6         4-6

���룺

��������T

�ۻ�����N  С���Ŷ��������M  ���ѹ�ϵ��K

���ѹ�ϵ1

���ѹ�ϵ2.

. . . . .

���ѹ�ϵK

 

�����

#��ǰ��������  ������������ 

 

����

 

���룺

2

6 3 9

1 3

3 6

5 1

5 4

4 3

5 2

4 2

2 6

4 6

6 2 9

1 3

3 6

5 1

5 4

4 3

5 2

4 2

2 6

4 6

 

�����

#1 3

#2 -1


 *
 */


public class FindFriend {



		static int answer = 0;
		
		//�������·��
		public static int [][] getShorWay(int [][] a, int n)
		{
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					for(int k=0;k<n;k++)
					{
						if(a[i][j]>a[i][k]+a[k][j])
							a[i][j]=a[i][k]+a[k][j];
						
					}
			
			
			return a;
		}

		public static void main(String args[]) throws Exception {
			//�ӱ�׼����System.in ɨ��֮���ȡ����
			Scanner sc = new Scanner(System.in);
			
			int T=sc.nextInt();
			
			for(int test_case = 1 ;test_case <= T ; ++test_case)

	      	//////////////////////////////////////////////////
	      	//
			//   �˲�����Ӿ�����㷨�� 
	        //   ������Ѿ����浽 answer. 
			//
	      	//////////////////////////////////////////////////
			{
				
				
				
				
				//�ۻ�����
				int n=sc.nextInt();
				
				//�ۻ���Ա�Ĺ�ϵ��Ĭ�������
				int MAX=1000;
				
				//��ʾ��Ա��ϵ������
				int a[][]=new int[n][n];
				
				for(int i=0;i<n;i++)
					for(int j=0;j<n;j++)
					{
						a[i][j]=MAX;
					}
				
				//�������������
				int countLimit=sc.nextInt();
				
				//�����ϵ��
				int r=sc.nextInt();
				
				for(int i=0;i<r;i++)
				{
					int x=sc.nextInt();
					int y=sc.nextInt();
					a[x-1][y-1]=1;
					
				}
				
				
		        // �������·��
				int d[][]=getShorWay(a,n);
				
				//������·�д������������ ���� -1��else ����������
				if((d[0][n-1]+1)>countLimit)answer=-1;
				else answer= d[0][n-1]+1;
				
				// ͨ����׼��������棩����𰸡� 
		      	System.out.println(answer);
			}
			
			
	      	
	      	
	    }
	
	
}



