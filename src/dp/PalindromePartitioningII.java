package dp;

import java.util.Arrays;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return 1 since the palindrome partitioning
 * ["aa","b"] could be produced using 1 cut.
 * 
 * @param args
 */
public class PalindromePartitioningII {

	/**
	 * DP.
	 * @param s
	 * @return
	 */
	public int minCut(String s) {
		int n =s.length();
		boolean[][] valid = new boolean[n][n];
		int[] cut = new int[n];
		for (int i = 0; i < n ; i++)
			cut[i] = i;
		for (int j = 0; j < n; j++){
			for (int i = j; i >=0 ;i--){
				if (s.charAt(i) == s.charAt(j) && ( j - i < 2 || valid[i+1][j-1])){
					valid[i][j] = true;
					cut[j] = i == 0 ? 0: Math.min(cut[j], cut[i-1]+1);
				}
			}
		}
		return cut[n-1];
	}
	
	public int minCut2(String s) {
		int n = s.length();
		boolean [][]valid = new boolean[n][n];
		int[] cut =new int[n];
		Arrays.fill(cut, Integer.MAX_VALUE);
		cut[0] = 0;
		for (int i = 0; i < n; i++){
			valid[i][i] = true;
			if (i < n -1 && s.charAt(i) == s.charAt(i+1))
				valid[i][i+1] = true;
		}
		for (int len = 3; len <= n; len++){
			for (int i = 0; i + len  <= n; i++){
				valid[i][i+len-1] = (s.charAt(i) == s.charAt(i+len-1)) && valid[i+1][i+len-2];
			}
		}
		for (int i = 0; i< n; i++){
			if (valid[0][i]) {
				cut[i] =0;
				continue;
			}
			for (int j = i; j >=1; j--){
				if (valid[j][i]){
					cut[i] = Math.min(cut[i], cut[j-1]+1);
				}
			}
		}
		return cut[n-1];
	}
	

	public static void main(String[] args) {
		PalindromePartitioningII pp = new PalindromePartitioningII();
		String s ="cdd";
		int minCut = pp.minCut(s);
		System.out.println(minCut);
	}

}
