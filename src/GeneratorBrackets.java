import java.util.ArrayList;

/**
 * 
 * 给定 n = 3, 可生成的组合如下:

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
    	
    	//找到一个解，存到lst
    	if(left==right && left==n && right==n) 
    	{
    		ret.add(tem);
    	    return;
    	}
    	
    	//生成的括号不满足条件，递归结束
    	if(left>n || right>n || left<right ) return;
    	
    	
    	//所有的可能的结果
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
