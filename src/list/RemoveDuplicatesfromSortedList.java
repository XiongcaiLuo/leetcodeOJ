package list;

import sort.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
 * 
 * @param args
 */
public class RemoveDuplicatesfromSortedList {
	/**
	 * 不允许重复
	 * @param head
	 * @return
	 */
	public  ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode tail = head, cur = head.next;
		while (cur !=null){
			if (cur.val != tail.val){
				tail.next = cur;
				tail = tail.next;
			}
			cur = cur.next;
		}
		tail.next = null;                           // be careful about the tail.
		return head;
	}
	
	/**
	 * 至多有两个一样的。即允许重复1次。
	 * 1 -> 1 -> 2 -> 2 -> ->2 返回 1 -> 1 -> 2 -> 2;
	 * @param head
	 * @return
	 */
	public  ListNode deleteDuplicates2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode (-1);
		dummy.next = head;
		ListNode preTail = dummy, cur = head.next;
		while (cur != null) {
			if (preTail == dummy || preTail.val != cur.val){  //最后一个并不关心，应该关心倒数第一个。
				preTail.next.next = cur;
				preTail = preTail.next;
			}
			cur = cur.next;
		}
		preTail.next.next = null;                          //here be careful
		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(1);
		ListNode a3 = new ListNode(2);
		ListNode a4 = new ListNode(2);
		ListNode a5 = new ListNode(2);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;


		RemoveDuplicatesfromSortedList rf = new RemoveDuplicatesfromSortedList();
//		ListNode u1 = rf.deleteDuplicates(a1);
		ListNode u2 = rf.deleteDuplicates2(a1);
		System.out.println("" +u2);
	}

}
