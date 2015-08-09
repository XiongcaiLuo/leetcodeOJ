package list;


public class AddTwoNumers {

	/**
	 * @param args
	 */
	private static class ListNode{
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1=l1;
        ListNode p2=l2;
        ListNode head=new ListNode(0);
        ListNode resultPtr=head;
        int jinwei=0;
        while(p1!=null && p2!=null){
        	resultPtr.next=new ListNode(0);
        	resultPtr=resultPtr.next;
        	int digitSum=p1.val+p2.val+jinwei;
        	if(digitSum>9){
        		resultPtr.val=digitSum-10;
        		jinwei=1;
        	}
        	else{
        		resultPtr.val=digitSum;
        		jinwei=0;
        	}
        	p1=p1.next;
        	p2=p2.next;
        	
        }

        if(p1==null &&p2!=null){
        	while(p2!=null){
            	resultPtr.next=new ListNode(0);
            	resultPtr=resultPtr.next;
        		int digitSum=p2.val+jinwei;
        		if(digitSum>9){
               		resultPtr.val=digitSum-10;
            		jinwei=1;
        		}
        		else{
            		resultPtr.val=digitSum;
            		jinwei=0;
        		}
        		p2=p2.next;
        	}
        }
        else if(p2==null &&p1!=null){
        	while(p1!=null){
               	resultPtr.next=new ListNode(0);
            	resultPtr=resultPtr.next;
        		int digitSum=p1.val+jinwei;
        		if(digitSum>9){
               		resultPtr.val=digitSum-10;
            		jinwei=1;
        		}
        		else{
            		resultPtr.val=digitSum;
            		jinwei=0;
        		}
        		p1=p1.next;
        	}
        }
        if(p1==null && p2==null){
        	if(jinwei==1){
        		resultPtr.next=new ListNode(1);
            	resultPtr=resultPtr.next;
        	}
        }
        return head.next;
    }
    
    public static void print(ListNode head){
    	while(head!=null){
    		System.out.print(head.val+"->");
    		head=head.next;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1=new ListNode(2); 
		ListNode a2=new ListNode(4); 
		ListNode a3=new ListNode(3); 
		a2.next=a3;
		a1.next=a2;
		
		ListNode b1=new ListNode(5); 
		ListNode b2=new ListNode(6); 
		ListNode b3=new ListNode(4); 
		b2.next=b3;
		b1.next=b2;
		
		ListNode head=addTwoNumbers(a1,b1);
		print(head);
		
		
	}

}
