package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

	/**
	 * use a stack. accepted
	 * 
	 * @param args
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> orders = new ArrayList<Integer>();
		TreeNode p = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else if (stack.peek().right != null) {
				p = stack.peek().right;
			} else { // leaf node
				p = stack.pop();
				orders.add(p.val);
				while (!stack.isEmpty() && p == stack.peek().right) { // right leaf node, pop the parent.
					p = stack.pop();
					orders.add(p.val);
				}
				if (!stack.isEmpty())
					p = stack.peek().right;
				else
					p = null;
			}
		}
		return orders;
	}
	
	public int height(TreeNode root){
		if (root == null) return -1;
		TreeNode p = root;
		int height = 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else if (stack.peek().right != null) {
				p = stack.peek().right;
			} else { // leaf node
				height = Math.max(stack.size()-1, height);
				p = stack.pop();
				while (!stack.isEmpty() && p == stack.peek().right) { // right leaf node, pop the parent.
					p = stack.pop();
				}
				if (!stack.isEmpty())
					p = stack.peek().right;
				else
					p = null;
			}
		}
		return height;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
