import java.util.ArrayList;
import java.util.List;

public class PrintNumber {
	
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        List <Integer> result=new ArrayList<Integer>();
        
        if(n<1){return result;}
        else
        {
            print(1,n,result);
        }
        
        return result;
    }
    
    
    public void print(int i,int n,List <Integer> result)
    {
        if(n >= 1)
        {
        
        int max=i * 10;
        for(int j=i;j<max;j++)
        {
          result.add(j)  ;
        }
        
         print(max,n-1,result);
        
        }
    }


}
