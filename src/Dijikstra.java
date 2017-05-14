
/**
 * <br>
 * @author clz
 * @since  2013-1-29
 * 
 */
public class Dijikstra
{
    /**
     * 最大权值
     */
    public final static int MAX = 99999;
    
    /**
     * 矩阵的阶数
     */
    public final static int N =100;
/**
 * 
 * <搜索最短路所经过的路径>
 * @author clz
 * @param prev[] 最短路径中的前一点记录数组
 * @param start  源节点
 * @param end    目标节点
 */
    public static void searchPath(int prev[],int start,int end)
    {
        int temp;
        int que[]=new int[N];
        int tot=1;
        que[tot++]=end;
        temp=prev[end];
        while(temp!=start)
        {
            que[tot++]=temp;
            temp=prev[temp];
            
        }
        que[tot]=start;
        
        System.out.println("最短路径为：");
        
        for (int i = tot; i >0; i--)
        {
            System.out.print(que[i]+"->>");
        }
        
    }
    /**
     * 
     * <用dijikstra算法计算单源最短路径>
     * @param graph[][] 存储图的数组
     * @param start
     * @param end
     * @return  最短路径长度
     */
    public static int dijikstra(int[][] graph, int start, int end)
    {
        int length = graph.length;
        // 缓存从源到各个顶点的最短距离"0"表示未标记，"1"表示标记
        int dis[] = new int[length];
        // 表示当前第i个元素是否标记
        int sign[] = new int[length];
        int min;
        // 标记新加入待考察的元素
        int mark;

        // 缓存从源到当前第i各顶点最短路径中的中间点
        int prev[] = new int[length];
        int checkNode[] = new int[length];
        for (int i = 0; i < length; i++)
        {
            if(dis[i]==MAX)  
                prev[i]=0;   
            else
                prev[i]=start;
        }

        for (int i = 0; i < length; i++)
        {
            dis[i] = graph[start][i];
            sign[i] = 0;
        }
        // 标记源点为以考察的点
        sign[start] = 1;
        // 考察剩余各点
        for (int i = 1; i < length; i++)
        {
            mark = -1;
            min = MAX;

            // 取出从源到各个顶点中距离最小的顶点，并标记为考察顶点
            for (int j = 0; j < length; j++)
            {
                if (sign[j] == 0 && min > dis[j])
                {
                    min = dis[j];
                    mark = j;

                }

            }

            if (-1 != mark)
            {
                // 标记当前从源到所有节点中路径最小节点的加入标记队列
                sign[mark] = 1;
                checkNode[i]=mark;

                // 刷新从源到未标记的顶点的权值，以当前考察点为中间节点
                for (int j = 0; j < length; j++)
                {
                    if (sign[j] == 0 && dis[j] > dis[mark] + graph[mark][j])
                    {
                        dis[j] = dis[mark] + graph[mark][j];
                        prev[j] = mark;
                    }
                }
            }
        }
        
        //输出最短路径经过的节点
        searchPath(prev, start, end);
        System.out.println();
        System.out.println("长度为："+dis[end]);
        return dis[end];
    }

    public static void main(String[] args)
    {
        
        //测试图矩阵
        int a[][] = { 
                      { 0,   3,   1,    4,   MAX, 2,   MAX, MAX }, 
                      { 3,   0,   MAX,  MAX, MAX, 2,   MAX, MAX },
                      { 1,   MAX, 0,    3,   MAX, 8,   MAX, MAX }, 
                      { 4,   MAX, 3,    0,   7,   MAX, MAX, MAX }, 
                      { MAX, MAX, MAX,  7,   0,   3,   2,      5},
                      { MAX, 2,   8,    MAX,  3,   0,   1,   MAX},
                      { MAX, MAX, MAX,  MAX,   2,   1,   0,    4},
                      { MAX, MAX, MAX,  MAX,   5,   MAX,   4,  0},
                };
        
        Dijikstra.dijikstra(a, 0, 7);

    }
}
