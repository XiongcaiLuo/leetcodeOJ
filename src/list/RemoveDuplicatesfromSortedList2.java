package list;

import sort.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3,
 * return 2->3.
 * 
 * @author luoxiongcai
 *
 */
public class RemoveDuplicatesfromSortedList2 {

	/**
	 * @param args
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(Integer.MAX_VALUE);
		ListNode tail = dummy;
		ListNode pre = head, cur =head.next;
		while ( cur != null){
			if ( cur.val != pre.val){
				tail.next = pre;
				tail = tail.next;
			} else {
				while (cur != null && pre.val == cur.val) cur =cur.next;
				if (cur == null) break;
			}
			pre =cur;
			cur = cur.next;
		}
		//be careful about the last pre
		if (pre.next == null){
			tail.next = pre;
			tail = tail.next;
		}
		tail.next = null;
		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(1);
		ListNode a3 = new ListNode(2);
		// ListNode a4=new ListNode(2);
		a1.next = a2;
		a2.next = a3;
		// a3.next=a4;
		deleteDuplicates(a1);

	}

}
