package list;

import sort.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * @author luoxiongcai
 *
 */
public class AddTwoNumers {

	/**
	 * @param args
	 */

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode( -1);
		ListNode tail = dummy, h1 = l1, h2 = l2;
		int carray = 0;
		while (h1 != null || h2 != null ){
			int v1 = h1 == null ? 0 : h1.val;
			int v2 = h2 == null ? 0 : h2.val;
			int num = v1 + v2 + carray;
			carray = num / 10;
			num = num % 10; 
			tail.next = new ListNode(num);
			tail = tail.next;
			// here be careful about next value;
			if (h1 != null) h1 = h1.next;
			if (h2 != null) h2 = h2.next;
		}
		// be careful about carray.
		if (carray == 1){
		    tail.next = new ListNode(1);
		    tail = tail.next;
		}
		return dummy.next;	
	}

	public static void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1 = new ListNode(2);
		ListNode a2 = new ListNode(4);
		ListNode a3 = new ListNode(3);
		a2.next = a3;
		a1.next = a2;

		ListNode b1 = new ListNode(5);
		ListNode b2 = new ListNode(6);
		ListNode b3 = new ListNode(4);
		b2.next = b3;
		b1.next = b2;

		ListNode head = addTwoNumbers(a1, b1);
		print(head);

	}

}
