package oj.list;

public class SwapNodesinPairs {

	/**
	 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
	 * @param args
	 */
    public static ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur1=head,cur2=head.next,endCur=dummy;
        while(cur1 !=null && cur2!=null){
        	endCur.next=cur2;
        	cur1.next=cur2.next;
        	cur2.next=cur1;
        	endCur=cur1;
        	if(endCur.next==null ||endCur.next.next==null)
        		return dummy.next;
        	cur1=endCur.next;
        	cur2=endCur.next.next;
        	
        }
        return dummy.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1=new ListNode(1);
		ListNode a2=new ListNode(2);
		ListNode a3=new ListNode(3);
		a1.next=a2;
		a2.next=a3;
		swapPairs(a1);
	}

}
