
/**
11) 回文
回文是指从前和从后读时均为左右对称的语句。例如 madam, elle, MOM, ZZZZZ 等即为回文。

在本问题中至少三个文字以上的语句看作为回文。即 A、BB 等不能成为回文。 
现在长的字符串中要查找回文。

作为一个例子，请看以下字符串。

A V F S I O A A O I D A G E P L A R F E G R T H T R G E F W X G G H

上面的字符串中共计7个回文。 
蓝色部分有 IOAAOI, OAAO 2个, 红色部分有 FEGRTHTRGEF, EGRTHTRGE, GRTHTRG, RTHTR, THT 5个，绿色部分的 GG 如上所述，不是回文。 

在这7个回文中最长的回文是 FEGRTHTRGEF, 长度为 11。
请以这种方法编辑在字符串中求得长度最长的回文的程序。


[限制条件]
1. 字符串的长度L 为 3 以上 100 以下的整数。
2. 字符串仅可由大写罗马字母(A ~ Z)组成。
3. 回文的长度为3以上。 
**/


import java.util.Scanner;



public class HuiWen {
	
	    
	    static int L, Answer;
	    
	    // 分割字符串
	    public static String getSub(int i,String s,boolean pre)
	    {    	
	    	
	    	if (pre)
	    	{
	    		return s.substring(0, i+1);
	    	}
	    	else
	        return s.substring(i+1, s.length())	;
	    }
	    
	    
	    
	    //反转 字符串 
	    public static String reverse(String s)
	    {
	    	StringBuffer temp=new StringBuffer(s);
	    	
			return temp.reverse().toString();
	   	
	    	
	    }
	    
	    
	    //从头扫描字符串获取最相同字串的最大长度
	    public static int getMaxLen(String s1,String s2)
	    {
	    	
	    	int i=0;
	    	int k=Math.min(s1.length(), s2.length());    	
	    	while(i<k)
	    	{
	    		if(s1.charAt(i)==s2.charAt(i))
	    		i++;
	    		else break;
	    	}
    	    
	    	return i;
	    }
		
	    
	     public static int getResult(String s)
	     {
	    	 
	    	 int maxLen=0;
	    	 
	    	 
	    	 if(null==s||("").equals(s)||s.length()<4)
	    	 {
	    		 System.out.println("Input is invalid,please  input:");
	    		 return -1;
	    	 }
	    	 else
	    	 {
	    		 
	    		 for(int i=2;i<s.length()-2;i++)
	    		 {
	    			 
	    			 
	    			 if (s.charAt(i)==s.charAt(i+1))
	    			 {
	    				 String s1=HuiWen.getSub(i-1,s,true);
	    				 String s2=HuiWen.getSub(i+1,s,false);
	    				 
	    				 s1=HuiWen.reverse(s1);
	    				 
	    				 System.out.println("i="+i+"|"+s.charAt(i));
					     System.out.println(s1);
					     System.out.println(s2);
					     System.out.println("-----------------------------------");
	    				 
	    				 int temp=HuiWen.getMaxLen(s1, s2)+1;
	    				 
	    				 if(temp<3) continue;
	    				 	    				 
	    				 if(temp>maxLen)maxLen=temp;
	    				 
	    				 //System.out.println("i="+i+":"+s1+"|"+s2);
	    			 }
	    			 else
	    			 {
	    				 
	    				 String s1=HuiWen.getSub(i-1,s,true);
	    				 String s2=HuiWen.getSub(i,s,false);
	    				 s1=HuiWen.reverse(s1);
	    				 
	    				 //System.out.println("i="+i+"|"+s.charAt(i)+"----"+ s1+"|"+s2);
	    				 
	    				 System.out.println("i="+i+"|"+s.charAt(i));
					     System.out.println(s1);
					     System.out.println(s2);
					     System.out.println("-----------------------------------");
	    				 
	    				 int temp=HuiWen.getMaxLen(s1, s2)+1;
	    				 
	    				 if(temp<3) continue;
	    				 
	    				 if(temp>maxLen)maxLen=temp;
	    				 
	    			 }
	    		 }
	    		 
	    	 }
	    	 
	    	 
	    	 
	    	 return maxLen;
	     }
	
	
		
		public static void main(String args[]) throws Exception
		{
			
			
			//System.out.println("result:"+Huiwen.getResult("AVFSIOAAOIDAGEPLARFEGRTHTRGEFWXGGH"));
			

			
			
			/*
			以下 Method 调用代码的含义是今后以读取文件来代替标准输入（键盘）。
			但为了计分，提交代码时必须删除 Method 或进行注释处理。
					*/
					//System.setIn(new FileInputStream("C:\\sample_input.txt"));

					String S;

					Scanner sc = new Scanner(System.in);
					int T = sc.nextInt();

					for(int test_case = 1; test_case <= T; test_case++)
					{

						/*
			在标准输入中读取各测试用例。

						*/
						L = sc.nextInt();
						S = sc.next();

						//////////////////////////////////////////////////////////////////////
						/*
			此部分包含各位实现 Algorithm。
			假设各位的正确答案被保存到 Answer 中。
						 */
						/////////////////////////////////////////////////////////////////////
						Answer = HuiWen.getResult(S);

						//( 实现该部分的Algorithm)
						
						//答案输出在标准输出(页面)。
						System.out.println("#"+test_case+" "+Answer);
					}
				}

			
			
			
}





