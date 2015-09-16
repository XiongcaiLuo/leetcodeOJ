package stackAndQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 四则混合运算
 * Four mixed calculating for non-negative integers.
 * @author luoxiongcai
 *
 */
public class Calculator {
	Map<String, Operator> operators = new HashMap<String, Operator>(){
		{
			put("+", new Operator(){
				public int compute(int n1, int n2){
					return n1 + n2;
				}
			});
			put("-", new Operator(){
				public int compute(int n1, int n2){
					return n1 - n2;
				}
			});
			put("*", new Operator(){
				public int compute(int n1, int n2){
					return n1 * n2;
				}
			});
			put("/", new Operator(){
				public int compute(int n1, int n2){
					return n1 / n2;
				}
			});
		}
	};
	
	Map<String, Integer> pris = new HashMap<String,Integer>(){
		{
			put("(", 0);
			put("+", 1);
			put("-", 1);
			put("*", 2);
			put("/", 2);
		}
	};

	public int calculate(String expression){
		List<String> tokens = tokenize(expression);
		List<String> rp = reversedPolishTokens(tokens);
		Stack<Integer> nums = new Stack<Integer>();
		for (String token : rp){
			if (isOp(token)){
				int n2 = nums.pop();
				int n1 = nums.pop();
				Operator op = operators.get(token);
				nums.push(op.compute(n1,n2));
			} else nums.push(Integer.valueOf(token));
		}
		return nums.pop();
	}
	
	private List<String> tokenize(String expression){
		List<String> tokens = new ArrayList<String>();
		int i = 0, j = 0;
		while ( j < expression.length()){
			char c = expression.charAt(j);
			if (Character.isWhitespace(c)){
				i++;
				j++;
				continue;
			}
			if (isOp(""+c) || c == '(' || c == ')'){
				tokens.add(""+c);
				i = ++j;
			} else {
				while (j < expression.length() && Character.isDigit(expression.charAt(j))) j++;
				tokens.add(expression.substring(i, j));
				i = j;
			}
		}
		return tokens;
	}
	
	private List<String> reversedPolishTokens(List<String> tokens){
		Stack<String> result = new Stack<String>();
		Stack<String> ops = new Stack<String>();
		for (String token : tokens){
			if (isNumber(token))
				result.push(token);
			else if (isOp(token)){
				while (!ops.isEmpty() && compareOp(ops.peek(), token) >=0){
					result.push(ops.pop());
				}
				ops.push(token);
			} else if ( token.equals("(")){
				ops.push(token);
			} else {
				while (!ops.peek().equals("(")){
					result.push(ops.pop());
				}
				ops.pop();
			}
		}
		while (!ops.isEmpty())
			result.push(ops.pop());
		return result;
	}
	
	private int compareOp(String op1, String op2){
		return pris.get(op1).compareTo(pris.get(op2));
	}
	 
	
	private boolean isOp(String s){
		return s.length() == 1 && (s.charAt(0) == '+' ||s.charAt(0) == '-' 
				||s.charAt(0) == '*' ||s.charAt(0) == '/') ;
	}
	
	private boolean isNumber(String s){
		return Character.isDigit(s.charAt(0));
	}
	
	
	interface Operator{
		int compute(int n1, int n2);
	}
	public static void main(String[] args) {
		Calculator cc = new Calculator();
		String expression = " 1 -   2 * (3 -2 +1) / 2";
		int result = cc.calculate(expression);
		System.out.println(result);
		
	}

}
