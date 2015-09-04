package tree;

import java.util.ArrayList;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */
public class ConvertSortedListtoBinarySearchTree {

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		return sortBST(head, null);

	}
	
	/**
	 * 利用快慢指针获得中间元素。 时间复杂度o(nlgn)
	 * @param head
	 * @param exTail
	 * @return
	 */
	private TreeNode sortBST(ListNode head, ListNode exTail){
		if (head == exTail)
			return null;
		ListNode slow =head, fast = head;
		while (fast.next != exTail && fast.next.next != exTail){
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode subRoot = new TreeNode(slow.val);
		subRoot.left = sortBST(head, slow);
		subRoot.right = sortBST(slow.next, exTail);
		return subRoot;
	}

	/**
	 * bottom-up ： the loop invariant:
	 * 
	 * how to explain?
	 * @param head
	 * @return
	 */
	ListNode head ;
	public TreeNode sortedListToBST2(ListNode head) {
		this.head = head;
		int len = getLen(head);
		return sort(0,len - 1);
	}
	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	private TreeNode sort( int start, int end){
		if (head == null || start > end) return null;
		int mid = (start + end) / 2;
		TreeNode leftRoot = sort(start, mid - 1);
		TreeNode parent = new TreeNode(head.val);
		parent.left = leftRoot;
		head = head.next;
		parent.right = sort( mid + 1, end);
		return parent;
		
	}
	
	private int getLen(ListNode head){
		int count = 0;
		while (head != null){
			count++;
			head = head.next;
		}
		return count;
	}

	public static void main(String[] args) {
		ListNode n0 = new ListNode(0);
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n0.next = n1;
		n1.next = n2;
		ConvertSortedListtoBinarySearchTree cbs = new ConvertSortedListtoBinarySearchTree();
		TreeNode root = cbs.sortedListToBST2(n0);
		System.out.println(root);
	}

}
