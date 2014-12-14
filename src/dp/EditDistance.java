package dp;

public class EditDistance {

	/**
	 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
	 * @param args
	 */
    public int minDistance(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();
        int[][] count=new int[n1+1][n2+1];
        count[0][0]=0;
        for(int i=1;i<=n1;i++)
        	count[i][0]=i;
        for(int j=1;j<=n2;j++)
        	count[0][j]=j;
        for(int i=1;i<=n1;i++){
        	for(int j=1;j<=n2;j++){
        		if(word1.charAt(i-1)==word2.charAt(j-1))
        			count[i][j]=count[i-1][j-1];
        		else {
        			count[i][j]=Math.min(count[i-1][j-1]+1,count[i-1][j]+1);
        			count[i][j]=Math.min(count[i][j],count[i][j-1]+1);
        		}
        			
        	}
        }
        return count[n1][n2];
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
