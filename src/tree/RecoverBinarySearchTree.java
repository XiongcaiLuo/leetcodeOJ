package tree;

import java.util.ArrayList;

public class RecoverBinarySearchTree {

	/**
	 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
	 * @param args
	 */
	
	/**
	 * this method requires o(n) space for preOrder scan;
	 * @param ptr1
	 * @param ptr2
	 */
//    public  void recoverTree(TreeNode root) {
//    	ArrayList<TreeNode> data=new ArrayList<TreeNode>();
//    	preOrder(data,root);
//    	// find the index of bigger one;
//    	TreeNode bigger=null,smaller=null;
//    	for(int i=0;i<data.size()-1;i++){
//    		if(data.get(i).val>data.get(i+1).val){
//    			bigger=data.get(i);
//    			break;
//    		}
//    	}
//    	//find the index of smaller one;
//    	for(int i=data.size()-1;i>0;i--){
//    		if(data.get(i).val<data.get(i-1).val){
//    			smaller=data.get(i);
//    			break;
//    		}
//    	}
//    	swap(bigger,smaller);
//    	
//    }
//    
    private void preOrder(TreeNode root){
    	if(isBiggerFound) return;
    	if(root == null) return;
    	preOrder(root.left);
    	if(isBiggerFound) return;
    	if(root.val<bigger.val){
    		System.out.println("find bigger:"+bigger.val);
    		isBiggerFound=true;
    		return;
    	}else bigger=root;
    	if(isBiggerFound) return;
    	preOrder(root.right);
    }
    private void reversePreOrder(TreeNode root){
    	if(isSmallerFound) return;
    	if(root == null) return;
    	reversePreOrder(root.right);
    	if(isSmallerFound) return;
    	if(root.val>smaller.val){
    		System.out.println("finder smaller:"+smaller.val);
    		isSmallerFound=true;
    		return;
    	}else smaller=root;
    	if(isSmallerFound) return;
    	reversePreOrder(root.left);
    }
    
    
    private void swap(TreeNode ptr1, TreeNode ptr2){
    	int val=ptr1.val;
    	ptr1.val=ptr2.val;
    	ptr2.val=val;
    }
    
    /**
     * this method require constant space;need preOrder and reverse-preOrder scan.
     * @param root
     */
    TreeNode bigger=new TreeNode(Integer.MIN_VALUE),smaller=new TreeNode(Integer.MAX_VALUE);
    boolean isBiggerFound=false, isSmallerFound=false;
    public  void recoverTree(TreeNode root) {
    	preOrder(root);
    	reversePreOrder(root);
    	System.out.println("bigger:"+bigger.val);
    	System.out.println("smaller:"+smaller.val);
    	swap(bigger,smaller);
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
