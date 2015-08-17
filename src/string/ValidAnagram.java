package string;

import java.util.Arrays;

/**
 * to determin if two string are anagrams, which means they have the same number
 * of chars in the same type of char.
 * 
 * @author luoxiongcai
 *
 */
public class ValidAnagram {
	/**
	 * use sort
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isAnagram(String s, String t) {
		char[] cs = s.toCharArray();
		char[] ct = t.toCharArray();
		Arrays.sort(cs);
		Arrays.sort(ct);
		return Arrays.equals(cs, ct);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
