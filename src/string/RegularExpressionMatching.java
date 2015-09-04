package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character. '*' Matches zero or more of the preceding
 * element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * 
 * Some examples: isMatch("aa","a") → false isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false isMatch("aa", "a*") → true isMatch("aa", ".*") →
 * true isMatch("ab", ".*") → true isMatch("aab", "c*a*b") → true
 * 
 * @author luoxiongcai
 *
 */
public class RegularExpressionMatching {


	/**
	 * wild char .(only match the same character) * +
	 *  
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch2(String s, String p) {
		return helper2(s.toCharArray(), 0, p.toCharArray(), 0);
	}

	private boolean helper2(char[] cs, int begin1, char[] cp, int begin2) {

		if (begin1 == cs.length && begin2 == cp.length)
			return true;
		if (begin1 != cs.length &&begin2 == cp.length)
			return false;
		if (begin1 == cs.length && begin2 != cp.length){
			int len = cp.length - begin2;
			if (len % 2 == 1) return false;
			for (int i = begin2 + 1; i < cp.length; i+=2)
				if (cp[i] !='*')
					return false;
			return true;
		}
		int i = begin1, j = begin2;
		if ((j + 1 < cp.length && cp[j + 1] != '*' && cp[j+1] != '+') || j == cp.length - 1) {
			if ( cs[i] == cp[j] || cp[j] == '.') 
				return helper2(cs,i+1, cp, j+1);
			else return false;
		} else if (j + 1 < cp.length && (cp[j + 1] == '*' || cp[j+1] == '+')) {
			if (cp[j+1] == '*' && helper2(cs,i,cp,j+2))
				return true;
			if (cp[j+1]=='+' && (cp[j] != '.' && cs[i] != cp[j]))
				return false;
			char cur = cs[i];
			while (i < cs.length && (cs[i] == cp[j] || (cp[j] == '.' && cs[i] == cur))) {
				if (helper2(cs, i + 1, cp, j + 2))
					return true;
				i++;
			}
			return false;
		} 
		return false;
	}
	
	/**
	 * good.
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch3(String s, String p){
		return match3(s, 0, p, 0);
	}
	private boolean match3(String s, int si, String p, int pi){
		if (pi == p.length()) return si == s.length();
		if (charAt(p, pi + 1) != '*'){
			return ( charAt(s, si) == charAt(p, pi) ||( charAt(p, pi) == '.' && si < s.length()))
					&& match3(s, si + 1, p, pi + 1 );
		}
		if (match3(s,si, p , pi + 2)) return true;
		while ( charAt(s,si) == charAt(p, pi) || (charAt(p, pi) == '.' && si < s.length())){
			if (match3(s,++si, p, pi + 2))
				return true;
		}
		return false;	
	}

	private int charAt(String s, int i){
		if ( i >= s.length()) return -1;
		else return (int) s.charAt(i);
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegularExpressionMatching re = new RegularExpressionMatching();
		boolean result = re.isMatch3("ac", "a*c");
		System.out.println(result);
	}

}
