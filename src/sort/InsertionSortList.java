package sort;

public class InsertionSortList {

	/**
	 * Sort a linked list using insertion sort.
	 * @param args
	 */
    public ListNode insertionSortList(ListNode head) {
    	if(head==null) return head;
        ListNode dummy=new ListNode(-1);

        while(head!=null){
        	ListNode ptr=search(dummy,head);
        	if(ptr.next==null){
        		ptr.next=head;
        		head=head.next;
        		ptr.next.next=null;
        	}else{
        		ListNode next=ptr.next;
        		ListNode cur=head;
        		head=head.next;
        		ptr.next=cur;
        		cur.next=next;
        	}
        		
        }
        return dummy.next;
    }
    
    private ListNode search(ListNode dummy, ListNode head){
    	if(dummy.next==null)
    		return dummy;
    	ListNode ptr=dummy;
    	while(ptr.next!=null && ptr.next.val<head.val)
    		ptr=ptr.next;
    	return ptr;
    }
    public static void printList(ListNode root){
    	ListNode ptr=root;
    	while(ptr!=null){
    		System.out.println(ptr.val);
    		ptr=ptr.next;
    	}
    }
	public static void main(String[] args) {
		InsertionSortList t=new InsertionSortList();
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(1);
		n1.next=n2;
		ListNode root=t.insertionSortList(n1);
		t.printList(root);
	}

}
