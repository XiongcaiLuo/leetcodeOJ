package sort;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * use merge sort.
 * @param args
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode fast=head,slow=head;
        while(fast.next!=null && fast.next.next!=null){
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
        ListNode tail = dummy;
        while (l1 != null && l2 != null){
        	if (l1.val < l2.val){
        		tail.next = l1;
        		tail = tail.next;
        		l1 = l1.next;
        	} else {
        		tail.next = l2;
        		tail = tail.next;
        		l2 = l2.next;
        	}
        }
        tail.next = l1 == null ? l2 : l1;
        return dummy.next;
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
