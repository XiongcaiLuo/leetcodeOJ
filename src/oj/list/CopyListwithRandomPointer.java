package oj.list;

import java.util.HashMap;

class RandomListNode {
	    int label;
	    RandomListNode next, random;
	    RandomListNode(int x) { this.label = x; }
	 }
public class CopyListwithRandomPointer {

	/**
	 * Copy List with Random Pointer
	 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
	 * @param args
	 */
	
    public static RandomListNode copyRandomList(RandomListNode head) {
    	if(head==null) return null;
        HashMap<RandomListNode,RandomListNode> maps=new HashMap<RandomListNode,RandomListNode>();
        RandomListNode cur=head;
        RandomListNode cHead=new RandomListNode(head.label);
        RandomListNode cCur=cHead;
        maps.put(head, cHead);
        while(cur.next!=null){
        	 RandomListNode cNode=new RandomListNode(cur.next.label);
        	 cCur.next=cNode;
        	 cCur=cNode;
        	 maps.put(cur.next, cNode);
        	 cur=cur.next;
        }
        cur=head;
        cCur=cHead;
        while(cur!=null&&cCur!=null){
        	RandomListNode random=maps.get(cur.random);
        	cCur.random=random;
        	cur=cur.next;
        	cCur=cCur.next;
        }
        return cHead;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
