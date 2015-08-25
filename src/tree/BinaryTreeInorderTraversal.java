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
    
    /**
     * http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
     * morris遍历
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
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
    				q.right = p;
    				p = p.left;
    			} else {
    				orders.add(p.val);
    				q.right = null;
    				p = p.right;
    			}
    		}
    	}
    	return orders;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
