import java.util.ArrayList;

public class Permutation 
{
	
	public static ArrayList<ArrayList<String>> ret=new ArrayList<ArrayList<String>>();
	
	public static void Fullpermutation(ArrayList<String> pre,ArrayList<String> post)
	{
		//递归退出
		if(post.size()==0)return;
		
		if(post.size()==1)
		{
			pre.add(post.get(0));
			ret.add(pre);
		}
		
		
		
		for (int i = 0; i <post.size(); i++) 
		{
		    //构造入参
			ArrayList<String> pre_n=new ArrayList<String>(pre);
			ArrayList<String> post_n=new ArrayList<String>(post);
			
			String tem=post.get(i);
			
			post_n.remove(tem);
			pre_n.add(tem);
			
			
			
			Fullpermutation(pre_n,post_n);
			
		}
		
	}
	
	
	public static void main(String[] args) {
		ArrayList<String> p=new ArrayList<String>();
		ArrayList<String> n=new ArrayList<String>();
		n.add("1");
		n.add("2");
		n.add("3");
		n.add("4");
		n.add("5");
		n.add("6");
		n.add("7");
		n.add("8");
		n.add("9");

		Fullpermutation(p,n);
		
		for(ArrayList<String> a:ret)
		{
			for(int i=0;i<a.size();i++)
			{
				System.out.print(a.get(i)+" ");
			}
			System.out.println();
		}
		
		
	}

}
