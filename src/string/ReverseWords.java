package string;

import java.util.ArrayList;

/**
 * Given an input string, reverse the string word by word.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the". 1. use
 * split() and trim(); 2. do not use lib function.
 * 
 * @author luoxiongcai
 *
 */
public class ReverseWords {

	/**
	 * using split
	 * 
	 * @param args
	 */
	public static String reverseWords(String s) {
		if (s == null)
			return null;
		if (s.trim().isEmpty())
			return "";
		String[] words = s.trim().split("\\s+");
		StringBuffer rW = new StringBuffer();
		int len = words.length;
		for (int i = 0; i < len; i++) {
			rW.append(words[len - 1 - i].trim() + " ");
		}
		return rW.toString().trim();
	}

	/**
	 * do not use split(),trim(); scan just pass, from the end to the beginning.
	 * 
	 * @param s
	 * @return
	 */
	public static String reverseWords2(String s) {
		if (s.isEmpty())
			return s;
		StringBuilder sb = new StringBuilder();
		int j = s.length();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ')
				j = i;
			else if (i == 0)
				sb.append(s.substring(i, j));
			else if (s.charAt(i - 1) == ' ')
				sb.append(s.substring(i, j) + " ");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "   a   b  ";
		System.out.println(reverseWords2(a));
	}

}
