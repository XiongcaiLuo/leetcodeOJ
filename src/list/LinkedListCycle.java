package list;

import sort.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * @param args
 */
public class LinkedListCycle {

	public static boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		while (head != null) {
			if (head.val == Integer.MAX_VALUE)
				return true;
			else {
				head.val = Integer.MAX_VALUE;
				head = head.next;
			}
		}
		return false;

	}

	public static boolean hasCycle2(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow)
				return true;

		}
		return false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
