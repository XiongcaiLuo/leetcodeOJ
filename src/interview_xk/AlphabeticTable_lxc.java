package interview_xk;


//package interviewquestions.facebook;

/**
 * Given a mapping of alphabets to integers as follows:
 * 
 * 1 = A 2 = B 3 = C ... 26 = Z
 * 
 * Given any combination of the mapping numbers as string, return the number of
 * ways in which the input string can be split into sub-strings and represented
 * as character strings. For e.g. given "111" -> "AAA", "AK", "KA" -> 3
 */
public class AlphabeticTable_lxc {
    public int combinations(String src) {
    	if (src == null) return 0;
    	if (src.length() < 2) return src.length();
    	int len = src.length();
    	int[] result = new int[len + 1];
    	result[len] = 1;
    	result[len - 1] = src.charAt(len - 1) == '0' ? 0 : 1;
    	for (int i = len - 2; i >= 0 ; i--){
    		if (src.charAt(i) == '0') continue;
    		result[i] = result[i+1];
    		int num = Integer.valueOf(src.substring(i, i + 2));
    		if ( num > 0 && num < 27)
    			result[i] += result[i+2];
    	}
    	return result[0];
    }
    
    public static void main(String[] args){
    	AlphabeticTable_lxc ag = new AlphabeticTable_lxc();
    	String src = "1310";
    	int re = ag.combinations(src);
    	System.out.println(re);
    }
    
}
