package stackAndQueue;

import java.util.Stack;

public class ValidParentheses {

	/**
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
	 * @param args
	 */
    public static boolean isValid(String s) {
    	Stack<Character> stack=new Stack<Character>();
    	if (s==null || s.isEmpty()) return true;
    	for(Character c:s.toCharArray()){
    		
    		if(c.equals('(')||c.equals('[')||c.equals('{')){
    			stack.push(c);
    		}
    		else{
    			if(c.equals(')') ){
    				if(stack.isEmpty()||!stack.peek().equals('('))
    					return false;
    				else stack.pop();
    			}
    			else if(c.equals(']') ){
    				if(stack.isEmpty()||!stack.peek().equals('['))
    					return false;
    				else stack.pop();
    			}
    			else if(c.equals('}') ){
    				if(stack.isEmpty()||!stack.peek().equals('{'))
    					return false;
    				else stack.pop();
    			}
    		}
    	}
    	if (stack.size()==0) return true;
    	else return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s="]";
		System.out.println(isValid(s));
	}

}
