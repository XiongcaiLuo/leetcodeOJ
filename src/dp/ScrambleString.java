package dp;
/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

great
/    \
gr    eat
/ \    /  \
g   r  e   at
       / \
      a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

rgeat
/    \
rg    eat
/ \    /  \
r   g  e   at
       / \
      a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

rgtae
/    \
rg    tae
/ \    /  \
r   g  ta  e
   / \
  t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * @param args
 */
public class ScrambleString {
	
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (n != s2.length()) return false;
        boolean[][][] f = new boolean[n+1][n][n];
        for (int i = 0; i < n; i++){
        	for (int j = 0; j < n; j++)
        		f[1][i][j] = s1.charAt(i) == s2.charAt(j);
        }
        for (int len = 2; len <= n; len++){
        	for (int i = 0; i + len <= n; i++){
        		for (int j = 0; j + len <= n; j++){
        			for (int k = 1; k < len ; k++){
        				if ((f[k][i][j] && f[len-k][i+k][j+k]) ||(f[k][i][j+len-k] && f[len-k][i+k][j])){
        					f[len][i][j] = true;
        					break;
        				}
        			}
        		}
        	}
        }
        return f[n][0][0];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
