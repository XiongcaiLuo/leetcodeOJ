package string;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume
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
	public  String longestPalindrome(String s) {
		if (s.length() < 2)
			return s;
		for(int i = 0; i < s.length() - 1; i++){
			getCurMaxLen(s, i, i);
			getCurMaxLen(s, i, i + 1);
		}
		return s.substring(start, end + 1);
	}
	
	private void getCurMaxLen(String s, int i, int j){
		if ( i != j && s.charAt(i) != s.charAt(j))
			return ;
		for(; i >= 0 && j < s.length(); i--, j++){
			if ( s.charAt(i) != s.charAt(j))
				break;
		}
		if (j - i - 1 > max){
		    max = j - i - 1;
		    start = i + 1;
		    end = j - 1;
		} 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long sTime = System.currentTimeMillis();
		LongestPalindromicSubstring lp = new LongestPalindromicSubstring();
		// String
		String s = "bb";
		String sub =lp.longestPalindrome(s) ;
		System.out.println(sub);
		System.out.println("time:" + (System.currentTimeMillis() - sTime));

	}

}
