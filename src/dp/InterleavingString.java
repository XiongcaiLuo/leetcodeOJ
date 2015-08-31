package dp;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example, Given: s1 = "aabcc", s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return false.
 * 
 * @param args
 */
public class InterleavingString {

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		int n1 = s1.length(), n2 = s2.length();
		boolean[][] flags = new boolean[n1 + 1][n2 + 1];
		flags[0][0] = true;
		for (int i = 1; i <= n1; i++)
			flags[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1));
		for (int i = 1; i <= n2; i++)
			flags[0][i] = (s2.charAt(i - 1) == s3.charAt(i - 1));
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				flags[i][j] = ((s1.charAt(i - 1) == s3.charAt(i + j - 1) && flags[i - 1][j]))
						|| ((s2.charAt(j - 1) == s3.charAt(i + j - 1) && flags[i][j - 1]));
			}
		}
		return flags[n1][n2];
	}
	/**
	 * to save time and space.
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 */
	public boolean isInterleave2(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		int n1 = s1.length(), n2 = s2.length();
		boolean[] flags = new boolean[n2+1];
		flags[0] = true;
		for (int i = 1; i <= n2; i++)
			flags[i] = (s2.charAt(i - 1) == s3.charAt(i - 1));
		for (int i = 1; i <= n1; i++) {
			flags[0] = flags[0] && (s1.charAt(i-1) == s3.charAt(i-1));
			for (int j = 1; j <= n2; j++) {
				flags[j] = ((s1.charAt(i - 1) == s3.charAt(i + j - 1) && flags[j]))
						|| ((s2.charAt(j - 1) == s3.charAt(i + j - 1) && flags[j - 1]));
			}
		}
		return flags[n2];
	}

	public static void main(String[] args) {
		InterleavingString t = new InterleavingString();
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		System.out.println(t.isInterleave(s1, s2, s3));
	}

}
