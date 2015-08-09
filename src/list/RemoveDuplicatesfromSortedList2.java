package oj.list;

import java.util.List;

public class RemoveDuplicatesfromSortedList2 {

	/**
	 * @param args
	 */
    public static ListNode deleteDuplicates(ListNode head) {
    	if(head==null || head.next==null) return head;
    	ListNode dummy=new ListNode(Integer.MAX_VALUE);
    	dummy.next=head;
    	ListNode cur=head,rightCur=dummy;
    	while(cur!=null){
    		if(cur.next==null){
    			rightCur.next=cur;
    			return dummy.next;
    		}
    			
    		if(cur.val!=cur.next.val){
    			rightCur.next=cur;
    			rightCur=cur;
    			cur=cur.next;
    		}
    		else{
    			// find the bound;
    			int value=cur.val;
    			while(cur!=null && cur.val==value){
    				cur=cur.next;
    			}
    			if(cur==null){
    				rightCur.next=null;
    				return dummy.next;
    			}
    			
    		}
    	}
    	
    	return dummy.next;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1=new ListNode(1);
		ListNode a2=new ListNode(1);
		ListNode a3=new ListNode(2);
//		ListNode a4=new ListNode(2);
		a1.next=a2;
		a2.next=a3;
//		a3.next=a4;
		deleteDuplicates(a1);

	}

}
