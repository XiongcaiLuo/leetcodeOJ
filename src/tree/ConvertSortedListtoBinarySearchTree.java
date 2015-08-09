package tree;

import java.util.ArrayList;

public class ConvertSortedListtoBinarySearchTree {

	/**
	 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
	 * @param args
	 */
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        ArrayList<Integer> nums=new ArrayList<Integer>();
        ListNode ptr=head;
        while(ptr!=null){
        	nums.add(ptr.val);
        	ptr=ptr.next;
        }
        return sortedArrayToBST(nums);
  
    }
    public TreeNode sortedArrayToBST(ArrayList<Integer> num) {
        if(num.size()==0) return null;
        return build(num,0,num.size()-1); 
    }
    public  TreeNode build(ArrayList<Integer> num, int begin,int end){
    	if(begin>end) return null;
    	if(begin==end) return new TreeNode(num.get(begin));
    	int mid=(begin+end)/2;
    	TreeNode root=new TreeNode(num.get(mid));
    	TreeNode root_left=build(num,begin,mid-1);
    	TreeNode root_right=build(num,mid+1,end);
    	root.left=root_left;
    	root.right=root_right;
    	return root;
    			
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
