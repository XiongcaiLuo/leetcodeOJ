package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
1
\
 2
/
3
return [1,2,3].
 * @param args
 */
public class BinaryTreePreorderTraversal {


    /**
     * use stack
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
    	ArrayList<Integer> orders=new ArrayList<Integer>();
    	if(root==null) return orders;
    	Stack<TreeNode> nodes=new Stack<TreeNode>();
    	nodes.add(root);
    	while (!nodes.isEmpty()) {
    		TreeNode dealing = nodes.pop();
    		orders.add(dealing.val);
    		if (dealing.right != null) {
    			nodes.push(dealing.right);
    		}
    		if (dealing.left != null) {
    			nodes.push(dealing.left);
    		}
    	}
    	return orders;
    }
    
    /**
     * 
     * @param root
     * @return
     */
	public List<Integer> preorderTraversal3(TreeNode root) {
		ArrayList<Integer> orders = new ArrayList<Integer>();
		TreeNode p = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				orders.add(p.val);
				stack.push(p);
				p = p.left;
			} else if (stack.peek().right != null) {
				p = stack.peek().right;
			} else { // leaf node
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
		return orders;
	}
    /**
     * http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
     * morris遍历
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {
    	ArrayList<Integer> orders=new ArrayList<Integer>();
    	TreeNode p = root;
    	while ( p != null){
    		if (p.left == null){
    			orders.add(p.val);
    			p = p.right;
    		} else{
    			TreeNode q = p.left;
    			while (q.right != null && q.right != p) q = q.right;     // be careful  q.right != p
    			if (q.right == null){
    				orders.add(p.val);
    				q.right = p;
    				p = p.left;
    			} else {
    				q.right = null;
    				p = p.right;
    			}
    		}
    	}
    	return orders;
    }
    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		root.right = n2;
		n2.left = n3;
		for (int i : preorderTraversal(root)){
			System.out.println(i);
		}
		
	}

}
