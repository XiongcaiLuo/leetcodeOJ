package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal2 {

	/**
	 * @param args
	 */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> result=new ArrayList<List<Integer>>();
    	if(root==null) return result;
        Queue<TreeNode> deals=new LinkedList<TreeNode>();
        deals.offer(root);
        ArrayList<Integer> vals=new ArrayList<Integer>();
        vals.add(root.val);
        result.add(vals);
        int currentBound=1,nextBound=0;
        while(!deals.isEmpty()){
        	ArrayList<Integer> val_level=new ArrayList<Integer>();
        	while(currentBound>0){
            	TreeNode curNode=deals.poll();
            	currentBound--;
            	if(curNode.left!=null){
            		deals.offer(curNode.left);
            		val_level.add(curNode.left.val);
            		nextBound++;
            	}
            	if(curNode.right!=null){
            		deals.offer(curNode.right);
            		val_level.add(curNode.right.val);
            		nextBound++;
            	}
        	}
        	currentBound=nextBound;
        	nextBound=0;
        	if(!val_level.isEmpty())
        		result.add(val_level);
        	Collections.reverse(val_level);
        }
        return result;
    }
    
 
	public static void main(String[] args) {
		
	}

}
