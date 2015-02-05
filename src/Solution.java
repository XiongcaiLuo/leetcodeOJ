import java.math.BigDecimal;

import tree.ListNode;


public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head  == null || head.next == null) return head;
        
        ListNode dummy= new ListNode(-1);
        dummy.next =head;
        ListNode smaller=dummy,preCur=dummy,cur =head;
        while(cur !=null){
            if(cur.val < x){
                ListNode temp =cur;
                preCur.next =cur.next;
                cur =cur.next;
                temp.next=smaller.next;
                smaller.next =temp;
                smaller =smaller.next;
            }
            else{
            	cur =cur.next;
            	preCur = preCur.next;
            }
        }
        return dummy.next;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode n1= new ListNode(1);
		ListNode n2= new ListNode(1);
		n1.next = n2;
		ListNode head = s.partition(n1, 2);
		System.out.println();
	}

}
