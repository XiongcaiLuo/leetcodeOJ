package tree;

public class PopulatingNextRightPointersinEachNodeII {

	/**
	 * recursion
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
    /**
     * iteraion
     * @param root
     */
    public void connect2(TreeLinkNode root) {
		TreeLinkNode dummy = new TreeLinkNode(-1);
		TreeLinkNode cur = root, tail = null;
		dummy.next = root;
		while (cur != null) {
			dummy.next = null;
			tail = dummy;
			while (cur != null) {
				if (cur.left != null) {
					tail.next = cur.left;
					tail = tail.next;
				}
				if (cur.right != null) {
					tail.next = cur.right;
					tail = tail.next;
				}
				cur = cur.next;
			}
			cur = dummy.next;
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
