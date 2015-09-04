package interview_xk;


//package interviewquestions.google;

import java.util.Arrays;

/**
 * Given two strings a and b, find whether any anagram of string a is a
 * sub-string of string b. For eg: if a = xyz and b = afdgzyxksldfm then the
 * program should return true.
 */
public class AnagramSubString_lxc {
    public boolean isAnagramSubString(String src, String target) {
        if (src == null || target == null || src.length() < target.length())
            return false;

        /** Use one array to store expected, another to store found */
        int[] expected = new int[256];
        int[] found = new int[256];
        for (int i = 0; i < target.length(); i++)
            expected[target.charAt(i)]++;
        for (int i = 0; i <= src.length() - target.length(); i++) {
            for (int j = 0; j <= target.length(); j++) {
                if ( j == target.length()) return true;
                found[src.charAt(i+j)]++;
                if (found[src.charAt(i+j)] > expected[src.charAt(i+j)]){
                	Arrays.fill(found, 0);
                	break;
                }
            }
        }
        return false;
    }
    
   public static void main(String[] args){
	   AnagramSubString_lxc lxc = new AnagramSubString_lxc();
	   String src ="abdcd";
	   String target = "bdc";
	   boolean flag = lxc.isAnagramSubString(src, target);
	   System.out.println(flag);
   } 
}
