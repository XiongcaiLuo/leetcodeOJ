package string;
/**
 * '?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
 * @author luoxiongcai
 *
 */
public class WildcardMatching {

	/**
	 * QA: is '**' is valid? yes.
	 * recursion. time limit.
	 * @param s
	 * @param p
	 * @return
	 */
    public  boolean isMatch(String s, String p) {
    	return helper(s.toCharArray(), 0, p.toCharArray(), 0);
    }
    
    private boolean helper(char[] cs, int begin1, char[] cp, int begin2){
    	if (begin1 == cs.length && begin2 == cp.length) return true;
    	else if (begin1 != cs.length && begin2 == cp.length) return false;
    	else if (begin1 == cs.length && begin2 != cp.length){
    		for (int i = begin2; i < cp.length; i++)
    			if(cp[i] != '*') return false;
    		return true;
    	}
    	if (cs[begin1] == cp[begin2] || cp[begin2] == '?')
    		return helper(cs, begin1+1, cp, begin2+1);
    	if (cp[begin2] == '*'){
    		while (begin2 < cp.length && cp[begin2] == '*') begin2++;             // skip consecutive *
    		for (int i = begin1; i <= cs.length; i++){
    			if (helper(cs, i, cp, begin2 ))
    				return true;
    		}
    		return false;
    	} else 
    		return false;
    }
    /**
     * iterative method.
     * @param s
     * @param p
     * @return
     */
	public boolean isMatch2(String s, String p) {
		int m = s.length(), n = p.length();
		int str = 0, ptr = 0;
		int spos = -1, pstar = -1;
		while ( str < m){
			if (ptr < n &&(s.charAt(str) == p.charAt(ptr) || p.charAt(ptr) == '?')){
				str++;
				ptr++;
				continue;
			}
			if (ptr < n && (p.charAt(ptr) =='*')){
				spos = str;
				pstar = ptr;
				ptr++;
			} else if (pstar != -1){
				str = spos++;
				ptr = pstar + 1;
			} else return false;
		}
		while ( ptr < n && p.charAt(ptr) == '*') ptr++;
		return str == m && ptr == n;
	}
	/**
	 * wildchar:+ * ?
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch3(String s, String p) {
		int m = s.length(), n = p.length();
		int str = 0, ptr = 0;
		int posStar = -1, posS = -1;
		while (str < m){
			if (ptr < n && (s.charAt(str) == p.charAt(ptr) || p.charAt(ptr) == '?')){
				str++;
				ptr++;
				continue;
			}
			if (ptr < n && p.charAt(ptr) =='*'){
				posStar = ptr;
				posS = str;
				ptr++;
			} else if (ptr < n && p.charAt(ptr) == '+'){
				posStar = ptr;
				posS = str;
				str++;
				ptr++;
			} else if (posStar > -1){
				str = posS++;
				ptr = posStar + 1;
			} else return false;
		}
		while (ptr < n && p.charAt(ptr) == '*') ptr++;
		return ptr == n && str == m;
	}

	public static void main(String[] args) {
		WildcardMatching wm = new WildcardMatching();
		String s= "hi";
		String p = "*?+";
		boolean f = wm.isMatch3(s, p);
		System.out.println(f);
	}

}
