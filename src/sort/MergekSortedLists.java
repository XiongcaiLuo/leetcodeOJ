package sort;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * @author luoxiongcai
 *
 */
public class MergekSortedLists {

	/**
	 * use a priority queue.
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists.size() == 0)
			return null;
		PriorityQueue<ListNode> nodes = new PriorityQueue<ListNode>(
				lists.size(), new Comparator<ListNode>() {
					@Override
					public int compare(ListNode o1, ListNode o2) {
						return o1.val - o2.val;
					}

				});
		ListNode dummy = new ListNode(-1);
		ListNode tail = dummy;
		for (ListNode root : lists) {
			if (root != null)
				nodes.add(root);
		}
		while (!nodes.isEmpty()) {
			ListNode cur = nodes.poll();
			tail.next = cur;
			tail = cur;
			tail.next = null;
			if (cur.next != null)
				nodes.add(cur.next);
		}
		return dummy.next;

	}
	/**
	 * reuse merge2Lists();
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists2(List<ListNode> lists) {
		if (lists.isEmpty()) return null;
		int begin = 0, end = lists.size() - 1;
		while (end > 0){
			begin = 0;
			while (begin < end){
				lists.set(begin, mergeTwoLists(lists.get(begin), lists.get(end)));
				begin++;
				end--;
			}
		}
		return lists.get(0);
	}
	
	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
