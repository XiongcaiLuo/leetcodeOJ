package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * given a string, result all the anagrams of that string.
 * what if there are duplicated chars?
 * @author luoxiongcai
 *
 */
public class Anagrams2 {
	/**
	 * 
	 * @param s
	 * @return
	 */
	public List<String> anagrams(String s){
		if ( s.length() ==0) return new ArrayList<String>();
		List<String> result = new ArrayList<String>(new HashSet<String>(subNext(s,0)));
		return result;
	}
	
	private List<String> subNext(String s, int begin){
		List<String> anas = new ArrayList<String>();
		if (begin == s.length() - 1){
			anas.add(""+s.charAt(begin));
			return anas;
		}
		List<String> next = subNext(s,begin+1);
		int size = next.size();
		for (int i =0; i < size; i++){
			anas.addAll(insertDup(next.get(i),s.charAt(begin)));  // here;
		}
		return anas;
	}
	
	/** 
	 * no duplicates.
	 * @param s
	 * @param c
	 * @return
	 */
	private List<String> insert(String s, char c){
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++)
			result.add(s.substring(0, i)+c+s.substring(i));
		result.add(s+c);
		return result;
	}
	
	/** 
	 * if there are duplicates.
	 * @param s
	 * @param c
	 * @return
	 */
	private List<String> insertDup(String s, char c){
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++){
			if (i > 0 && c == s.charAt(i-1))                   //duplicates
				continue;
			result.add(s.substring(0, i)+c+s.substring(i));	
		}
		if (c != s.charAt(s.length()-1))
			result.add(s+c);
		return result;
	}
	/**
	 * use hashmap + dfs.
	 * @param s
	 * @return
	 */
	private Map<Character,Integer> charCount = new HashMap<Character,Integer>();
	private List<String> results = new ArrayList<String>();
	public List<String> anagrams2(String s){
		for (char c : s.toCharArray()){
			Integer count = charCount.get(c);
			charCount.put(c, count == null ? 1 : count+1);
		}
		subNext2(new HashMap<Character,Integer>(charCount),"",s.length());
		return results;
		
	}
	
	private void subNext2(Map<Character,Integer> left,String str,int len){
		if (str.length() == len){
			results.add(str);
			return;
		}
		for(Entry<Character,Integer> entry : left.entrySet()){
			HashMap<Character,Integer> newLeft = new HashMap<Character,Integer>(left);
			String newStr = str + entry.getKey();
			newLeft.put(entry.getKey(), entry.getValue() - 1);
			if (newLeft.get(entry.getKey()) == 0) newLeft.remove(entry.getKey());
			subNext2(newLeft,newStr,len);
		}
	}
	public static void main(String[] args) {
		Anagrams2 ag = new Anagrams2();
		String s="aabb";
		List<String> anas = ag.anagrams2(s);
		System.out.println(anas);
	}

}
