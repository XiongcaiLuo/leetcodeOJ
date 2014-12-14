package tails;
/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * @author luoxiongcai
 *
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next==null ) return head;
        ListNode fast=head, slow = head;
        while(fast.next!= null && fast.next.next != null){
            fast =  fast.next.next;
            slow = slow.next;
        }
        
        fast=slow;
        slow=slow.next;
        fast.next=null;
        
        ListNode head1 = sortList(head);
        ListNode head2 =  sortList(slow);
        return merge(head1, head2);
     }
     
     private ListNode merge(ListNode head1, ListNode head2){
         if(head1 == null) return head2;
         if(head2 ==  null ) return head1;
         ListNode dummy = new ListNode(-1);
         ListNode p =  dummy;
         while(head1 != null && head2 != null){
             if(head1.val < head2.val){
                 p.next = head1;
                 head1 = head1.next;
             }else{
                 p.next = head2;
                 head2 = head2.next;
             }
             p = p.next;
         }
         if(head1 == null)
             p.next=head2;
         if(head2 == null)
             p.next=head1;
         return dummy.next;
     }
        
}
