package list;

import org.w3c.dom.ls.LSInput;

import sort.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end
 * should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example, Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * @param args
 */
public class ReverseNodesinkGroup {

	public static ListNode reverseKGroup(ListNode head, int k) {
		if (k <= 1 || head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode preHead = dummy, nextHead = dummy;
		while (true) {
			nextHead = reverseTopk(preHead, k);
			if (nextHead == preHead)
				break;
			else {
				preHead = nextHead;
			}
		}
		return dummy.next;

	}

	private static ListNode reverseTopk(ListNode preHead, int k) {
		int count = 0;
		ListNode cur = preHead;
		while (cur.next != null) {
			count++;
			cur = cur.next;
		}
		if (count < k)
			return preHead;
		else {
			cur = preHead.next;
			count = 0;
			while (count < k - 1) {
				ListNode swapCur = cur.next;
				cur.next = swapCur.next;
				ListNode nextCur = preHead.next;
				swapCur.next = nextCur;
				preHead.next = swapCur;
				count++;
			}

		}
		return cur;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		a1.next = a2;
		a2.next = a3;
		reverseKGroup(a1, 3);
	}

}
