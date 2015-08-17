package list;

import sort.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * @param args
 */
public class LinkedListCycle2 {

	public static ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		if (head.next == head)
			return head;
		ListNode slow1 = head, slow2 = head, fast = head;
		boolean flag = false;
		while (fast != null && fast.next != null) {
			slow1 = slow1.next;
			fast = fast.next.next;
			if (fast == slow1) {
				flag = true;
				break;
			}
		}
		if (!flag)
			return null;
		while (slow2 != slow1) {
			slow2 = slow2.next;
			slow1 = slow1.next;
		}
		return slow1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
