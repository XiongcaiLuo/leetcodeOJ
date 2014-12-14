package dp;

public class DistinctSubsequences {

	/**
	 * Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
	 * @param args
	 */
	
    public int numDistinct(String S, String T) {
        if(S==null || S.length()<T.length()) return 0;
        int ns=S.length();
        int nt=T.length();
        int[][]count=new int[ns][nt];
        count[0][0]=S.charAt(0)==T.charAt(0)?1:0;
        for(int i=1;i<ns;i++){
        	if(S.charAt(i)==T.charAt(0))
        		count[i][0]=count[i-1][0]+1;
        	else count[i][0]=count[i-1][0];
        }
        
        for(int i=1;i<ns;i++){
        	for(int j=1;j<nt;j++){
        		if(S.charAt(i)==T.charAt(j))
        			count[i][j]=count[i-1][j-1]+count[i-1][j];
        		else count[i][j]=count[i-1][j];
        	}
        }
        return count[ns-1][nt-1];	
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
