package tree;

public class ValidateBinarySearchTree {

	/**
	 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
	 * @param args
	 */
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if(root.left!=null){
        	TreeNode ptr=root.left;
        	while(ptr.right!=null)
        		ptr=ptr.right;
        	if(!(ptr.val<root.val))
        		return false;
        }
        if(root.right!=null){
        	TreeNode ptr=root.right;
        	while(ptr.left!=null)
        		ptr=ptr.left;
        	if(!(ptr.val>root.val))
        		return false;
        }
        boolean flag_left=isValidBST(root.left);
        boolean flag_right=isValidBST(root.right);
        return flag_left && flag_right;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
