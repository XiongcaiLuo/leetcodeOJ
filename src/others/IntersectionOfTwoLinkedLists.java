package others;
/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 * @author luoxiongcai
 *
 */

 class ListNode {
	      int val;
	     ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	     }
	  }

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	    int lenA=0,lenB=0;
	    ListNode ptra=headA,ptrb=headB;
	    while(ptra!=null){
	    	lenA++;
	    	ptra=ptra.next;
	    }
	    while(ptrb!=null){
	    	lenB++;
	    	ptrb=ptrb.next;
	    }
	    int ca=Math.abs(lenA-lenB);
	    ptra=headA;ptrb=headB;
	    if(lenA>lenB){
	    	for(int i=0;i<ca;i++)
	    		ptra=ptra.next;
	    }else{
	    	for(int i=0;i<ca;i++)
	    		ptrb=ptrb.next;
	    }
	    
	    while(ptra!=null && ptrb!=null && ptra.val!=ptrb.val){
	    	ptra=ptra.next;
	    	ptrb=ptrb.next;
	    }
	    return ptra;
	}
}
