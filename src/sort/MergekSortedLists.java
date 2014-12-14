package sort;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergekSortedLists {

	/**
	 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
	 * @param args
	 */
	/**
	 * 单纯利用merge2list会超时
	 * @param lists
	 * @return
	 */
//    public ListNode mergeKLists(List<ListNode> lists) {
//    	if(lists.size()==0) return null;
//    	else if(lists.size()==1) return lists.get(0);
//    	ListNode result=mergeTwoLists(lists.get(0), lists.get(1));
//        for(int i=2;i<lists.size();i++){
//        	result=mergeTwoLists(result, lists.get(i));
//        }
//        return result;
//    }
//    public  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode dummy=new ListNode(-1);
//        concat(dummy,l1,l2);
//        return dummy.next;
//    }
//    private  void concat(ListNode tail,ListNode root1,ListNode root2){
//    	if(root1==null){
//    		tail.next=root2;
//    	}else if( root2==null){
//    		tail.next=root1;
//    	}else{
//    		if(root1.val<=root2.val){
//    			ListNode next1=root1.next;
//    			tail.next=root1;
//    			root1.next=null;
//    			tail=root1;
//    			concat(tail,next1,root2);
//    		}else{
//    			ListNode next2=root2.next;
//    			tail.next=root2;
//    			root2.next=null;
//    			tail=root2;
//    			concat(tail,root1,next2);
//    		}
//    	}
//    }
//    public  void printList(ListNode root){
//    	ListNode ptr=root;
//    	while(ptr!=null){
//    		System.out.println(ptr.val);
//    		ptr=ptr.next;
//    	}
//    }
	
	/**
	 * 利用 priorityQueue
	 * @param lists
	 * @return
	 */
    public ListNode mergeKLists(List<ListNode> lists) {
    	if(lists.size()==0) return null;
    	else if(lists.size()==1) return lists.get(0);
    	PriorityQueue<ListNode> nodes=new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){

			@Override
			public int compare(ListNode o1, ListNode o2) {
				if(o1.val>o2.val)
					return 1;
				else if(o1.val==o2.val)
					return 0;
				else return -1;
			}
    		
    	});
    	ListNode dummy=new ListNode(-1);
    	ListNode tail=dummy;
    	for(ListNode root: lists){
    		if(root!=null)
    			nodes.add(root);
    	}
    		
    	while(!nodes.isEmpty()){
    		ListNode  cur=nodes.poll();
    		ListNode cur_next=cur.next;
    		tail.next=cur;
    		tail=cur;
    		tail.next=null;
    		if(cur_next!=null)
    			nodes.add(cur_next);
    	}
    	return dummy.next;

    }
    
    
    
    public static void print(PriorityQueue<ListNode> nodes){
    	while(!nodes.isEmpty())
    		System.out.println(nodes.poll().val);
    }
	public static void main(String[] args) {
    	PriorityQueue<ListNode> nodes=new PriorityQueue<ListNode>(3, new Comparator<ListNode>(){

			@Override
			public int compare(ListNode o1, ListNode o2) {
				if(o1.val>o2.val)
					return 1;
				else if(o1.val==o2.val)
					return 0;
				else return -1;
			}
    		
    	});
    	nodes.add(new ListNode(2));
    	nodes.add(new ListNode(5));
    	nodes.add(new ListNode(4));
    	System.out.println(nodes.size());
    	print(nodes);
	}

}
