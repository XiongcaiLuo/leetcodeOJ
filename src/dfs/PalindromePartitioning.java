package dfs;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return
 * 
 * [ ["aa","b"], ["a","a","b"] ]
 * 
 * @param args
 */

public class PalindromePartitioning {

	List<List<String>> result  = new ArrayList<List<String>>();
	String s;
	boolean[][] valid;
	public List<List<String>> partition(String s) {
		this.s = s;
		int n = s.length();
		valid = new boolean[n][n];
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
		List<Integer> curSeg = new ArrayList<Integer>();
		dfs(curSeg,0);
		return result;
	}
	
	private void dfs(List<Integer> curSeg, int begin){
		if (begin == s.length()){
			output(curSeg);
			return;
		}
		for (int i = begin; i < s.length(); i++){
			if (valid[begin][i]){
				curSeg.add(i);
				dfs(curSeg, i+1);
				curSeg.remove(curSeg.size() - 1);
			}
		}
	}
	
	private void output(List<Integer> curSeg){
		List<String> re = new ArrayList<String>();
		re.add(s.substring(0,curSeg.get(0)+1));
		for (int i = 1; i < curSeg.size(); i++){
			re.add(s.substring(curSeg.get(i-1)+1, curSeg.get(i)+1));
		}
		result.add(re);
	}
	
	


	public static void main(String[] args) {
		PalindromePartitioning t = new PalindromePartitioning();
		String s = "bcb";
		List<List<String>> result = t.partition(s);
		System.out.println(result);
	}

}
