package dp;

import java.util.Set;

public class WordBreak {

	/**
	 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
	 * @param args
	 */
    public boolean wordBreak(String s, Set<String> dict) {
        int n=s.length();
        boolean [] f=new boolean[n];
        f[0]= dict.contains(s.substring(0,1));
        for(int i=1;i<n;i++){
        	if(dict.contains(s.substring(0,i+1))){
        		f[i]=true;
        		continue;
        	}
        		
        	boolean flag=false;
        	for(int j=0;j<i;j++){
        		if(f[j] && dict.contains(s.substring(j+1,i+1))){
        			flag=true;
        			break;
        		}
        	}
        	f[i]=flag;
        }
        return f[n-1];
    }
	public static void main(String[] args) {
		
	}

}
