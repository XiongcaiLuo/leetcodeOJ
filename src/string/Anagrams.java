package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Anagrams {

	/**
	 * Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
	 * @param args
	 */
	public List<String> anagrams(String[] strs) {
        HashMap<String,ArrayList<String>> candis=new HashMap<String,ArrayList<String>>();
        for(int i=0;i<strs.length;i++){
        	char[] chars=strs[i].toCharArray();
        	Arrays.sort(chars);
        	String key=new String(chars);
        	if(candis.containsKey(key)){
        		ArrayList<String> candiStr=candis.get(key);
        		candiStr.add(strs[i]);
        		candis.put(key, candiStr);
        	}else{
        		ArrayList<String> candiStr=new ArrayList<String>();
        		candiStr.add(strs[i]);
        		candis.put(key, candiStr);
        	}
        }
        ArrayList<String> result=new  ArrayList<String>();
        for(Entry<String,ArrayList<String>>entry: candis.entrySet()){
        	if(entry.getValue().size()>1){
        		result.addAll(entry.getValue());
        	}
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
