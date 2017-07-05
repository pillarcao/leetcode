import java.util.ArrayList;

/**
 * 
 * ���� n = 3, �����ɵ��������:

   "((()))", "(()())", "(())()", "()(())", "()()()"
 *
 */


public class GeneratorBrackets 
{

    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public static ArrayList<String> generateParenthesis(int n) {
    	
    	ArrayList<String> ret=new ArrayList();
    	String tem="";
    	
    	generateParenthesis(n,0,0,tem,ret);
    	
		return ret;
        // Write your code here
    }
    
    
    public static void generateParenthesis(int n, int left,int right,String tem,ArrayList<String> ret)
    {
    	
    	//�ҵ�һ���⣬�浽lst
    	if(left==right && left==n && right==n) 
    	{
    		ret.add(tem);
    	    return;
    	}
    	
    	//���ɵ����Ų������������ݹ����
    	if(left>n || right>n || left<right ) return;
    	
    	
    	//���еĿ��ܵĽ��
    	generateParenthesis( n,  left+1, right, tem+"(",ret);
    	generateParenthesis( n,  left, right+1, tem+")",ret);
    	
    
    }
    
    
    public static void main(String[] args) {
    	ArrayList<String> ret=generateParenthesis(1);
    	if(ret!=null)
    	{
    		for(String s:ret)
    		System.out.println(s);
    	}
	}
	
}
