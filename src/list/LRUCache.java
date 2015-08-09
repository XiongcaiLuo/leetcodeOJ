package oj.list;

import java.util.HashMap;

class CacheNode{
	int key;
	int value;
	CacheNode next=null;
	CacheNode prev=null;
	public CacheNode(int key,int value){
		this.key=key;
		this.value=value;
	}
}


public class LRUCache {

	/**
	 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
	 * @param args
	 */
	
	int capacity;
	CacheNode preHead;
	CacheNode preEnd;
	HashMap<Integer,CacheNode> maps;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        maps=new HashMap<Integer, CacheNode>();
        preHead=new CacheNode(Integer.MAX_VALUE,-1);
        preEnd=new CacheNode(Integer.MIN_VALUE,-1);
        preHead.next=preEnd;
        preEnd.prev=preHead;
    }
    
    public  int get(int key) {
        if(!maps.containsKey(key)) return -1;
        CacheNode node=maps.get(key);
        int result=node.value;
        CacheNode begin=preHead.next;
        if (node==begin || capacity==1) return result;
        CacheNode pre=node.prev;
        
        pre.next=node.next;
        node.next.prev=pre;
        preHead.next=node;
        node.prev=preHead;
        node.next=begin;
        begin.prev=node;
      
        
        return result;
    }
    


	public void set(int key, int value) {
    	if(maps.containsKey(key)){
    		CacheNode node=maps.get(key);
    		node.value=value;
    		return;
    	}
        if(maps.size()<capacity){
        	if(maps.size()==0){
        		CacheNode node=new CacheNode(key,value);
        		node.prev=preHead;
        		preHead.next=node;
        		preEnd.prev=node;
        		node.next=preEnd;
        		maps.put(key, node);
        	}
        	else{
        		CacheNode begin=preHead.next;
        		CacheNode node=new CacheNode(key,value);
        		preHead.next=node;
        		node.prev=preHead;
        		node.next=begin;
        		begin.prev=node;
        		maps.put(key, node);
        	}
        }
        else{
        	CacheNode begin=preHead.next;
        	CacheNode end=preEnd.prev;
    		CacheNode node=new CacheNode(key,value);
    		preHead.next=node;
    		node.prev=preHead;
    		node.next=begin;
    		begin.prev=node;
    		begin=node;
    		maps.put(key, node);
    		
        	maps.remove(end.key);
        	end.prev.next=preEnd;
        	preEnd.prev=end.prev;
        	
        	
        }
    }
	public static void main(String[] args) {
		LRUCache c=new LRUCache(2);
		c.set(2, 1);
		c.set(1, 1);
		int d=c.get(2);
		System.out.println(d);
		c.set(4, 1);
//		c.set(4, 1);
		int r=c.get(1);
		System.out.println(r);
		r=c.get(2);
		System.out.println(r);
	}

}
