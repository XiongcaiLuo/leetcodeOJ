package dfs;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        String[]tokens = getTokens(input);
        return dfs(tokens,0, tokens.length - 1);
    }
    
    private String[] getTokens(String input){
    	ArrayList<String> tokens = new ArrayList<String>();
    	for (int i = 0,j = 0; j <= input.length(); j++){
    		if ( j == input.length()){
    			tokens.add(input.substring(i,j));
    		} else if (isOp(input.charAt(j))){
    			tokens.add(input.substring(i,j));
    			tokens.add(input.substring(j,j+1));
    			i = j +1;
    		}
    	}
    	return tokens.toArray(new String[0]);
    }
    
    private boolean isOp(char c){
    	return c == '+' || c == '-' || c == '*';
    }
    
    private List<Integer> dfs(String[] tokens, int begin, int end){
        List<Integer> result = new ArrayList<Integer>();
        if (begin > end) return result;
        if (begin == end){
        	result.add(Integer.valueOf(tokens[begin]));
        	return result;
        }
        for (int i = begin + 1; i < end; i += 2){
        	List<Integer> left = dfs(tokens, begin, i - 1);
        	List<Integer> right = dfs(tokens, i + 1, end);
        	for (int fir: left){
        		for (int sec :right){
        			result.add(compute(tokens[i], fir, sec));
        		}
        	}
        }
        return result;
    }
    
    private int compute(String op, int fir, int sec){
    	switch (op.charAt(0)){
    	case '+': return fir + sec;
    	case '-': return fir - sec;
    	case '*': return fir * sec;
    	}
    	return 0;
    }
    
    public static void main(String[] args){
    	String input = "2*3-4*5";
    	DifferentWaystoAddParentheses  da = new DifferentWaystoAddParentheses();
    	List<Integer> re = da.diffWaysToCompute(input);
    	System.out.println(re);
    }
}
