
/**
 * <��������>
 * �����ַ���������ת���������ַ���ǰ������ɸ��ַ��ƶ����ַ�����β����   ����ַ���abcdef����ת2λ
 * �õ��ַ���cdefab����ʵ���ַ�������ת�ĺ�����Ҫ��Գ���Ϊn���ַ���������ʱ�临�Ӷ�ΪO(n)��
 * �ռ临�Ӷ�ΪO(1)��
 */
public class StringReverse
{
    /**
     * 
     * <�ַ�������>
     * @param src 
     * @param begin ��ʼλ��
     * @param end   ����λ��
     * @return
     */
    public static char[] reverse(char src[],int begin,int end)
    {
        char temp;
        while(begin < end)
        {
            temp=src[begin];
            src[begin]=src[end];
            src[end]=temp;
            begin++;
            end--;
        }
        
        return src;
    }
    
    /**
     * <�ַ�������ת>
     * @param src
     * @param k
     * @return
     */
    public static char[] shiftLeft(char []src,int k)
    {
        reverse(src,0,k-1);
        reverse(src,k,src.length-1);
        reverse(src,0,src.length-1);
        return src;
    }
    
    /**
     * <�ַ�������ת>
     * @param src
     * @param k
     * @return 
     */
    public static char[] shiftRight(char []src,int k)
    {
        reverse(src,0,src.length-1-k);
        reverse(src,src.length-k,src.length-1);
        reverse(src,0,src.length-1);
        return src;
    }
    
    public static void main(String[] args)
    {
        String src="abcdefg";
        for(char c:src.toCharArray())
        {
           System.out.print("["+c+"]");
        }
        System.out.println();
        System.out.println("------------------------����ת2λ");
       
        char[] left =  StringReverse.shiftLeft(src.toCharArray(), 2);
        char[] right =  StringReverse.shiftRight(src.toCharArray(), 2);
        for(char c:left)
        {
           System.out.print("["+c+"]");
        }
      System.out.println();
      System.out.println("------------------------����ת2λ");
      for(char c:right)
      {
          System.out.print("["+c+"]");
      }
    }
}
