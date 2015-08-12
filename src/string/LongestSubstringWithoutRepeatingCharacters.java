package string;

import java.util.Arrays;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * no whitespaces.
 * @author luoxiongcai
 *
 */

public class LongestSubstringWithoutRepeatingCharacters {

	/**
	 * @param args
	 */

	public static int lengthOfLongestSubstring(String s) {
		int max = 0;
		int [] index = new int [256];
		Arrays.fill(index, -1);
		for (int i=0, j = 0; i < s.length() ; i++){
			if ( index[s.charAt(i)] >= j){
				j = index[s.charAt(i)] + 1;
			}
			index[s.charAt(i)] = i;
			max = Math.max(max, i - j + 1);
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bbbwdb";
		System.out.println(lengthOfLongestSubstring(s));
	}

}
