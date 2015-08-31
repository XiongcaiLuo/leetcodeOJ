package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 * 
 * For example, given: s: "barfoothefoobarman" words: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. (order does not matter).
 * 
 * @author luoxiongcai
 *
 */
public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
    	int wordNum = words.length;
    	int wordLen  = words[0].length();
    	List<Integer> result = new ArrayList<Integer>();
    	if (wordNum * wordLen > s.length())
    		return result;
    	Map<String,Integer> expect = new HashMap<String,Integer>();
    	for (String w : words){
    		expect.put(w, expect.containsKey(w) ? expect.get(w) + 1 : 1);
    	}
    	int i = 0;
    	while ( i <= s.length() - wordNum * wordLen){
    		if (expect.containsKey(s.substring(i, i+wordLen))){
    			Map<String,Integer> left = new HashMap<String,Integer>(expect);
    			int j = i;
    			for (; j < wordNum *wordLen + i ; j += wordLen){
    				String sub = s.substring(j,j+wordLen);
    				if (!left.containsKey(sub))
    					break;
    				else {
    					int c = left.get(sub) - 1;
    					if ( c == 0)
    						left.remove(sub);
    					else left.put(sub, c);
    				}
    			}
    			if ( j == wordNum *wordLen + i )
    				result.add(i);
    		}
    		i++;
    	}
    	return result;
    }
	public static void main(String[] args) {
		SubstringwithConcatenationofAllWords sc = new SubstringwithConcatenationofAllWords();
		String s ="barfoothefoobarman";
		String[] words = {"foo", "bar"};
		List<Integer> result = sc.findSubstring(s, words);
		System.out.println(result);
	}

}
