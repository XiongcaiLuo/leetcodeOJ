package others;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the emtpy string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * 
 * @param args
 */
public class MinimumWindowSubstring {

	/**
	 * scan and shrink.
	 * @param s
	 * @param t
	 * @return
	 */
    public String minWindow(String s, String t) {
        int[] expect = new int[256];
        int[] appear = new int[256];
        for (char ct : t.toCharArray()){
        	expect[ct]++;
        }
        int count = 0;
        int start = 0;
        int min = Integer.MAX_VALUE;
        int minstart = -1, minend = -1;
        for (int i = 0 ; i < s.length(); i++){
        	char c = s.charAt(i);
        	if (expect[c] != 0 && (++appear[c]) <= expect[c]){
        		count++;
        	}
        	if (count == t.length()){
        		while (true){
        			if (expect[s.charAt(start)] == 0) start++;
        			else if (appear[s.charAt(start)] > expect[s.charAt(start)]){
        				appear[s.charAt(start++)]--;
        			} else break;
        		}
        		if (min > i - start + 1){
        			min = i -  start + 1;
        			minstart = start;
        			minend = i;
        		}
        		appear[s.charAt(start++)]--;
        		count--;
        	}
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(minstart, minend+1);
    }

	public static void main(String[] args) {
		MinimumWindowSubstring mw = new MinimumWindowSubstring();
		String s = "cabwefgewcwaefgcf";
		String t =  "cae";
		String re = mw.minWindow(s, t);
		System.out.println(re);
	}

}
