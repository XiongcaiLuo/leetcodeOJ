package tree;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 */
public class BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return height(root) >= 0;
	}
    
	/**
	 * 利用 -1表示子树不平衡，从而提前结束。
	 * @param root
	 * @return
	 */
	private int height(TreeNode root) {
		if (root == null)
			return 0;
		int left = height(root.left);
		int right = height(root.right);
		if (left < 0 || right < 0 || Math.abs(left - right) > 1)
			return -1;
		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
