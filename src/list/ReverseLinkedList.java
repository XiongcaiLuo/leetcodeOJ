package list;

import sort.ListNode;

/**
 * reverse linked list. both itreative method and recursive method
 * @author luoxiongcai
 *
 */
public class ReverseLinkedList {
	/**
	 * iterative method.
	 * @param head
	 * @return
	 */
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode ptr = head;
        while (ptr != null){
        	ListNode cur = ptr;
        	ptr = ptr.next;
        	cur.next = dummy.next;
        	dummy.next = cur;
        }
        return dummy.next;
    }
    
    /**
     * recursive method.
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
