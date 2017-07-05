import java.util.ArrayList;
import java.util.LinkedList;

public class Solution1 {
	
	
	

	 public class TreeNode {
	      public int val;
	      public TreeNode left, right;
	      public TreeNode(int val) {
	          this.val = val;
	          this.left = this.right = null;
	      }
	  }
	 

	    /**
	     * @param root: The root of binary tree.
	     * @return: Level order a list of lists of integer
	     */
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (root == null) return result;
	

			LinkedList<TreeNode> q = new LinkedList<TreeNode>();
			q.offer(root);

			while (!q.isEmpty()) {

				ArrayList<Integer> layerlst = new ArrayList<Integer>();
				for (int i = 0; i < q.size(); i++) {

					layerlst.add(q.poll().val);
					if (root.left != null)
						q.offer(root.left);
					if (root.right != null)
						q.offer(root.right);
				}

				result.add(layerlst);
			}

		

		return result;

	}
}