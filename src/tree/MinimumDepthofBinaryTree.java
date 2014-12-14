package tree;

public class MinimumDepthofBinaryTree {

	/**
	 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
	 * @param args
	 */
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null)
        	return 1+minDepth(root.right);
        else if(root.right==null){
        	return 1+minDepth(root.left);
        }else{
        	int left=minDepth(root.left)+1;
        	int right=minDepth(root.right)+1;
        	return Math.min(left, right);
        }

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
