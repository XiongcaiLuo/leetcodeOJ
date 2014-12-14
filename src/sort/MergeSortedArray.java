package sort;

public class MergeSortedArray {

	/**
	 * Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
	 * @param args
	 */
    public static void merge(int A[], int m, int B[], int n) {
        int pa=m-1,pb=n-1,cur=m+n-1;
        while(pa>=0 && pb>=0){
        	if(A[pa]>=A[pb]){
        		A[cur]=A[pa];
        		pa--;
        		cur--;
        	}else{
        		A[cur]=B[pb];
        		pb--;
        		cur--;
        	}
        }
        while(pb>=0){
        	A[cur]=B[pb];
        	cur--;
        	pb--;
        }
    }
	public static void main(String[] args) {

		int[] A=new int[3];
		A[0]=2;
		A[1]=3;
		int[]B=new int[]{1};
		merge(A,2,B,1);
		for(int a:A)
			System.out.println(a);
	}

}
