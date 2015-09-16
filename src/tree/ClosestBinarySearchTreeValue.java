package tree;
/**
 * given a binary search tree, find the closet element to the target
 * just search.
 * 
 * @author luoxiongcai
 *
 */
public class ClosestBinarySearchTreeValue {
	private int result = Integer.MIN_VALUE ;
	public int closestValue(TreeNode root, double target) {
		dfs(root, target);
		return result;
	}
	private void dfs(TreeNode cur, double target){
		if (cur == null) return;
		result = Math.abs(target - cur.val) < Math.abs( target - result) ? cur.val : result;
		if (target > cur.val){
			dfs(cur.right, target);
		} else if (target < cur.val){
			dfs(cur.left, target);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
