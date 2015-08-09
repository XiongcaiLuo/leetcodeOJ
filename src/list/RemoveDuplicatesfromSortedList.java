package oj.list;

public class RemoveDuplicatesfromSortedList {

	/**
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
	 * @param args
	 */
    public static ListNode deleteDuplicates(ListNode head) {
    	if(head==null ||head.next==null) return head;
        ListNode ptr=head.next;
        ListNode suitPtr=head;
        int preV=head.val;
        while(ptr!=null){
        	if(ptr.val==preV){
        		suitPtr.next=null;
        		ptr=ptr.next;
        	}
        	else{
        		suitPtr.next=ptr;
        		suitPtr=ptr;
        		ptr=ptr.next;
        		preV=suitPtr.val;
        	}
        }
        
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
