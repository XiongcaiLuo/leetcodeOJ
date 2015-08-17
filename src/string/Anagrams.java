package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given an array of strings, group anagrams together.
 * 
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], Return:
 * 
 * [ ["ate", "eat","tea"], ["nat","tan"], ["bat"] ] Note: For the return value,
 * each inner list's elements must follow the lexicographic order. All inputs
 * will be in lower-case.
 */
public class Anagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> anas = new HashMap<String,List<String>>();
        for (String s : strs){
        	char[] cs = s.toCharArray();
        	Arrays.sort(cs);
        	String ss = new String(cs);
        	List<String> list = anas.get(ss);
        	if ( list == null)
        		list = new ArrayList<String>();
        	list.add(s);
        	anas.put(ss, list);
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for(Entry<String,List<String>> entry : anas.entrySet()){
        	List<String> re = entry.getValue();
        	Collections.sort(re);
        	result.add(re);
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
