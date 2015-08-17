package list;

import java.util.HashMap;

class CacheNode {
	int key;
	int value;
	CacheNode next = null;
	CacheNode prev = null;

	public CacheNode(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. set(key, value) - Set or insert the
 * value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new
 * item.
 * 
 * @param args
 */
public class LRUCache {

	int capacity;
	CacheNode dummy,tailDummy;
	HashMap<Integer, CacheNode> maps;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		maps = new HashMap<Integer, CacheNode>();
		dummy = new CacheNode(-1,-1);
		tailDummy = new CacheNode(-1,-1);
		tailDummy.prev = dummy;
		dummy.next = tailDummy;
	}

	public int get(int key) {
		CacheNode v = maps.get(key);
		if ( v == null)
			return -1;
		mvHead(v);
		return v.value;
	}

	public void set(int key, int value) {
		CacheNode v = maps.get(key);
		if (v != null){
			v.value = value;
			mvHead(v);
		} else {
			if (maps.size() == capacity){
				int tail = rmTail();
				maps.remove(tail);
			}
			CacheNode newNode = new CacheNode(key,value);
			insertHead(newNode);
			maps.put(key, newNode);
		}
	}
	
	private void mvHead(CacheNode v){
		v.next.prev = v.prev;
		v.prev.next = v.next;
		insertHead(v);
	}
	
	private int  rmTail(){
		CacheNode tail = tailDummy.prev;
		if (tail == dummy)
			return -1;
		CacheNode preTail = tail.prev;
		preTail.next = tailDummy;
		tailDummy.prev = preTail;
		return tail.key;
	}
	
	private void insertHead(CacheNode v){
		v.next = dummy.next;
		dummy.next.prev = v;
		dummy.next = v;
		v.prev = dummy;
	}
	
	
	

	public static void main(String[] args) {
		LRUCache c = new LRUCache(2);
		c.set(2, 22);
		c.set(1, 11);
		int d = c.get(2);
		System.out.println(d);
		c.set(4, 44);
		int r = c.get(1);
		System.out.println(r);
		r = c.get(2);
		System.out.println(r);
	}

}
