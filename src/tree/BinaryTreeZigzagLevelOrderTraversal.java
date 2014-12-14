package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

	/**
	 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
	 * @param args
	 */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> result=new ArrayList<List<Integer>>();
    	if(root==null) return result;
        Queue<TreeNode> deals=new LinkedList<TreeNode>();
        deals.offer(root);
        ArrayList<Integer> vals=new ArrayList<Integer>();
        vals.add(root.val);
        result.add(vals);
        int currentBound=1,nextBound=0;
        boolean isRight=true;
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
        	if(isRight){
        		Collections.reverse(val_level);
        		isRight=false;
        	}else{
        		isRight=true;
        	}
        	if(!val_level.isEmpty())
        		result.add(val_level);
        	
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
