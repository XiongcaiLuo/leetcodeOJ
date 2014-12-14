package tree;

public class BinaryTreeMaximumPathSum {

	/**
	 * Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
	 * @param args
	 */
	public int max_sum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
    	if(root==null) return 0;
    	getNodeMax(root);
    	return max_sum;

    }
    public int getNodeMax(TreeNode root){
        if(root==null) return 0;
        int left=maxPathSum(root.left);
        int right=maxPathSum(root.right);
        int sum=root.val;
        if(left>0)
        	sum+=left;
        if(right>0)
        	sum+=right;
        max_sum=Math.max(max_sum, sum);
        int max=Math.max(left, right);
        return max>0?max+root.val:root.val;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
