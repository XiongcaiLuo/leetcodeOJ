
package list;

import sort.ListNode;

/**
 * 采用尾插法。
 * @param args
 */
public class PartitionList {


    public static ListNode partition(ListNode head, int x) {
    	ListNode less=new ListNode(-1);
    	ListNode great=new ListNode(-1);
    	ListNode lptr=less,gptr=great;
    	ListNode ptr=head;
    	while(ptr!=null){
    		if(ptr.val<x){
    			lptr.next=ptr;
    			lptr=ptr;
    		}
    		else {
    			gptr.next=ptr;
    			gptr=ptr;
    		}
    		ptr=ptr.next;
    	}
    	lptr.next=great.next;
    	gptr.next=null;
		return less.next;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode m1=new ListNode(2);
		ListNode m2=new ListNode(1);
		m1.next=m2;
		partition(m1,2);
	}

}
