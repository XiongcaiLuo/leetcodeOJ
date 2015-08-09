package oj.list;

public class ReorderList {

	/**
	 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
	 * @param args
	 */
    private static ListNode reverse(ListNode head) {
    	if(head==null||head.next==null) return head;
    	ListNode prev=head,sec=head.next;
    	prev.next=null;
    	while(sec!=null){
    		ListNode next=sec.next;
    		sec.next=prev;
    		if(next==null)
    			return sec;
    		prev=sec;
    		sec=next;
    	}
    	return sec;
    }
    
    private static ListNode insert(ListNode h1,ListNode h2){
    	if(h1==null||h2==null) return h1;
    	ListNode ptr1=h1,ptr2=h2;
    	while(ptr1!=null && ptr2!=null){
    		ListNode insertPtr=ptr2;
    		ptr2=ptr2.next;
    		insertPtr.next=ptr1.next;
    		ptr1.next=insertPtr;
    		
    		ptr1=ptr1.next.next;
    	}
    	return h1;
    }
    
    public void reorderList(ListNode head) {
        if(head==null|| head.next==null ||head.next.next==null) return ;
        ListNode slow=head,fast=head;
        while(fast.next!=null && fast.next.next!=null){
        	slow=slow.next;
        	fast=fast.next.next;
        }
        ListNode revHead=reverse(slow.next);
        slow.next=null;
        insert(head,revHead);
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode m1=new ListNode(3);
		ListNode m2=new ListNode(5);
		ListNode m3=new ListNode(6);
		m1.next=m2;
		m2.next=m3;
		ListNode mm1=new ListNode(33);
		ListNode mm2=new ListNode(53);
//		ListNode mm3=new ListNode(63);
		mm1.next=mm2;
//		mm2.next=mm3;
		ListNode head=insert(m1,mm1);
		System.out.println();
	}

}
