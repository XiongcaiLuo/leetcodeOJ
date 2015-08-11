package stackAndQueue;

import java.util.HashMap;
import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Some examples: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 
 * ["4","13","5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * @author luoxiongcai
 *
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> result = new Stack<Integer>();
        for (String token : tokens){
        	if (isOperate(token)){
        		result.push(eval(result.pop(), result.pop(),token));
        	} else result.push(Integer.valueOf(token));
        }
        return result.get(0);
    }
    
    private boolean isOperate(String op){
    	return "+".equals(op) || "-".equals(op) || "*".equals(op) || "/".equals(op);
    }
    private int eval(int second, int first, String op){
    	switch (op.charAt(0)){
    	case '+': return first + second;
    	case '-': return first - second;
    	case '*': return first * second;
    	case '/': return first / second;
    	}
		return 0;
    		
    }
    
    /**
     * use interface to make code clean.
     * @author luoxiongcai
     *
     */
    interface Operate{
    	int eval(int first, int second);
    }
    
    HashMap<String, Operate> OPERATERS = new HashMap<String,Operate>(){
    	{
    		put("+", new Operate(){public int eval(int first, int second){return first + second;}});
    		put("-", new Operate(){public int eval(int first, int second){return first - second;}});
    		put("*", new Operate(){public int eval(int first, int second){return first * second;}});
    		put("/", new Operate(){public int eval(int first, int second){return first / second;}});
    	}
    };
    public int evalRPN2(String[] tokens) {
    	Stack<Integer> result = new Stack<Integer>();
    	for (String token : tokens){
    		if (OPERATERS.containsKey(token)){   // containsKey
    			int second = result.pop();
    			int first = result.pop();
    			result.push(OPERATERS.get(token).eval(first, second));
    		} else result.push(Integer.valueOf(token));
    	}
    	return result.get(0);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
