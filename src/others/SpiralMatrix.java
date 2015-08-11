package others;

import java.util.ArrayList;
import java.util.List;
/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
[ 1, 2, 3 ],
[ 4, 5, 6 ],
[ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 * @param args
 */
public class SpiralMatrix {


    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> result=new ArrayList<Integer>();
    	if(matrix==null ||matrix.length==0) return result;
        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length-1;
        while (left <= right && up <= down){
        	for (int i = left; i <= right; i++)
        		result.add(matrix[up][i]);
        	if ( ++up > down) break;
        	for (int i = up; i <= down ;i++)
        		result.add(matrix[i][right]);
        	if ( --right < left) break;
        	for (int i = right; i >= left; i--)
        		result.add(matrix[down][i]);
        	if ( --down < up) break;
        	for (int i = down; i >= up; i--)
        		result.add(matrix[i][left]);
        	if ( ++left > right) break;
        }
        return result;
    }
    

	public static void main(String[] args) {
		SpiralMatrix t=new SpiralMatrix();
		int[][]matrix=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//		int[][]matrix=new int[][]{{2,3}};
		List<Integer> result=t.spiralOrder(matrix);
		System.out.println(result.size());
	}

}
