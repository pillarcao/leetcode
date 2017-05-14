
/**
 * <问题描述>
 * 定义字符串的左旋转操作：把字符串前面的若干个字符移动到字符串的尾部。   如把字符串abcdef左旋转2位
 * 得到字符串cdefab。请实现字符串左旋转的函数，要求对长度为n的字符串操作的时间复杂度为O(n)，
 * 空间复杂度为O(1)。
 */
public class StringReverse
{
    /**
     * 
     * <字符串逆序>
     * @param src 
     * @param begin 起始位置
     * @param end   结束位置
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
     * <字符串左旋转>
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
     * <字符串右旋转>
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
        System.out.println("------------------------左旋转2位");
       
        char[] left =  StringReverse.shiftLeft(src.toCharArray(), 2);
        char[] right =  StringReverse.shiftRight(src.toCharArray(), 2);
        for(char c:left)
        {
           System.out.print("["+c+"]");
        }
      System.out.println();
      System.out.println("------------------------右旋转2位");
      for(char c:right)
      {
          System.out.print("["+c+"]");
      }
    }
}
