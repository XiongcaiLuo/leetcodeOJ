package oj;

public class LongestPalindromicSubstring {

	/**
	 * @param args
	 */

    public static String longestPalindrome(String s) {
    	if(s==null||s.isEmpty())return "";
    	int len=s.length();
    	if(len==1 || len==2) return s;

    	int[][]table=new int[len][len];
    	int index1=0,index2=0;
    	for(int i=0;i<len;i++)
    		table[i][i]=1;
    	for(int i=0;i<len-1;i++){
    		if(s.charAt(i)==s.charAt(i+1)){
    			table[i][i+1]=1;
    			index1=i;index2=i+1;
    		}
    			
    	}
    	String result="";

    	for(int k=2;k<len;k++){
    		for(int j=0;j+k<len;j++){
    			if(table[j+1][j+k-1]==1&& s.charAt(j)==s.charAt(j+k)){
    				table[j][j+k]=1;
    				index1=j;index2=j+k;
    			}   				
    			else table[j][j+k]=0;
    		}
    	}
    	return s.substring(index1,index2+1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long sTime=System.currentTimeMillis();
//		String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String s="abccbd";
		System.out.println(longestPalindrome(s));
		System.out.println("time:"+(System.currentTimeMillis()-sTime));


	}

}
