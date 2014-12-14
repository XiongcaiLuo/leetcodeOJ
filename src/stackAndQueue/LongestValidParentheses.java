package stackAndQueue;

import java.util.Stack;

public class LongestValidParentheses {

	/**
	 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
	 * @param args
	 */
	 public static int longestValidParentheses(String s) {
	        if(s==null || s.isEmpty()) return 0;
	        Stack<Integer> leftIndex=new Stack<>();
	        int max=0,lastRight=-1;
	        for(int i=0;i<s.length();i++){
	        	if(s.charAt(i)=='(')
	        		leftIndex.push(i);
	        	else{
	        		if(!leftIndex.isEmpty()){
	        			leftIndex.pop();
	        			if(leftIndex.isEmpty())
	        				max=Math.max(max, i-lastRight);
	        			else max=Math.max(max, i-leftIndex.peek());
	        		}else{
	        			lastRight=i;
	        		}
	        	}
	        }

	        return max;
	    }
	public static void main(String[] args) {
		System.out.println(longestValidParentheses("()()(()"));
	}

}