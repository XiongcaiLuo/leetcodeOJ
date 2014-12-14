package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

	/**
	 * @param args
	 */
    public List<Integer> inorderTraversal(TreeNode root) {
    	ArrayList<Integer> orders=new ArrayList<>();
    	if(root==null) return orders;
    	Stack<TreeNode> parents=new Stack<>();
    	parents.push(root);
    	TreeNode ptr=null;
    	while(!parents.isEmpty()){
    		ptr=parents.peek().left;
    		if(ptr!=null)
    			parents.push(ptr);
    		else{
    			while(!parents.isEmpty() && parents.peek().right==null){
    				orders.add(parents.pop().val);
    			}
    			if(parents.isEmpty())
    				break;
    			else{
    				orders.add(parents.peek().val);
    				ptr=parents.pop().right;
    				parents.push(ptr);
    			}
    		}

    	}
    	
    	return orders;
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
