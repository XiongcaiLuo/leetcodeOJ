package others;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * @author luoxiongcai
 *
 */
class ValTime {
	int value;
	int timeStamp;
	ValTime(int value, int timeStamp){
		this.value = value;
		this.timeStamp = timeStamp;
	}
}

public class LRUCache {
	public int capacity;
	public int timeStamp;
	public HashMap<Integer,ValTime> data;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        timeStamp=Integer.MIN_VALUE+1;
        data =  new HashMap<Integer, ValTime>();
    }
    
    public int get(int key) {
    	if(!data.containsKey(key)) return -1;
    	int n=data.get(key).value;
    	data.put(key, new ValTime(n,timeStamp++));
    	return n;
    }
    
    public void set(int key, int value) {
        if(data.containsKey(key))
        	data.put(key, new ValTime(value,timeStamp++));
        else{
        	if(capacity>data.size())
        		data.put(key, new ValTime(value,timeStamp++));
        	else{
        		int minKey=Integer.MIN_VALUE;
        		int minTime=Integer.MIN_VALUE;
        		Iterator<Entry<Integer,ValTime>> ite= data.entrySet().iterator();
        		while(ite.hasNext()){
        			Entry<Integer,ValTime> en=ite.next();
        			if(en.getValue().timeStamp < minTime){
        				minTime=en.getValue().timeStamp;
        				minKey=en.getKey();
        			}
        		}
        		data.remove(key);
        		data.put(key, new ValTime(value,timeStamp++));
        	}
        }
    }
    
    public static void main(String[] args){
    	TreeMap<Integer,ValTime> data= new TreeMap<Integer, ValTime>();
    	data.put(1, new ValTime(1,-3));
    	data.put(2, new ValTime(1,-95));
    	data.put(-1, new ValTime(1,-700));
    	data.put(0, new ValTime(1,6));
    	
    	System.out.println(data.lastEntry().getValue().timeStamp);
    	
    }
}
