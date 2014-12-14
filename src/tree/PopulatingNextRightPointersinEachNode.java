package tree;

public class PopulatingNextRightPointersinEachNode {

	/**
	 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
	 * @param args
	 */
    public void connect(TreeLinkNode root) {
    	if(root==null) return;
    	TreeLinkNode dummy=new TreeLinkNode(-1);
    	TreeLinkNode cur=root,pre=dummy;
    	
    	for(;cur!=null;cur=cur.next){
    		if(cur.left!=null){
    			pre.next=cur.left;
    			pre=pre.next;
    		}
    		if(cur.right!=null){
    			pre.next=cur.right;
    			pre=pre.next;
    		}
    	}
    	connect(dummy.next);
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
