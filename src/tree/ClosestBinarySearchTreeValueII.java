package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a non-empty binary search tree and a target value, find k values in the
 * BST that are closest to the target.
 * 
 * Note: Given target value is a floating point. You may assume k is always
 * valid, that is: k ≤ total nodes. You are guaranteed to have only one unique
 * set of k values in the BST that are closest to the target. Follow up: Assume
 * that the BST is balanced, could you solve it in less than O(n) runtime (where
 * n = total nodes)?
 * 
 * @author luoxiongcai
 *
 */
public class ClosestBinarySearchTreeValueII {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		Stack<Integer> small = new Stack<Integer>();
		Stack<Integer> big = new Stack<Integer>();
		inorder(root, target,small );
		reverseInorder(root, target, big);
		List<Integer> result = new ArrayList<Integer>();
		while (k-- >0){
			if (small.isEmpty()){
				result.add(big.pop());
			} else if (big.isEmpty()){
				result.add(small.pop());
			} else if (Math.abs(target - small.peek()) < Math.abs(target - big.peek())){
				result.add(small.pop());
			} else result.add(big.pop());
		}
		return result;  
	}
	
	private void inorder(TreeNode cur, double target, Stack<Integer> small){
		if (cur == null || cur.val > target) return;
		inorder(cur.left, target, small);
		small.push(cur.val);
		inorder(cur.right,target, small);
	}
	
	private void reverseInorder(TreeNode cur, double target, Stack<Integer> big){
		if ( cur == null || cur.val < target) return;
		reverseInorder(cur.right, target, big);
		big.push(cur.val);
		reverseInorder(cur.left, target, big);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
