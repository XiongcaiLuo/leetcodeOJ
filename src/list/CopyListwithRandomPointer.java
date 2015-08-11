package list;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list
 * 
 * @author luoxiongcai
 *
 */
class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}

public class CopyListwithRandomPointer {

	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode p = head;
		while (p != null){
			RandomListNode copy = new RandomListNode(p.label);
			copy.next = p.next;
			p.next = copy;
			p = copy.next;
		}
		p = head;
		while (p != null){
			RandomListNode copy_next = p.random == null ? null : p.random.next;
			p.next.random = copy_next;
			p = p.next.next;
		}
		// separate the two lists.
		RandomListNode dummy = new RandomListNode(-1);
		RandomListNode tail = dummy;
		p = head;
		while (p != null){
			RandomListNode copy = p.next;
			tail.next = copy;
			tail = tail.next;
			p.next = copy.next;
			p = p.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
