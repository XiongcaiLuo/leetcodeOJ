package tree;

public class PathSum {

	/**
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
	 * @param args
	 */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.left==null && root.right==null){
        	if(root.val==sum)
        		return true;
        	else return false;
        }
        boolean flag_left=false,flag_right=false;
        if(root.left!=null)
        	flag_left=hasPathSum(root.left, sum-root.val);
        if(root.right!=null)
        	flag_right=hasPathSum(root.right, sum-root.val);
        return (flag_left || flag_right);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
