package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
 * @author luoxiongcai
 *
 */
public class SurroundedRegions {

	/**
	 * bfs
	 * @param board
	 */
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < n; i++){
        	bfs(board, 0, i);
        	bfs(board, m -1, i);
        }
        for (int i = 1; i < m - 1; i++){
            bfs(board, i, 0);
            bfs(board, i, n - 1);
        }
        for (int i = 0; i < m ; i++){
        	for (int j = 0; j < n; j++){
        		if (board[i][j] == '+')
        			board[i][j] = 'O';
        		else if (board[i][j] == 'O')
        			board[i][j] = 'X';
        	}
        }
    }
    
    private void bfs(char[][] board, int row, int col){
    	Queue<Integer> rows = new LinkedList<Integer>();
    	Queue<Integer> cols = new LinkedList<Integer>();
    	rows.offer(row);
    	cols.offer(col);
    	while (!rows.isEmpty()){
    		int r = rows.poll();
    		int c = cols.poll();
    		if (board[r][c] == 'O'){
    			board[r][c] ='+';
    			if (r - 1 >= 0 ){
    				rows.offer(r-1);
    				cols.offer(c);
    			} 
    			if ( r + 1 < board.length){
    				rows.offer(r+1);
    				cols.offer(c);
    			}
    			if ( c - 1 >= 0){
    				rows.offer(r);
    				cols.offer(c-1);
    			}
    			if (c + 1 < board[0].length){
    				rows.offer(r);
    				cols.offer(c + 1);
    			}
    		}
    	}
    }	
    public static void main(String[] args) {

	}

}
