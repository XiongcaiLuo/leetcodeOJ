package search;

public class SearchforaRange {

	/**
	 * Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4]
	 * @param args
	 */
    public int[] searchRange(int[] A, int target) {
        int min=searchMinIndex(A, target, 0, A.length-1);
        int max=searchMaxIndex(A, target, 0, A.length-1);
        return new int[]{min,max};
    }
    private int searchMaxIndex(int[]A,int target,int begin,int end) {
    	if(begin>end) return -1;
    	if (begin==end)
    		return (A[begin]==target?begin:-1);
    	else{
    		int mid=(begin+end)/2;
    		int midIndex=A[mid]==target?mid:-1;
    		int leftMaxIndex=searchMaxIndex(A, target, begin, mid-1);
    		int rightMaxIndex=searchMaxIndex(A, target, mid+1, end);
    		if(rightMaxIndex!=-1)
    			return rightMaxIndex;
    		else if(midIndex!=-1)
    			return midIndex;
    		else if(leftMaxIndex!=-1)
    			return leftMaxIndex;
    		else return -1;
    	}
	}
	private int searchMinIndex(int[]A,int target,int begin,int end){
    	if(begin>end) return -1;
    	if (begin==end)
    		return (A[begin]==target?begin:-1);
    	else{
    		int mid=(begin+end)/2;
    		int midIndex= A[mid]==target?mid:-1;
    		int leftMinIndex=searchMinIndex(A, target, begin, mid-1);
    		int rightMinIndex=searchMinIndex(A, target, mid+1, end);
    		if(leftMinIndex!=-1)
    			return leftMinIndex;
    		else if(midIndex!=-1)
    			return midIndex;
    		else if(rightMinIndex!=-1)
    			return rightMinIndex;
    		else return -1;
    	}
    }
	public static void main(String[] args) {
		int [] A=new int[]{1,2,2};
		int target=1;
		SearchforaRange t=new SearchforaRange();
		int[] bound=t.searchRange(A, target);
		System.out.println(bound[0]+"\t"+bound[1]);
	}

}
