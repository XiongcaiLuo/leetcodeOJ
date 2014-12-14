package oj;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionMatching {

	/**
	 * @param args
	 */
    public static  boolean isMatch(String s, String p) {
        Pattern pattern=Pattern.compile("^"+p+"$");
        Matcher matcher=pattern.matcher(s);
        if(matcher.find())
        	return true;
        else return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatch("aaa","aa"));
	}

}
