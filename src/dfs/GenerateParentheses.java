package dfs;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	/**
	 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
	 * @param args
	 */
	
	List<String> results=new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        if(n<=0) return results;
        String temp=new String();
        int left=0,right=0;
        dfs(temp,left,right,n);
        return results;
    }
	private void dfs(String temp, int left, int right, int n) {
		if(left==n){
			for(int i=right;i<n;i++)
				temp+=")";
			results.add(temp);
			return;
		}
		dfs(temp+"(",left+1,right,n);
		if(left>right) dfs(temp+")",left,right+1,n);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
