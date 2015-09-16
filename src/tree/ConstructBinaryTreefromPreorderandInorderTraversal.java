package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * @param args
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	private Map<Integer, Integer> inorderIndex = new HashMap<Integer, Integer>();
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0)
			return null;
		getIndex(inorder);
		return build(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1);
	}

	private void getIndex(int[] inorder) {
		for (int i = 0; i < inorder.length; i++) {
			inorderIndex.put(inorder[i], i);
		}
	}

	public TreeNode build(int[] preorder, int begin_pre, int end_pre,
			int[] inorder, int begin_in, int end_in) {
		if (begin_pre > end_pre || begin_in > end_in)
			return null;
		if ((begin_pre == end_pre) && (begin_in == end_in))
			return new TreeNode(preorder[begin_pre]);
		TreeNode root = new TreeNode(preorder[begin_pre]);
		int rootIndex = inorderIndex.get(root.val);
		int offset = rootIndex - begin_in;
		TreeNode leftRoot = build(preorder, begin_pre + 1, begin_pre + offset,
				inorder, begin_in, rootIndex - 1);
		TreeNode rightRoot = build(preorder, begin_pre + offset + 1, end_pre,
				inorder, rootIndex + 1, end_in);
		root.left = leftRoot;
		root.right = rightRoot;
		return root;

	}

	public static void main(String[] args) {
		ConstructBinaryTreefromPreorderandInorderTraversal cp = new ConstructBinaryTreefromPreorderandInorderTraversal();
		int[] preorder = { 1, 2 };
		int[] inorder = { 2, 1 };
		TreeNode root = cp.buildTree(preorder, inorder);
		System.out.println(root);
	}

}
