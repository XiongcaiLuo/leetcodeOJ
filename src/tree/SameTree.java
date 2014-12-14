package tree;

public class SameTree {

	/**
	 * Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
	 * @param args
	 */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        else if((p!=null && q==null)||(p==null && q!=null)) return false;
		boolean f1=isSameTree(p.left, q.left);
        boolean f2=isSameTree(p.right, q.right);
        if(p.val==q.val && f1 && f2)
        	return true;
        else return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode p=new TreeNode(0);
		TreeNode q=new TreeNode(0);
		System.out.println(isSameTree(p,q));
	}

}
