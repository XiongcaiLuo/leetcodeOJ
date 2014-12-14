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
        int[] nums=new int[n+1];
        if(n==0) return 0;
        if(n==1) return 1;
        nums[0]=1;
        nums[1]=1;
        int num=2;
        while(num<=n){
        	int sum=0;
            int ptr=1;
            while(ptr<=num-ptr){
            	sum+=2*nums[ptr-1]*nums[num-ptr];
            	if(ptr==num-ptr)
            		break;
            	ptr++;
            	
            }
            if(ptr>num-ptr){
            	sum+=nums[ptr-1]*nums[ptr-1];
            }
            nums[num]=sum;
            num++;
        }
        return nums[n];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=numTrees(5);
		System.out.println(n);
	}

}
