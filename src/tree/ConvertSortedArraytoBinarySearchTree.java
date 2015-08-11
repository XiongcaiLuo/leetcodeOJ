package tree;

/**
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 */
public class ConvertSortedArraytoBinarySearchTree {

	/**
	 * 分治算法。
	 * @param num
	 * @return
	 */
	public static TreeNode sortedArrayToBST(int[] num) {
		if (num.length == 0)
			return null;
		return build(num, 0, num.length - 1);
	}

	public static TreeNode build(int[] num, int begin, int end) {
		if (begin > end)
			return null;
		if (begin == end)
			return new TreeNode(num[begin]);
		int mid = (begin + end) / 2;
		TreeNode root = new TreeNode(num[mid]);
		TreeNode root_left = build(num, begin, mid - 1);
		TreeNode root_right = build(num, mid + 1, end);
		root.left = root_left;
		root.right = root_right;
		return root;

	}

	public static void main(String[] args) {
		int[] num = new int[] { 1, 3 };
		TreeNode n = sortedArrayToBST(num);
		System.out.println(n.val);
		System.out.println(n.left);
		System.out.println(n.right.val);
	}

}
