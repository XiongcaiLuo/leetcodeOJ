package tree;

import java.util.Stack;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value.
 * 
 * @param args
 */
public class SameTree {

	/**
	 * recursion
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		else if ((p != null && q == null) || (p == null && q != null))
			return false;
		boolean f1 = isSameTree(p.left, q.left);
		boolean f2 = isSameTree(p.right, q.right);
		if (p.val == q.val && f1 && f2)
			return true;
		else
			return false;
	}
	
	public boolean isSameTree2(TreeNode p, TreeNode q) {
		Stack<TreeNode> ps = new Stack<TreeNode>();
		Stack<TreeNode> qs = new Stack<TreeNode>();
		ps.add(p);
		qs.add(q);
		while (!ps.isEmpty() && !qs.isEmpty()){
			TreeNode curp = ps.pop();
			TreeNode curq = qs.pop();
			if (curp == null || curq == null) continue;
			if ((curp != null && curq == null) || (curp == null && curq != null) || curp.val != curq.val) 
				return false;
			ps.add(curp.left);
			ps.add(curp.right);
			qs.add(curq.left);
			qs.add(curq.right);
		}
		return true;
	}

	public static void main(String[] args) {

	}

}
