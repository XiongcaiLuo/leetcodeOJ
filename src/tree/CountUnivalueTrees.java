package tree;

/**
 * Given a binary tree, count the number of uni-value subtrees.
 * 
 * A Uni-value subtree means all nodes of the subtree have the same value.
 * 
 * @author luoxiongcai
 *
 */
public class CountUnivalueTrees {
	private int count = 0;
	public int countUnivalSubtrees(TreeNode root){
		count(root);
		return count;
	}
	
	private boolean count(TreeNode root){
		if (root == null) return true;
		boolean left = count(root.left);
		boolean right = count(root.right);
		if (!left || !right) return false;
		boolean flag = true;
		flag &=(root.left == null ? true : root.left.val == root.val);
		flag &=(root.right == null ? true : root.right.val == root.val);
		if (flag) count++;
		return flag;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
