package dp;

public class PalindromePartitioningII {

	/**
	 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
	 * @param args
	 */
    public int minCut(String s) {
        int n=s.length();
        int [] f=new int[n+1];
        boolean [][] p=new boolean[n][n];
        for(int i=0;i<=n;i++)
        	f[i]=n-1-i;
        for(int i=n-1;i>=0;i--){
        	for(int j=i;j<n;j++){
        		if(s.charAt(i)==s.charAt(j) && (j-i<2 || p[i+1][j-1])){
        			p[i][j]=true;
        			f[i]=Math.min(f[i],f[j+1]+1);
        		}
        	}
        }
        return f[0];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
