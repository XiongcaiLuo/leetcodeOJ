package dfs;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	/**
	 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
	 * @param args
	 */
	/**
	 * 可以利用动态规划，也可以利用深搜。
	 * @param s
	 * @return
	 */
    public List<List<String>> partition(String s) {
        ArrayList<List<String>> result=new ArrayList<List<String>>();
        if(s==null || s.isEmpty()) return result;
        ArrayList<ArrayList<List<String>>> history=new ArrayList<ArrayList<List<String>>>();
        List<String> part1=new ArrayList<String>();
        part1.add(s.substring(0,1));
        result.add(part1);
        history.add(result);
        for(int i=1;i<s.length();i++){
        	ArrayList<List<String>> result_i=new ArrayList<List<String>>();
        	if(isPalindrome(s, 0, i)){
        		List<String> newPart=new ArrayList<String>();
        		newPart.add(s.substring(0, i+1));
        		result_i.add(newPart);
        	}
        	for(int j=i;j>0;j--){
        		if(isPalindrome(s, j, i)){
        			String sub=s.substring(j,i+1);
        		    for(List<String> part:history.get(j-1)){
        		    	List<String> newPart=new ArrayList<String>(part);
        		    	newPart.add(sub);
        		    	result_i.add(newPart);
        		    }             	   
        		}
        	}
        	
        	history.add(result_i);
        }
        return history.get(s.length()-1);
    }
    
    boolean isPalindrome(String s,int begin,int end){
    	if(begin>end) return false;
    	while(begin<=end){
    		if(s.charAt(begin)!=s.charAt(end))
    			return false;
    		begin++;
    		end--;
    	}
    	return true;
    }
    
	public static void main(String[] args) {
		PalindromePartitioning t= new PalindromePartitioning();
		String s="bb";
		System.out.println(t.isPalindrome(s,0,0));
		t.partition(s);
		
	}

}
