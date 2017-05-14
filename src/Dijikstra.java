
/**
 * <br>
 * @author clz
 * @since  2013-1-29
 * 
 */
public class Dijikstra
{
    /**
     * ���Ȩֵ
     */
    public final static int MAX = 99999;
    
    /**
     * ����Ľ���
     */
    public final static int N =100;
/**
 * 
 * <�������·��������·��>
 * @author clz
 * @param prev[] ���·���е�ǰһ���¼����
 * @param start  Դ�ڵ�
 * @param end    Ŀ��ڵ�
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
        
        System.out.println("���·��Ϊ��");
        
        for (int i = tot; i >0; i--)
        {
            System.out.print(que[i]+"->>");
        }
        
    }
    /**
     * 
     * <��dijikstra�㷨���㵥Դ���·��>
     * @param graph[][] �洢ͼ������
     * @param start
     * @param end
     * @return  ���·������
     */
    public static int dijikstra(int[][] graph, int start, int end)
    {
        int length = graph.length;
        // �����Դ�������������̾���"0"��ʾδ��ǣ�"1"��ʾ���
        int dis[] = new int[length];
        // ��ʾ��ǰ��i��Ԫ���Ƿ���
        int sign[] = new int[length];
        int min;
        // ����¼���������Ԫ��
        int mark;

        // �����Դ����ǰ��i���������·���е��м��
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
        // ���Դ��Ϊ�Կ���ĵ�
        sign[start] = 1;
        // ����ʣ�����
        for (int i = 1; i < length; i++)
        {
            mark = -1;
            min = MAX;

            // ȡ����Դ�����������о�����С�Ķ��㣬�����Ϊ���춥��
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
                // ��ǵ�ǰ��Դ�����нڵ���·����С�ڵ�ļ����Ƕ���
                sign[mark] = 1;
                checkNode[i]=mark;

                // ˢ�´�Դ��δ��ǵĶ����Ȩֵ���Ե�ǰ�����Ϊ�м�ڵ�
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
        
        //������·�������Ľڵ�
        searchPath(prev, start, end);
        System.out.println();
        System.out.println("����Ϊ��"+dis[end]);
        return dis[end];
    }

    public static void main(String[] args)
    {
        
        //����ͼ����
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
