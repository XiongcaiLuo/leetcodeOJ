package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

	/**
	 * @param args
	 */


    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> orders=new ArrayList<Integer> ();
    	if(root==null) return orders;
         postorder(orders,root);
    	return orders;     
    }
    
    public void postorder(ArrayList<Integer> orders,TreeNode root){
        if(root==null)
            return ;
        else{
            postorder(orders,root.left);
            postorder(orders,root.right);
            orders.add(root.val);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
