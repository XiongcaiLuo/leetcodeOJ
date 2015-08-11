package sort;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 */
public class MergeTwoSortedLists {


	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode tail = dummy, h1 = l1, h2 = l2;
		while (h1 != null && h2 != null){
			if (h1.val < h2.val){
				tail.next = h1;
				h1 = h1.next;
			} else {
				tail.next = h2;
				h2 = h2.next;
			}
			tail = tail.next;

		}
		if (h1 == null) tail.next = h2;
		if (h2 == null) tail.next = h1;
		return dummy.next;
	}



	public static void main(String[] args) {

	}

}
