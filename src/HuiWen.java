
/**
11) ����
������ָ��ǰ�ʹӺ��ʱ��Ϊ���ҶԳƵ���䡣���� madam, elle, MOM, ZZZZZ �ȼ�Ϊ���ġ�

�ڱ����������������������ϵ���俴��Ϊ���ġ��� A��BB �Ȳ��ܳ�Ϊ���ġ� 
���ڳ����ַ�����Ҫ���һ��ġ�

��Ϊһ�����ӣ��뿴�����ַ�����

A V F S I O A A O I D A G E P L A R F E G R T H T R G E F W X G G H

������ַ����й���7�����ġ� 
��ɫ������ IOAAOI, OAAO 2��, ��ɫ������ FEGRTHTRGEF, EGRTHTRGE, GRTHTRG, RTHTR, THT 5������ɫ���ֵ� GG �������������ǻ��ġ� 

����7����������Ļ����� FEGRTHTRGEF, ����Ϊ 11��
�������ַ����༭���ַ�������ó�����Ļ��ĵĳ���


[��������]
1. �ַ����ĳ���L Ϊ 3 ���� 100 ���µ�������
2. �ַ��������ɴ�д������ĸ(A ~ Z)��ɡ�
3. ���ĵĳ���Ϊ3���ϡ� 
**/


import java.util.Scanner;



public class HuiWen {
	
	    
	    static int L, Answer;
	    
	    // �ָ��ַ���
	    public static String getSub(int i,String s,boolean pre)
	    {    	
	    	
	    	if (pre)
	    	{
	    		return s.substring(0, i+1);
	    	}
	    	else
	        return s.substring(i+1, s.length())	;
	    }
	    
	    
	    
	    //��ת �ַ��� 
	    public static String reverse(String s)
	    {
	    	StringBuffer temp=new StringBuffer(s);
	    	
			return temp.reverse().toString();
	   	
	    	
	    }
	    
	    
	    //��ͷɨ���ַ�����ȡ����ͬ�ִ�����󳤶�
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
			���� Method ���ô���ĺ����ǽ���Զ�ȡ�ļ��������׼���루���̣���
			��Ϊ�˼Ʒ֣��ύ����ʱ����ɾ�� Method �����ע�ʹ���
					*/
					//System.setIn(new FileInputStream("C:\\sample_input.txt"));

					String S;

					Scanner sc = new Scanner(System.in);
					int T = sc.nextInt();

					for(int test_case = 1; test_case <= T; test_case++)
					{

						/*
			�ڱ�׼�����ж�ȡ������������

						*/
						L = sc.nextInt();
						S = sc.next();

						//////////////////////////////////////////////////////////////////////
						/*
			�˲��ְ�����λʵ�� Algorithm��
			�����λ����ȷ�𰸱����浽 Answer �С�
						 */
						/////////////////////////////////////////////////////////////////////
						Answer = HuiWen.getResult(S);

						//( ʵ�ָò��ֵ�Algorithm)
						
						//������ڱ�׼���(ҳ��)��
						System.out.println("#"+test_case+" "+Answer);
					}
				}

			
			
			
}





