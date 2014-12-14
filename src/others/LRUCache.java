package others;

import java.util.HashMap;



class Node{
	int key;
	int value;
	Node pre;
	Node next;
	Node(int key,int value){
		this.key= key;
		this.value=value;
		pre=null;
		next=null;
	}
}

class MyDqueue{
	Node dummy=new Node(-1,-1);
	Node endPtr=dummy;
	int length=0;
	
	public void offerFirst(Node n){
		if(length == 0){
			dummy.next=n;
			n.pre=dummy;
			length++;
			endPtr=n;
			return;
		}
		Node oldFirst=dummy.next;
		dummy.next=n;
		n.pre=dummy;
		n.next=oldFirst;
		oldFirst.pre=n;
		length++;
			
	}
	
	public void moveToFirst(Node n){
		if(length==0 || length ==1)
			return;
		if(n==endPtr){
			delEnd();
			offerFirst(n);
			return ;
		}
		else if(n==dummy.next)
			return;
		Node nPre = n.pre , nNext=n.next;
		nPre.next=nNext;
		nNext.pre=nPre;
		offerFirst(n);
	}
	
	public Node delEnd(){
		if(length == 0) return null;
		Node del=endPtr;
		endPtr=del.pre;
		endPtr.next=null;
		length--;
		return del;
		
	}
}

public class LRUCache {

	private int capacity;
	HashMap<Integer, Node> maps=new HashMap<Integer, Node>();
	MyDqueue dq=new MyDqueue();
	
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }
    
    public int get(int key) {
    	Node cur=maps.get(key);
    	if(cur == null) return -1;
    	dq.moveToFirst(cur);
    	return cur.value;
    }
    
    public void set(int key, int value) {
    	Node cur=maps.get(key);
    	if(cur !=null){
    		cur.value=value;
    		dq.moveToFirst(cur);
    		return;
    	}
    	
    	if(maps.size()==capacity){
    		Node del=dq.delEnd();
    		maps.remove(del.key);
    	}
		Node n=new Node(key,value);
		maps.put(key, n);
		dq.offerFirst(n);
    }
    
 
    
	public static void main(String[] args) {
		LRUCache t=new LRUCache(2);
		t.set(2,1);
		t.set(1,1);
		t.set(2,3);
		t.set(4,1);
		int a=t.get(1);
		System.out.println(a);
		int b=t.get(2);
		System.out.println(b);
		


	}

}
