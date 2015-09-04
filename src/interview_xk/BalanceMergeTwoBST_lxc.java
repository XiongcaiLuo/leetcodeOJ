package interview_xk;


//package interviewquestions.google;

import java.util.*;

public class BalanceMergeTwoBST_lxc {
    public BinaryTreeNode<Integer> mergeTwoBST(BinaryTreeNode<Integer> root1,
            BinaryTreeNode<Integer> root2) {
        root1 = flatBST(root1);
        root2 = flatBST(root2);
        root1 = mergeTwoFlatBST(root1, root2);
        return constructBSTFromList(root1);
    }

    /**
     * Find the smallest which will be the return node Flat the tree to a single
     * linked list. This take O(n) time and constant space.
     */
    private BinaryTreeNode<Integer> dummy ,tail;
    public BinaryTreeNode<Integer> flatBST(BinaryTreeNode<Integer> root) {
    	dummy = new BinaryTreeNode<Integer>(-1);
    	tail = dummy;
    	inorder(root);
    	return dummy.right;
    }
    
    private void inorder(BinaryTreeNode<Integer> root){
    	if (root == null) return ;
    	inorder(root.left);
    	tail.right = root;
    	root.left = null;
    	tail = tail.right;
    	inorder(root.right);
    }

    /**
     * Merge Two flatten binary search tree into one, this takes O(n) time and
     * constant space
     */
    public BinaryTreeNode<Integer> mergeTwoFlatBST(
            BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
        BinaryTreeNode<Integer> dummy = new BinaryTreeNode<Integer>(-1);
        BinaryTreeNode<Integer> tail = dummy;
        BinaryTreeNode<Integer> p1 = root1;
        BinaryTreeNode<Integer> p2 = root2;
        while (root1 != null && root2 != null){
        	if (root1.val < root2.val){
        		tail.right = root1;
        		root1 = root1.right;
        	} else {
        		tail.right = root2;
        		root2 = root2.right;
        	}
        	tail = tail.right;
        }
        if (root1 != null)
        	tail.right = root1;
        else if (root2 != null)
        	tail.right = root2;
        return dummy.right;
    }

    /**
     * Construct BST from bottom to top. First find length of list, then build
     * it up recursively.
     */
    public BinaryTreeNode<Integer> constructBSTFromList(
            BinaryTreeNode<Integer> root) {
        int len = 0;
        BinaryTreeNode<Integer> p = root;
        while (p != null) {
            p = p.right;
            len++;
        }
        List<BinaryTreeNode<Integer>> list = new ArrayList<BinaryTreeNode<Integer>>();
        list.add(root);
        return constructBSTFromList(list, 0, len - 1);
    }

    public BinaryTreeNode<Integer> constructBSTFromList(
            List<BinaryTreeNode<Integer>> list, int start, int end) {
        if (start > end)
            return null;
        int mid = start + (end - start) / 2;
        BinaryTreeNode<Integer> left = constructBSTFromList(list, start, mid - 1);
        BinaryTreeNode<Integer> root = list.get(0);
        root.left = left;
        list.clear();
        list.add(root.right);
        root.right = constructBSTFromList(list, mid + 1, end);
        return root;
    }
}
