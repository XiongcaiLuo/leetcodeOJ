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
