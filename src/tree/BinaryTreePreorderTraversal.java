package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

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
	
    public static List<Integer> preorderTraversal(TreeNode root) {
    	ArrayList<Integer> orders=new ArrayList<Integer>();
    	if(root==null) return orders;
    	orders.add(root.val);
    	Stack<TreeNode> parents=new Stack<TreeNode>();
    	parents.push(root);
    	TreeNode ptr=null;
    	while(!parents.isEmpty()){
    		ptr=parents.peek().left;
    		if(ptr!=null){
    			orders.add(ptr.val);
    			parents.push(ptr);
    		}else{
    			while(!parents.isEmpty()&& parents.peek().right==null ){
    				parents.pop();
    			}
    			if(parents.isEmpty())
    				break;
    			ptr=parents.pop().right;
        			orders.add(ptr.val);
        			parents.push(ptr);
    		}
    	}
    	return orders;
    }

    /**
     * 
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {
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
		for (int i : preorderTraversal2(root)){
			System.out.println(i);
		}
		
	}

}
