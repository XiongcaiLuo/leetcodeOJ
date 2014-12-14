package sort;

public class SortList {

	/**
	 * Sort a linked list in O(n log n) time using constant space complexity.
	 * @param args
	 */
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode fast=head,slow=head;
        while(slow.next!=null && fast.next.next!=null){
        	fast=fast.next.next;
        	slow=slow.next;
        }
        fast=slow;
        slow=slow.next;
        fast.next=null;
        ListNode left=sortList(head);
        ListNode right=sortList(slow);
        return mergeTwoLists(left, right);
    }
    public  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        concat(dummy,l1,l2);
        return dummy.next;
    }
    private void concat(ListNode tail,ListNode root1,ListNode root2){
    	if(root1==null){
    		tail.next=root2;
    	}else if( root2==null){
    		tail.next=root1;
    	}else{
    		if(root1.val<=root2.val){
    			ListNode next1=root1.next;
    			tail.next=root1;
    			root1.next=null;
    			tail=root1;
    			concat(tail,next1,root2);
    		}else{
    			ListNode next2=root2.next;
    			tail.next=root2;
    			root2.next=null;
    			tail=root2;
    			concat(tail,root1,next2);
    		}
    	}
    }
	public static void main(String[] args) {
		SortList t=new SortList();
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(3);
		ListNode n3=new ListNode(4);
		n1.next=n2;
		n2.next=n3;
		ListNode r=t.sortList(n1);
	}

}
