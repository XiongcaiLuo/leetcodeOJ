package stackAndQueue;

import java.util.Stack;
/**
 * 
 * @author luoxiongcai
 *
 */
public class LongestValidParentheses {

	 public static int longestValidParentheses(String s) {
	        if(s==null || s.isEmpty()) return 0;
	        Stack<Integer> leftIndex=new Stack<Integer>();
	        int max=0,lastRight=-1;
	        for(int i=0;i < s.length();i++){
	        	if(s.charAt(i)=='(')
	        		leftIndex.push(i);
	        	else{
	        		if (leftIndex.isEmpty()){
	        			lastRight = i;
	        		} else {
	        			leftIndex.pop();
	        			if (leftIndex.isEmpty())
	        				max = Math.max(max,i - lastRight);
	        			else max = Math.max(max, i - leftIndex.peek());
	        		}
	        	}
	        }
	        return max;
	    }
	public static void main(String[] args) {
		int len = longestValidParentheses("()()(()");
		System.out.println(len);
	}

}
