package others;

import java.util.ArrayList;
import java.util.List;
/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
[ 1, 2, 3 ],
[ 8, 9, 4 ],
[ 7, 6, 5 ]
]
 * @param args
 */
public class SpiralMatrixII {
	
    public int[][] generateMatrix(int n2) {
    	if(n2==0) return new int[0][0];
    	int [][]matrix=new int[n2][n2];
        int m=matrix.length, n=matrix[0].length;
        int count=0,total=n*m;
        int rowLow=0, rowUp=m-1, colLow=0, colUp=n-1;
        while(count<total){
        	for(int j=colLow;j<=colUp;j++){
        		matrix[rowLow][j]=count+1;
        		count++;
        	}
        	if(count>=total) break;
        	for(int i=rowLow+1;i<=rowUp;i++){
        		matrix[i][colUp]=count+1;
        		count++;
        	}
        	if(count>=total) break;
        	for(int j=colUp-1;j>=colLow;j--){
        		matrix[rowUp][j]=count+1;
        		count++;
        	}
        	if(count>=total) break;
        	for(int i=rowUp-1;i>rowLow;i--){
        		matrix[i][colLow]=count+1;
        		count++;
        	}
        	rowLow++; rowUp--;colLow++;colUp--;
        }
        return matrix;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
