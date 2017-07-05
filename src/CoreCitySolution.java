
/**
 * 
 * @author lizhu.cao
 * @since 2016-7-10
 * <br>
 * ��ͼ����ͨ�ԣ�ͨ��floyd �㷨��ó�����������·�����ڽӾ����������i��j������������㣩�����·��MAX��˵��ͼ����ͨ ��
 */
public class CoreCitySolution {

	private static final int MAX = 10;

	public static void GetGraphUnicomV(int g[][]) {
		for (int i = 0; i < g.length; i++) {
			
			if(Floyed(i,g))System.out.println(i);

		}

	}

	/**
	 * 
	 * @param v ��ǰ����ĵ�
	 * @param g ͼ�ĳ�ʼ�ڽ����
	 * @return �Ƿ��ǹؼ��ڵ㣨�ؼ��ڵ�ɾ����ᵼ��ͼ����ͨ��
	 */
	
	public static boolean Floyed(int v,int g[][]) {
		boolean result = false;
		for (int i = 0; i < g.length; i++) {
			if(i==v)continue;	
			for (int j = 0; j < g.length; j++) {
//				System.out.print(g[i][j] + ",");
				if(j==v)continue;				
				for (int k = 0; k < g.length; k++) {
					if(k==v)continue;
					if (g[i][k] + g[k][j] < g[i][j]) {
						g[i][j] = g[i][k] + g[k][j];
					}

				}

			}
//			System.out.println();
		}

		for (int i = 0; i < g.length ; i++) {
			for (int j = 0; j < g.length ; j++) {
				if(v==i || j==v)continue;
				if(g[i][j]>=MAX)result=true;
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
				System.out.println("city: "+n+ " is core city? "+Floyed(n,b));
			   // System.out.println(n);
              // System.out.println(GraphUnicom.IsGraphUnicom(n,a));
			}
		
	}	
}
