package dp;

public class MaximumSubarray {
    public int maxSubArray(int[] A) {
    	int max=A[0];
        for(int i=1;i<A.length;i++){
        	if(A[i-1]>0){
        		A[i]+=A[i-1];
        		
        	}
        	max=Math.max(max, A[i]);
        		
        }
        return max;
    }
}
