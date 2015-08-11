package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 */
public class MinimumDepthofBinaryTree {

	public int minDepth(TreeNode root) {
		//it's not right. for example [1,2], should return 2, but ,here it returns 1;
//		if (root == null)
//			return 0;
//		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
		
		//here is the result;
//		if (root == null) return 0;
//		if (root.left == null) return minDepth(root.right) + 1;
//		if (root.right == null) return minDepth(root.left) + 1;
//		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
		
		//here is bfs(level-order scan). it can terminated soon.
		if (root == null)
		return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int level = 0;
		while (!queue.isEmpty()){
			level++;
			int size = queue.size();
			for( int i = 0; i < size; i++){
				TreeNode cur = queue.poll();
				if (cur.left == null && cur.right == null){
					return level;
				}
				if (cur.left != null) queue.offer(cur.left);
				if (cur.right!= null) queue.offer(cur.right);
			}
		}
		return level;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
