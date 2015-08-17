package list;

import sort.ListNode;

/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * For example: Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 * 
 * @param args
 */
public class RotateList {

	public static ListNode rotateRight(ListNode head, int n) {
		if (head == null || head.next == null || n == 0)
			return head;
		ListNode cur = head;
		int total = 1;
		while (cur.next != null) {
			total++;
			cur = cur.next;
		}

		cur.next = head;
		int count = 0;
		int bound = total - n % total;
		while (count < bound) {
			cur = cur.next;
			count++;
		}
		ListNode newhead = cur.next;
		cur.next = null;
		return newhead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
