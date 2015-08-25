package search;

public class Searcha2DMatrix {

	/**
	 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
	 * @param args
	 */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length == 0 || matrix[0].length==0) return false;
        int m=matrix.length;
        int n=matrix[0].length;
        int first=0,last=m*n - 1;
        while(first<last){
        	int mid=(last+first)/2;
        	int value=matrix[mid/n][mid%n];
        	if (value < target)
        		first = mid + 1;
        	else last = mid;
        }
        return matrix[first/n][first%n] == target;
    }
    

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
