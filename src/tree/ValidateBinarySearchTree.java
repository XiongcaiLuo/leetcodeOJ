package tree;
/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the
 * node's key. The right subtree of a node contains only nodes with keys
 * greater than the node's key. Both the left and right subtrees must also
 * be binary search trees.
 * 
 * @param args
 */
public class ValidateBinarySearchTree {

    /**
     * a perfect method. 
     * @param root
     * @return
     */
	public boolean isValidBST(TreeNode root) {
		return isValid(root, null, null);

	}
	
	private boolean isValid(TreeNode root, Integer low, Integer high){
		if (root == null) return true;
		return (low == null || root.val > low) && (high == null || root.val < high)
				&& isValid(root.left, low, root.val) && isValid(root.right, root.val, high);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
