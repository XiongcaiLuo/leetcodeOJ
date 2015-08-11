package stackAndQueue;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of
 * the stack. top() -- Get the top element. getMin() -- Retrieve the minimum
 * element in the stack.
 * 
 * @author luoxiongcai
 *
 */
public class MinStack {
	private Stack<Integer> elements = new Stack<Integer>();
	private Stack<Integer> mins = new Stack<Integer>();
    public void push(int x) {
        elements.push(x);
        if ( mins.isEmpty() || x <= mins.peek()){
        	mins.push(x);
        }
    }

    public void pop() {
        int x = elements.pop();
        if ( x == mins.peek())
        	mins.pop();
    }

    public int top() {
        return elements.peek();
    }

    public int getMin() {
        return mins.peek();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
