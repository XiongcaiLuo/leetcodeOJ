package tree;

/**
 * Given a binary tree, find the maximum path sum.
 * 
 * The path may start and end at any node in the tree.
 * 
 * For example: Given the below binary tree,
 * 
 * 1 / \ 2 3 Return 6.
 * what if the max_sum is smaller than 0? you should return 0;
 * whenever dealing with 'maximum', be careful about negative numbers.
 * @param args
 */
public class BinaryTreeMaximumPathSum {

	public int max_sum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		getOneSideMax(root);
		return max_sum;
	}

	public int getOneSideMax(TreeNode root) {
		if (root == null)
			return 0;
		int left = getOneSideMax(root.left);
		int right = getOneSideMax(root.right);
		int sum = root.val;
		if (left > 0)
			sum += left;
		if (right > 0)
			sum += right;
		max_sum = Math.max(max_sum, sum);
		int oneSideMax = Math.max(left,right);
		return oneSideMax > 0 ? oneSideMax + root.val : root.val;
	}
	
	/**
	 * a trick method: when oneMax is negative, then return 0!!!
	 * @param root
	 * @return
	 */
	public int getOneSideMax2(TreeNode root){
		if (root == null)
			return 0;
		int left = getOneSideMax2(root.left);
		int right = getOneSideMax2(root.right);
		max_sum = Math.max(root.val + left + right , max_sum);
		int oneMax = Math.max(left, right) + root.val;
		return oneMax > 0 ? oneMax : 0 ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
