//package oj.string;
//
//public class WildcardMatching {
//
//	/**
//	 * Implement wildcard pattern matching with support for '?' and '*'.
//
//'?' Matches any single character.
//'*' Matches any sequence of characters (including the empty sequence).
//
//The matching should cover the entire input string (not partial).
//
//The function prototype should be:
//bool isMatch(const char *s, const char *p)
//
//Some examples:
//isMatch("aa","a")；
//isMatch("aa","aa") → true
//isMatch("aaa","aa")；
//isMatch("aa", "*") → true
//isMatch("aa", "a*") → true
//isMatch("ab", "?*") → true
//isMatch("aab", "c*a*b")；
//	 * @param args
//	 */
//    public  boolean isMatch(String s, String p) {
//    	if(p=="*") return true;
//    	int s_ptr=0, p_ptr=0;
//    	int sn=s.length(), pn=p.length();
//    	while(s_ptr<sn && p_ptr<pn){
//    		while(p.charAt(p_ptr)=='*' && p_ptr+1<pn && p.charAt(p_ptr+1)=='*')
//    			p_ptr++;
//    		if(p.charAt(p_ptr)!='*'){
//    			if(p.charAt(p_ptr)=='?'){
//    				s_ptr++;
//    				p_ptr++;
//    			}
//    			else{
//    				if(p.charAt(p_ptr)==s.charAt(s_ptr)){
//        				s_ptr++;
//        				p_ptr++;
//    				}else return false;
//    			}
//    		}
//    		else{
//    			if()
//    		}
//    	}
//    }
//	public static void main(String[] args) {
//
//	}
//
//}
