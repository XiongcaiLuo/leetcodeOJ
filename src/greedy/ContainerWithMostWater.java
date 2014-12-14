package greedy;

public class ContainerWithMostWater {

	/**
	 * @param args
	 */
    public int maxArea(int[] height) {
    	int start = 0;
    	int end = height.length - 1;
    	int result = Integer.MIN_VALUE;
    	while (start < end) {
	    	int area = Math.min(height[end], height[start]) * (end - start);
	    	result = Math.max(result, area);
	    	if (height[start] <= height[end]) {
	    		start++;
	    	} else {
	    		end--;
	    	}
    	}  
    	return result;
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
