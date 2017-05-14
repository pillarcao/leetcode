
import java.util.Scanner;

/**
 * 某次聚会，参会人员总数为N(50<=N<=1000)，分别用数字1到N表示所有人员。聚会人员要分成小组，每小组人数不能超过M（3<=M<=50），
 * 并且每小组里的人至少每两个人是朋友关系，现在1想和最后一位N在同一组，但是1和N不是朋友关系。所以1就必须邀请其他人，
 * 再通过其他人找自己的朋友关系，最终把N邀请到自己的小组里。已知：参会人数N、小组人数最多M、朋友关系图（如下）。
 * 问1找到N的最小路径，如果达到小组最大团队人数时还不能找到N，则返回-1。

 

举例朋友关系：

1-3         3-6         5-1

5-4         4-3         5-2

4-2         2-6         4-6

输入：

测试用例T

聚会人数N  小组团队最大人数M  朋友关系数K

朋友关系1

朋友关系2.

. . . . .

朋友关系K

 

输出：

#当前测试用例  组内最少人数 

 

例：

 

输入：

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

 

输出：

#1 3

#2 -1


 *
 */


public class FindFriend {



		static int answer = 0;
		
		//计算最短路径
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
			//从标准输入System.in 扫描之后获取数据
			Scanner sc = new Scanner(System.in);
			
			int T=sc.nextInt();
			
			for(int test_case = 1 ;test_case <= T ; ++test_case)

	      	//////////////////////////////////////////////////
	      	//
			//   此部分添加具体的算法。 
	        //   假设答案已经保存到 answer. 
			//
	      	//////////////////////////////////////////////////
			{
				
				
				
				
				//聚会人数
				int n=sc.nextInt();
				
				//聚会人员的关系（默认无穷大）
				int MAX=1000;
				
				//表示人员关系的数组
				int a[][]=new int[n][n];
				
				for(int i=0;i<n;i++)
					for(int j=0;j<n;j++)
					{
						a[i][j]=MAX;
					}
				
				//最大团限制条件
				int countLimit=sc.nextInt();
				
				//输入关系数
				int r=sc.nextInt();
				
				for(int i=0;i<r;i++)
				{
					int x=sc.nextInt();
					int y=sc.nextInt();
					a[x-1][y-1]=1;
					
				}
				
				
		        // 计算最短路径
				int d[][]=getShorWay(a,n);
				
				//如果最短路中大于最大组团数 返回 -1，else 返回组团数
				if((d[0][n-1]+1)>countLimit)answer=-1;
				else answer= d[0][n-1]+1;
				
				// 通过标准输出（画面）输出答案。 
		      	System.out.println(answer);
			}
			
			
	      	
	      	
	    }
	
	
}



