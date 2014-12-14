package dp;

public class InterleavingString {

	/**
	 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
	 * @param args
	 */
	
	/**
	 * 递归会超时，利用二维表的备忘录。
	 */
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if(s1.length()+s2.length()!=s3.length()) return false;
//        return isValid(s1,s1.length()-1,s2,s2.length()-1,s3,s3.length()-1);
//    
//    }
//    
//    /**
//     * 看s3的[0,index3]是否由s1的[0,index1]和 s2的[0,index2]组成
//     * @param s1
//     * @param index1
//     * @param s2
//     * @param index2
//     * @param s3
//     * @param index3
//     * @return
//     */
//    public boolean isValid(String s1,int index1,String s2,int index2,String s3,int index3){
//    	if(index1<0 && index2<0 && index3<0)	
//    		return true;
//    	if(index1<0){
//    		if(s2.charAt(index2)!=s3.charAt(index3))
//    			return false;
//    		return isValid(s1,index1,s2,index2-1,s3,index3-1);
//    	}
//    	else if(index2<0){
//    		if(s1.charAt(index1)!=s3.charAt(index3))
//    			return false;
//    		return isValid(s1,index1-1,s2,index2,s3,index3-1);
//    	}
//    	if((s1.charAt(index1)==s3.charAt(index3))&&(s2.charAt(index2)!=s3.charAt(index3))){
//    		return isValid(s1,index1-1,s2,index2,s3,index3-1);
//    	}
//    	else if((s1.charAt(index1)!=s3.charAt(index3))&&(s2.charAt(index2)==s3.charAt(index3))){
//    		return isValid(s1,index1,s2,index2-1,s3,index3-1);
//    	}
//    	else if((s1.charAt(index1)==s3.charAt(index3))&&(s2.charAt(index2)==s3.charAt(index3))){
//    		return isValid(s1,index1-1,s2,index2,s3,index3-1)||isValid(s1,index1,s2,index2-1,s3,index3-1);
//    	}
//    	else return false;
//    }
	
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		int n1=s1.length(), n2=s2.length();
		boolean [][] flags=new boolean[n1+1][n2+1];
		flags[0][0]=true;
		for(int i=1;i<=n1;i++)
			flags[i][0]=(s1.charAt(i-1)==s3.charAt(i-1));
		for(int i=1;i<=n2;i++)
			flags[0][i]=(s2.charAt(i-1)==s3.charAt(i-1));
		for(int i=1;i<=n1;i++){
			for(int j=1;j<=n2;j++){
				flags[i][j]=((s1.charAt(i-1)==s3.charAt(i+j-1) && flags[i-1][j]))||((s2.charAt(j-1)==s3.charAt(i+j-1) && flags[i][j-1]));
			}
		}
		return flags[n1][n2];
	}
	public static void main(String[] args) {
		InterleavingString t=new InterleavingString();
		String s1="aabcc";
		String s2="dbbca";
		String s3="aadbbcbcac";
		System.out.println(t.isInterleave(s1, s2, s3));
	}

}
