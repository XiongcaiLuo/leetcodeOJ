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
    	ArrayList<Integer> orders=new ArrayList<>();
    	if(root==null) return orders;
    	orders.add(root.val);
    	Stack<TreeNode> parents=new Stack<>();
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

    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
