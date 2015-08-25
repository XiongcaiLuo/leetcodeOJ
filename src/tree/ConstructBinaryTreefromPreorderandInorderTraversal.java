package tree;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

	/**
	 * Given preorder and inorder traversal of a tree, construct the binary
	 * tree.
	 * 
	 * Note: You may assume that duplicates do not exist in the tree.
	 * 
	 * @param args
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0)
			return null;
		return build(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1);
	}

	public TreeNode build(int[] preorder, int begin_pre, int end_pre,
			int[] inorder, int begin_in, int end_in) {
		if (begin_pre > end_pre || begin_in > end_in)
			return null;
		if ((begin_pre == end_pre) && (begin_in == end_in))
			return new TreeNode(preorder[begin_pre]);
		TreeNode root = new TreeNode(preorder[begin_pre]);
		int rootIndex = getRootIndexInoder(inorder, begin_in, end_in, root.val);
		TreeNode leftRoot = build(preorder, begin_pre + 1, begin_pre
				+ rootIndex, inorder, begin_in, begin_in + rootIndex - 1);
		TreeNode rightRoot = build(preorder, begin_pre + rootIndex + 1,
				end_pre, inorder, begin_in + rootIndex + 1, end_in);
		root.left = leftRoot;
		root.right = rightRoot;
		return root;

	}

	private  int getRootIndexInoder(int[] inorder, int begin_index,
			int end_index, int root) {
		for (int i = begin_index; i <= end_index; i++) {
			if (inorder[i] == root)
				return i - begin_index;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
