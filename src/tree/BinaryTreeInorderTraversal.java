package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

	/**
	 * @param args
	 */
    public List<Integer> inorderTraversal(TreeNode root) {
    	ArrayList<Integer> orders=new ArrayList<Integer>();
    	if(root==null) return orders;
    	Stack<TreeNode> stack=new Stack<TreeNode>();
    	TreeNode ptr = root;
    	while ( !stack.isEmpty() || ptr != null){
    		if (ptr != null){
    			stack.push(ptr);
    			ptr = ptr.left;
    		} else {
    			ptr = stack.pop();
    			orders.add(ptr.val);
    			ptr = ptr.right;
    		}
    	}
    	return orders;
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
