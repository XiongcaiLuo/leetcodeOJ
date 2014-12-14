package string;

import java.util.Stack;

public class LengthofLastWord {

	/**
	 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length
of last word in the string.
If the last word does not exist, return 0.
Note: A word is defined as a character sequence consists of non-space characters only.
For example, Given s = "Hello World", return 5.
	 * @param args
	 */
    public boolean isValid(String s) {
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

	}

}
