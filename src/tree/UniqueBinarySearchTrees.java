package tree;

public class UniqueBinarySearchTrees {

	/**
	 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
	 * @param args
	 */
    public static  int numTrees(int n) {
        if (n == 1) return 1;
        int [] nums = new int[n + 1];
        nums[0] = 1; nums[1] = 1;
        for (int i = 2; i <= n; i++){
        	for (int j = 0; j <= i - 1; j++){
        		nums[i] += nums[j] * nums[i - 1 -j];
        	}
        }
        return nums[n];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=numTrees(3);
		System.out.println(n);
	}

}
