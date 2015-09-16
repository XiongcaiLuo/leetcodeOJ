package tree;

import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

     1
    / \
   2   5
  / \   \
 3   4   6
The flattened tree should look like:
1
\
 2
  \
   3
    \
     4
      \
       5
        \
         6
click to show hints.

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
 * @param args
 */
public class FlattenBinaryTreetoLinkedList {

/**
 * recursion
 * @param root
 */
    public static void flatten(TreeNode root) {
        if(root==null) return ;
        flatten(root.left);
        flatten(root.right);
        if(root.left==null) return;
        
        TreeNode p=root.left;
        while(p.right!=null) p=p.right;
        p.right=root.right;
        root.right=root.left;
        root.left=null;
    }
    /**
     * another recursion.
     * @param root
     */
//    public TreeNode flatten3(TreeNode root) {
//    	if (root == null) return null;
//    	TreeNode leftTail = flatten3(root.left);
//    	TreeNode rightTail = flatten3(root.right);
//    	if (leftTail == null){
//    		return rightTail == null ? root : rightTail;
//    	} else {
//    		leftTail.right = root.right;
//    		root.right = root.left;
//    		return rightTail == null ? leftTail : rightTail;
//    	}
//    } 
    /**
     * iteration
     * @param root
     */
    public  void flatten2(TreeNode root) {
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	while (!s.isEmpty()){
    		TreeNode cur = s.pop();
    		if (cur.right != null)
    			s.push(cur.right);
    		if (cur.left != null)
    			s.push(cur.left);
    		cur.left = null;
    		if (!s.isEmpty())
    			cur.right = s.peek();
    	}
    }

	public static void main(String[] args) {
		TreeNode node1=new TreeNode(1);
		TreeNode node2=new TreeNode(2);
		node1.left=node2;
		flatten(node1);
		System.out.println(node1.left);
		System.out.println(node1.right);
	}

}
