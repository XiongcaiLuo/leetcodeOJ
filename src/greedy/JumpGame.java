package greedy;

public class JumpGame {

	/**
	 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
	 * @param args
	 */
    public boolean canJump(int[] A) {
    	int reach = 0; 
    	for (int i = 0; i <= reach && reach < A.length - 1; ++i)
    		reach = Math.max(reach, i + A[i]);
    	return reach >= A.length - 1;
    }

	public static void main(String[] args) {
		int []A={2,3,1,1,4};
		JumpGame t=new JumpGame();
		System.out.println(t.canJump(A));
	}

}
