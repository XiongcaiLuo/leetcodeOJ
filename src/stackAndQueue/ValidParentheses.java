package stackAndQueue;

import java.util.HashMap;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 * @param args
 */
public class ValidParentheses {

	public  boolean isValid(String s) {
		HashMap<Character,Character> maps = new HashMap<Character,Character>(){
			{
				put(']','['); put(')','('); put('}','{');
			}
		};
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()){
			if (!maps.containsKey(c))
				stack.push(c);
			else {
				if (stack.isEmpty() || !stack.pop().equals(maps.get(c)))
					return false;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
