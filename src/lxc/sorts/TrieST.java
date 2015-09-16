package lxc.sorts;

import java.util.LinkedList;
import java.util.Queue;

/**
 * R-way trie.
 * no deletion.
 * @author luoxiongcai
 *
 * @param <V>
 */
public class TrieST <V> {
	private static final int R = 256;
	private Node root;
	private int N;
	private static class Node{
		Object v;
		Node[] next = new Node[R];
	}
	
	public void put(String key, V value){
		root = put(root, key, value, 0);
	}
	
	private Node put(Node cur, String key, V value, int d) {
		if (cur == null)
			cur = new Node();
		if (d == key.length()){
			if (cur.v == null) N++;
			cur.v = value;
			return cur;
		}
		cur.next[key.charAt(d)] = put(cur.next[key.charAt(d)], key, value, d + 1);
		return cur;
	}

	public V get(String key){
		Node x = get(root, key, 0);
		if (x == null) return null;
		return (V) x.v;
	}
	
	private Node get(Node cur, String key, int d){
		if (cur == null) return null;
		if ( d == key.length()){
			return cur;
		}
		return get(cur.next[key.charAt(d)], key, d + 1);
		
	}
	
	public boolean contains(String key){
		return get(key) != null;
	}
	
	/**
	 * return all keys that starts with the given prefix.
	 * @param prefix
	 * @return
	 */
	public Iterable<String> keysWithPrefix(String prefix){
		Node preNode = get(root, prefix, 0);
		Queue<String> queue = new LinkedList<String>();
		StringBuilder sb = new StringBuilder(prefix);
		collect(preNode, sb, queue);
		return queue;
	} 
	
	private void collect(Node cur, StringBuilder sb, Queue<String> queue){
		if (cur == null) return;
		if (cur.v != null){
			queue.offer(sb.toString());
		}
		for (int i = 0; i < R; i++){
			sb.append((char)i);
			collect(cur.next[i], sb, queue);
			sb.deleteCharAt(sb.length() - 1);
		}
			
	}
	
	/**
	 * return the key, which is the longest prefix of the given query.
	 * @param query
	 * @return
	 */
	public String longestPrefixof(String query){
		int len = search(root, query, 0,0);
		return query.substring(0, len);
	}
	

	private int search(Node cur, String query, int d, int len) {
		if (cur == null || d == query.length())
			return len;
		if (cur.v != null){
			len = d;
		}
		return search(cur.next[query.charAt(d)], query, d + 1, len);
	}
	
	public int size(){
		return N;
	}
	
	/**
	 * contains wildcard '.' that matches any single character.
	 * @param pattern
	 * @return
	 */
	public Iterable<String> keysThatMatch(String pattern){
		Queue<String> queue = new LinkedList<String>();
		StringBuilder prefix = new StringBuilder();
		collect(root, prefix, pattern, queue);
		return queue;
	}
	
	private void collect(Node cur, StringBuilder prefix, String pattern, Queue<String> queue){
		if (cur == null) return;
		int d = prefix.length();
		if (d == pattern.length()){
			if (cur.v != null)
				queue.add(prefix.toString());
			return;
		}
        char c = pattern.charAt(d);
        if (c == '.') {
            for (char ch = 0; ch < R; ch++) {
                prefix.append(ch);
                collect(cur.next[ch], prefix, pattern, queue);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
        else {
            prefix.append(c);
            collect(cur.next[c], prefix, pattern, queue);
            prefix.deleteCharAt(prefix.length() - 1);   // to 
        }
	}

	public static void main(String[] args) {
		TrieST<Integer>  trie = new TrieST<Integer>();
		trie.put("lxc", 320000);
		trie.put("liu",300000);
		trie.put("xia", 900000);
		System.out.println("size:"+trie.size());
		int v = trie.get("lxc");
		System.out.println("lxc:"+v);
		System.out.println(trie.contains("xia"));
		for (String key : trie.keysWithPrefix("l"))
			System.out.println(key);
		System.out.println(trie.longestPrefixof("lxchaha"));
		System.out.println((int)'A');
		
		for (String key : trie.keysThatMatch(".i.")){
			System.out.println("match:"+ key);
		}
		
		
	}

}
