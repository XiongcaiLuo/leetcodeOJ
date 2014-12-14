package tails;

import java.util.ArrayList;

/**
 * esign a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 * @author luoxiongcai
 *
 */

public class MinStack {
	ArrayList<Integer> data;
	int min;
	int minNum;
	MinStack(){
		data=new ArrayList<Integer>();
		min=Integer.MAX_VALUE;
		minNum=0;
	}
    public void push(int x) {
        data.add(x);
        if(x<min){
        	min=x;
        	minNum++;
        }else if(x==min)
        	minNum++;
        	
    }

    public void pop() {
        int re= data.remove(data.size()-1);
        if(re==min){
        	if(minNum>1)
        		minNum--;
        	else{
        		min=Integer.MAX_VALUE;
        		for(int i=0;i<data.size();i++)
        			min=Math.min(min, data.get(i));
        		minNum=1;
        	}
        }
    }

    public int top() {
        return data.get(data.size()-1);
    }

    public int getMin() {
       return min;
    }
}
