package oj.list;
/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
 */
class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val=x;
		next=null;
	}
}
public class ReverseLinkedListII {

	/**
	 * @param args
	 */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n) return head;
        ListNode flag=new ListNode(-1);
        flag.next=head;
        ListNode ptr=flag;
        for(int i=1;i<m;i++)
        	ptr=ptr.next;
        ListNode mptr_front=ptr;
        ptr=ptr.next;          //mptr;
        for(int i=m;i<n;i++){
        	ListNode movePtr=ptr.next;
        	ptr.next=movePtr.next;
        	movePtr.next=mptr_front.next;
        	mptr_front.next=movePtr;
//        	ptr=ptr.next;
        }
        
        return flag.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode m1=new ListNode(3);
		ListNode m2=new ListNode(5);
		ListNode m3=new ListNode(6);
		m1.next=m2;
		m2.next=m3;
		reverseBetween(m1,1,3);

	}

}
