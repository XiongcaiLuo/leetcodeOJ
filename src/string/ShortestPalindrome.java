package string;

import algs4.Manacher;

/**
 * Given a string S, you are allowed to convert it to a palindrome by adding
 * characters in front of it. Find and return the shortest palindrome you can
 * find by performing this transformation.
 * 
 * For example:
 * 
 * Given "aacecaaa", return "aaacecaaa".
 * 
 * Given "abcd", return "dcbabcd".
 * 
 * @author luoxiongcai
 *
 */
public class ShortestPalindrome {
	
	/**
	 * o(n^2),maybe time limited error.
	 */
	private int min = Integer.MAX_VALUE;
	private String res = "";
    public String shortestPalindrome(String s) {
        if ( s.isEmpty()) return res;
        int len = s.length();
        for (int j = (len-1) / 2; j >=0; j--){
        	spread(s,j,j);
        }
        for (int j = len / 2; j >= 1; j--)
        	spread(s,j - 1, j);
        return res;
    }
    
    private void spread(String s, int i, int j){
    	StringBuilder sb = new StringBuilder();
    	int k = 0;
    	for (; k <= i; k++){
    		if (s.charAt(i-k) != s.charAt(j+k))
    			return;
    	}
    	if (j+k < s.length())
    		sb.append(s.substring(j+k, s.length())).reverse();
    	String p = sb.toString()+s;
    	if (p.length() < min){
    		min = p.length();
    		res = p;
    	}
    }
    /**
     * 帅的没朋友的方法。
     * @param s
     * @return
     */
    public String shortestPalindrome_manacher(String s) {
        if ( s.isEmpty()) return "";
        Manacher ma = new Manacher(s);
        String palin = ma.longestPalindromicSubstring_start();
        StringBuilder sb = new StringBuilder(s.substring(palin.length(), s.length()));
        return sb.reverse()+s;
    }
    
	public static void main(String[] args) {
		ShortestPalindrome sp = new ShortestPalindrome();
		String s = "abcd";
		String res = sp.shortestPalindrome_manacher(s);
		System.out.println(res);
		
	}

}
