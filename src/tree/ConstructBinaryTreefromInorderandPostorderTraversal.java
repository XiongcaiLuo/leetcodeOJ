package tree;

public class ConstructBinaryTreefromInorderandPostorderTraversal {

	/**
	 * Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
	 * @param args
	 */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (postorder.length == 0)
			return null;
		return build(postorder, 0, postorder.length - 1, inorder, 0,
				inorder.length - 1);
    }
	public TreeNode build(int[] postorder, int begin_post, int end_post,
			int[] inorder, int begin_in, int end_in) {
		if (begin_post > end_post || begin_in > end_in)
			return null;
		if ((begin_post == end_post) && (begin_in == end_in))
			return new TreeNode(postorder[end_post]);
		TreeNode root = new TreeNode(postorder[end_post]);
		int rootIndex = getRootIndexInoder(inorder, begin_in, end_in, root.val);
		TreeNode leftRoot = build(postorder, begin_post , begin_post
				+ rootIndex-1, inorder, begin_in, begin_in + rootIndex - 1);
		TreeNode rightRoot = build(postorder, begin_post + rootIndex ,
				end_post-1, inorder, begin_in + rootIndex + 1, end_in);
		root.left = leftRoot;
		root.right = rightRoot;
		return root;

	}

	public int getRootIndexInoder(int[] inorder, int begin_index,
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
