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



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
