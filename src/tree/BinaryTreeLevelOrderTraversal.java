package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 * @author luoxiongcai
 *
 */
public class BinaryTreeLevelOrderTraversal {


    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> result=new ArrayList<List<Integer>>();
    	if(root==null) return result;
        Queue<TreeNode> deals=new LinkedList<TreeNode>();
        deals.offer(root);
        while (!deals.isEmpty()){
        	int size = deals.size();
        	ArrayList<Integer> nodes = new ArrayList<Integer>();
        	for (int i = 0; i < size; i++ ){
        		TreeNode cur = deals.poll();
        		nodes.add(cur.val);
        		if (cur.left != null)
        			deals.offer(cur.left);
        		if (cur.right != null)
        			deals.offer(cur.right);
        	}
        	result.add(nodes);
        }
        return result;
    }
    
 
	public static void main(String[] args) {
		
	}

}
