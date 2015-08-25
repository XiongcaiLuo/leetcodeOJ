package tree;

import java.util.Stack;

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
public class SymmetricTree {

	/**
	 * recursion
	 * @param root
	 * @return
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
	/**
	 * iteration
	 * @param root
	 * @return
	 */
	public boolean isSymmetric2(TreeNode root) {
 		if (root == null) return true;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root.left);
		stack.push(root.right);
		while (!stack.isEmpty()){
			TreeNode p = stack.pop();
			TreeNode q = stack.pop();
			if (p == null && q == null) continue;
			if (p == null || q == null ) return false;
			if ( p.val != q.val) return false;
			stack.push(p.left);
			stack.push(q.right);
			stack.push(p.right);
			stack.push(q.left);
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
