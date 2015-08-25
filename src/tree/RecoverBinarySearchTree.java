package tree;

import java.util.ArrayList;
/**
 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * @param args
 */

public class RecoverBinarySearchTree {

	/**
	 * inorder first
	 * @param root
	 */
	ArrayList<TreeNode> inorders = new ArrayList<TreeNode>();
    public void recoverTree(TreeNode root) {
        inorder(root);
        TreeNode ptr1 = null, ptr2 = null;
        for (int i = 0; i < inorders.size() - 1; i++){
        	if (inorders.get(i).val > inorders.get(i+1).val){
        		ptr1 = inorders.get(i);
        		break;
        	}
        }
        for (int j = inorders.size() - 1; j > 0; j--){
        	if (inorders.get(j).val < inorders.get(j - 1).val){
        		ptr2 = inorders.get(j);
        		break;
        	}
        }
        swap(ptr1,ptr2);
    }  

    private void inorder(TreeNode root){
    	if (root != null){
    		inorder(root.left);
    		inorders.add(root);
    		inorder(root.right);
    	}
    }
    
    
    private void swap(TreeNode ptr1, TreeNode ptr2){
    	int val=ptr1.val;
    	ptr1.val=ptr2.val;
    	ptr2.val=val;
    }
    

	public static void main(String[] args) {
		RecoverBinarySearchTree t = new RecoverBinarySearchTree();
		TreeNode node0=new TreeNode(1);
		TreeNode node1=new TreeNode(3);
		TreeNode node2=new TreeNode(2);
		
		node0.right=node1; 
		node1.right=node2;
		t.recoverTree(node0);
		System.out.println("recover");
		System.out.println(node0.val);
		System.out.println(node1.val);
		System.out.println(node2.val);

	}

}
