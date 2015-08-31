package others;
/**
 * similar to MinimumWindowSubstring, but the order matters.
 * @author luoxiongcai
 *
 */
public class MinimumWindowSubstringII {
	/**
	 * scan , shrink, scan again.
	 * the worst time complexity? 
	 * @param s
	 * @param t
	 * @return
	 */
	 public String minOrderWindow(String s, String t) {
		 if (s.length() < t.length() || t.isEmpty()) return "";
		 int i = 0, j = 0;
		 int min = Integer.MAX_VALUE;
		 int minS = -1, minE = -1;
		 while ( i < s.length()){
			 if (s.charAt(i) == t.charAt(j)){
				 i++;
				 j++;
			 } else i++;
			 // shrink;
			 if ( j == t.length()){
				 j = j - 1;
				 int start = i - 1;
				 while (j >= 0){
					 if (s.charAt(start) == t.charAt(j)){
						 start--;
						 j--;
					 } else start--;
				 }
				 // update min
				 if (min > i -  start -1){
					 min = i - start - 1;
					 minS = start+1;
					 minE = i - 1;
				 }
				 //reset the scanner.
				 i = start + 2;         
				 j = 0; 
			 }
		 }
		 return min == Integer.MAX_VALUE ? "" : s.substring(minS, minE+1);
	 }
	public static void main(String[] args) {
		MinimumWindowSubstring mw = new MinimumWindowSubstring();
		MinimumWindowSubstringII mw2 = new MinimumWindowSubstringII();
		String s = "ABBBACBCADDBC";
		String t = "ABC";
		String re = mw.minWindow(s, t);
		String re2 = mw2.minOrderWindow(s, t);
		System.out.println("1: "+re);
		System.out.println("2: "+re2);
	}

}
