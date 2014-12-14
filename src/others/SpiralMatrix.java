package others;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

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
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> result=new ArrayList<Integer>();
    	if(matrix==null ||matrix.length==0) return result;
        int m=matrix.length, n=matrix[0].length;
        int count=0,total=n*m;
        int rowLow=0, rowUp=m-1, colLow=0, colUp=n-1;
        while(count<total){
        	for(int j=colLow;j<=colUp;j++){
        		result.add(matrix[rowLow][j]);
        		count++;
        	}
        	if(count>=total) break;
        	for(int i=rowLow+1;i<=rowUp;i++){
        		result.add(matrix[i][colUp]);
        		count++;
        	}
        	if(count>=total) break;
        	for(int j=colUp-1;j>=colLow;j--){
        		result.add(matrix[rowUp][j]);
        		count++;
        	}
        	if(count>=total) break;
        	for(int i=rowUp-1;i>rowLow;i--){
        		result.add(matrix[i][colLow]);
        		count++;
        	}
        	rowLow++; rowUp--;colLow++;colUp--;
        }
        return result;
    }
	public static void main(String[] args) {
		SpiralMatrix t=new SpiralMatrix();
//		int[][]matrix=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		int[][]matrix=new int[][]{{2,3}};
		List<Integer> result=t.spiralOrder(matrix);
		System.out.println(result.size());
	}

}
