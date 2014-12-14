package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

	/**
	 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
	 * @param args
	 */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> result=new ArrayList<List<Integer>>();
        if(root==null) return result;
        ArrayList<Integer> cur=new ArrayList<Integer>();
        pathSum(root,sum,cur,result);
        return result;
    }
	private void pathSum(TreeNode root, int sum, ArrayList<Integer> cur,
			ArrayList<List<Integer>> result) {
		if(root==null) return;
		cur.add(root.val);
		if(root.left==null && root.right==null){
			if(sum==root.val){
				result.add(cur);
				return;
			}
		}
		ArrayList<Integer> cur_other=new ArrayList<Integer>(cur);
		pathSum(root.left,sum-root.val,cur,result);
		pathSum(root.right,sum-root.val,cur_other,result);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
