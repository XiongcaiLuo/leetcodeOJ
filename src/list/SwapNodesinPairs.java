package list;

import sort.ListNode;

public class SwapNodesinPairs {

	/**
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 * 
	 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
	 * 
	 * Your algorithm should use only constant space. You may not modify the
	 * values in the list, only nodes itself can be changed.
	 * 
	 * @param args
	 */
	public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
		ListNode dummy = new ListNode(-1);
		ListNode tail = dummy, p = head;
		while (p != null && p.next != null){
			ListNode q = p.next, r = p.next.next;
			tail.next = q;
			q.next = p;
			p.next = r;
			tail = p;
			p = r;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		a1.next = a2;
		a2.next = a3;
		swapPairs(a1);
	}

}
