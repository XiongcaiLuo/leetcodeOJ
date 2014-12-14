package tree;

public class SymmetricTree {

	/**
	 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
	 * @param args
	 */
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        else return isSymmetric(root.left,root.right);
    }
	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if(left==null && right==null) return true;
		if(left!=null && right!=null)
			return (left.val==right.val && isSymmetric(left.left,right.right)&& isSymmetric(left.right,right.left));
		else return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
