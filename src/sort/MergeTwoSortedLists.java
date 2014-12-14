package sort;


public class MergeTwoSortedLists {

	/**
	 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
	 * @param args
	 */
    public  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        concat(dummy,l1,l2);
        return dummy.next;
    }
    private void concat(ListNode tail,ListNode root1,ListNode root2){
    	if(root1==null){
    		tail.next=root2;
    	}else if( root2==null){
    		tail.next=root1;
    	}else{
    		if(root1.val<=root2.val){
    			ListNode next1=root1.next;
    			tail.next=root1;
    			root1.next=null;
    			tail=root1;
    			concat(tail,next1,root2);
    		}else{
    			ListNode next2=root2.next;
    			tail.next=root2;
    			root2.next=null;
    			tail=root2;
    			concat(tail,root1,next2);
    		}
    	}
    }
    public static void printList(ListNode root){
    	ListNode ptr=root;
    	while(ptr!=null){
    		System.out.println(ptr.val);
    		ptr=ptr.next;
    	}
    }
	public static void main(String[] args) {

		
	}

}
