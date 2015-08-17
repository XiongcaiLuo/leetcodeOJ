package list;

import sort.ListNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
 * L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * @param args
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
        	return ;
        ListNode fast = head, slow =head;
        while (fast != null && fast.next != null){
        	slow = slow.next;
        	fast = fast.next.next;
        }
        ListNode secHead = reverse(slow.next);
        slow.next = null;                       //separate the two half linked list.
        ListNode p1 = head, p2 = secHead;
        while (p2 != null){
        	ListNode cur = p2;
        	p2 = p2.next;
        	cur.next = p1.next;
        	p1.next = cur;
        	p1= p1.next.next;
        }

    }
    
    private ListNode reverse(ListNode head){
    	ListNode dummy = new ListNode(-1);
    	ListNode p = head ;
    	while (p != null){
    		ListNode cur = p;
    		p = p.next;
    		cur.next = dummy.next;
    		dummy.next = cur;
    	}
    	return dummy.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReorderList rl = new ReorderList();
		ListNode m1 = new ListNode(1);
		ListNode m2 = new ListNode(2);
		ListNode m3 = new ListNode(3);
		ListNode m4 = new ListNode(4);
		ListNode m5 = new ListNode(5);
		m1.next = m2;
		m2.next = m3;
		m3.next = m4;
		m4.next = m5;


		rl.reorderList(m1);
		System.out.println();
	}

}
