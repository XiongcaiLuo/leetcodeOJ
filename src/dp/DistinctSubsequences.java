package dp;

/**
 * Given a string s and a string t, count the number of distinct subsequences of
 * t in s.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: s = "rabbbit", t = "rabbit"
 * 
 * Return 3.
 * 
 * @param args
 */
public class DistinctSubsequences {

	/**
	 * dp.
	 * @param s
	 * @param t
	 * @return
	 */
	public int numDistinct(String s, String t) {
		int n = s.length();
		int m = t.length();
		if ( n < m) return 0;
		int[][] f = new int[n+1][m+1];
		f[0][0] = 1;
		for (int i = 1; i <= n; i++){
			f[i][0] = 1;
			for (int j = 1; j <= m; j++){
				f[i][j] = f[i-1][j];
				if (s.charAt(i-1) == t.charAt(j-1) ){
					f[i][j] += f[i-1][j-1];
				}
			}
		}
		return f[n][m];
	}
	/**
	 * to save space.
	 * @param s
	 * @param t
	 * @return
	 */
	public int numDistinct2(String s, String t) {
		int n = s.length();
		int m = t.length();
		if ( n < m) return 0;
		int[] f = new int[n+1];
		f[0] = 1;
		int temp_ij = f[0];
		for (int i = 1; i <= n; i++){
			temp_ij = 1;                     // the upper-lefter f[i-1][j-1];
			for (int j = 1; j <= m; j++){
				int temp = f[j];
				if (s.charAt(i-1) == t.charAt(j-1))
					f[j] += temp_ij;
				temp_ij = temp;
			}
		}
		return f[m];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
