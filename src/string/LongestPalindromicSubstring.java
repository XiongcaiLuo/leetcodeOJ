package string;

import algs4.Manacher;

/**
 * Given a String S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 * 
 * @author luoxiongcai
 *
 */
public class LongestPalindromicSubstring {

	/**
	 * @param args
	 */
	private int start = 0;
	private int end = 0;
	private int max = 0;

	public String longestPalindrome(String s) {
		if (s.length() < 2)
			return s;
		for (int i = 0; i < s.length() - 1; i++) {
			getCurMaxLen(s, i, i);
			getCurMaxLen(s, i, i + 1);
		}
		return s.substring(start, end + 1);
	}

	private void getCurMaxLen(String s, int i, int j) {
		if (i != j && s.charAt(i) != s.charAt(j))
			return;
		for (; i >= 0 && j < s.length(); i--, j++) {
			if (s.charAt(i) != s.charAt(j))
				break;
		}
		if (j - i - 1 > max) {
			max = j - i - 1;
			start = i + 1;
			end = j - 1;
		}
	}

	/**
	 * nice solution:
	 * http://articles.leetcode.com/2011/11/longest-palindromic-substring-part-i.html
	 * @param s
	 * @param c1
	 * @param c2
	 * @return
	 */
	private String expandAroundCenter(String s, int c1, int c2) {
		int L = c1, R = c2;
		int n = s.length();
		while (L >= 0 && R <= n - 1 && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return s.substring(L + 1, R);
	}

	public String longestPalindromeSimple(String s) {
		int n = s.length();
		if (n == 0)
			return "";
		String longest = s.substring(0, 1); // a single char itself is a
											// palindrome
		for (int i = 0; i < n - 1; i++) {
			String p1 = expandAroundCenter(s, i, i);
			if (p1.length() > longest.length())
				longest = p1;

			String p2 = expandAroundCenter(s, i, i + 1);
			if (p2.length() > longest.length())
				longest = p2;
		}
		return longest;
	}
	
	/**
	 * 帅的没朋友的方法。O（n)
	 * @param s
	 * @return
	 */
	public String longestPalindrome_manacher(String s) {
		Manacher ma = new Manacher(s);
		return ma.longestPalindromicSubstring();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long sTime = System.currentTimeMillis();
		LongestPalindromicSubstring lp = new LongestPalindromicSubstring();
		// String
		String s = "babcbabcbaccba";
		String sub = lp.longestPalindrome_manacher(s);
		System.out.println(sub);
		System.out.println("time:" + (System.currentTimeMillis() - sTime));

	}

}
