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
        Stack<Character> stack=new Stack<Character>();
        int maxLen=0,ptr=0;
        for(Character c:s.toCharArray()){
        	ptr++;
        	if(c.equals('('))
        		stack.push(c);
        	else{
        		if(stack.isEmpty()||!stack.peek().equals('(')){
          			// bad
        			int curLen=ptr-stack.size()-1;
        			maxLen=Math.max(curLen, maxLen);
        			ptr=0;
        		}
        		else{
        			stack.pop();
        		}
        	}
        }
		int curLen=ptr-stack.size();
		maxLen=Math.max(curLen, maxLen);
        return maxLen;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="()(()";
		System.out.println(longestValidParentheses( s));
	}

}
