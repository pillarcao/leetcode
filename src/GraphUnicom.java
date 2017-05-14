
/**
 * 
 * @author lizhu.cao
 * @since 2016-7-10
 * <br>
 * 求图的连通性（通过floyd 算法求得除过考察点最短路径的邻接矩阵，如果任意i，j（不包括考察点）的最短路〉MAX，说明图不联通 ）
 */
public class GraphUnicom {

	private static final int MAX = 10;

	
	public static int [][] cloneArr(int a[][])
	{
		int [][] clone=new int[a.length][a.length];
		for (int i = 0; i < clone.length ; i++) {
			for (int j = 0; j < clone.length ; j++) 
			{
				clone[i][j]=a[i][j];
			}
			
		}

		
		return clone;
	}

	public static void GetGraphUnicomV(int g[][]) {
		for (int i = 0; i < g.length; i++) {
			
			if(GraphUnicom.IsGraphUnicom(i,g))System.out.println(i);

		}

	}

	/**
	 * 
	 * @param v 当前考察的点
	 * @param g 图的初始邻界矩阵
	 * @return 是否是关键节点（关键节点删除后会导致图不联通）
	 */
	
	public static boolean IsGraphUnicom(int v,int g[][]) {
		boolean result = false;
		int[][] t = cloneArr(g);
		for (int i = 0; i < t.length; i++) {
			if(i==v)continue;	
			for (int j = 0; j < t.length; j++) {
//				System.out.print(g[i][j] + ",");
				if(j==v)continue;				
				for (int k = 0; k < t.length; k++) {
					if(k==v)continue;
					if (t[i][k] + t[k][j] < t[i][j]) {
						t[i][j] = t[i][k] + t[k][j];
					}

				}

			}
//			System.out.println();
		}

		for (int i = 0; i < t.length ; i++) {
			for (int j = 0; j < t.length ; j++) {
				if(v==i || j==v)continue;
				if(t[i][j]>=MAX)result=true;
//				System.out.print(t[i][j] + ",");
			}
//			System.out.println();
		}

		return result;
	}

	public static void main(String[] args) {
		int a[][] = { { 0, 1, MAX, MAX, MAX, MAX }, { 1, 0, 1, 1, MAX, MAX },
				{ MAX, 1, 0, MAX, 1, MAX }, { MAX, 1, MAX, 0, 1, MAX },
				{ MAX, MAX, 1, 1, 0, 1 }, { MAX, MAX, MAX, MAX, 1, 0 } };
		
		
		
		int b[][] = { { 0, 1, 1, MAX, MAX, 1 }, { 1, 0, 1, 1, 1, MAX },
				{ 1, 1, 0, 1, MAX, MAX }, { MAX, 1, 1, 0, 1, MAX },
				{ MAX, 1, MAX, 1, 0, MAX }, { 1, MAX, MAX, MAX, MAX, 0 } };
		

		
		    
		    
			for(int n=0;n<6;n++)
			{
				System.out.println("city: "+n+ " is core city? "+IsGraphUnicom(n,b));
			   // System.out.println(n);
              // System.out.println(GraphUnicom.IsGraphUnicom(n,a));
			}
		
	}	
}
