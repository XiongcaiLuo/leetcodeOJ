package stackAndQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * 
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 * 
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * 
 * For example, Given height = [2,1,5,6,2,3], return 10.
 * 
 * @param args
 */
public class LargestRectangleinHistogram {

	/** 
	 * use a stack. 
	 * @param height
	 * @return
	 */
    public int largestRectangleArea(int[] h) {
    	int max = 0;
    	int[] height = new int[h.length + 1];
    	for (int i = 0; i< h.length; i++)
    		height[i] = h[i];
    	Stack<Integer> index = new Stack<Integer>();
    	for (int i =0 ; i < height.length; ){
    		if (index.isEmpty() || height[i] > height[index.peek()])
    			index.push(i++);
    		else {
    			int curIndex = index.pop();
    			max = Math.max(max, height[curIndex] * (index.isEmpty() ? i: (i - index.peek() - 1)));
    		}
    	}
    	return max;
    }
	public static void main(String[] args) {
		LargestRectangleinHistogram lr = new LargestRectangleinHistogram();
		int[] h = {1,2,2};
		int max = lr.largestRectangleArea(h);
		System.out.println(max);
	}

}
