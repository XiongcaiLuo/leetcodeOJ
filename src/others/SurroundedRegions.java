package others;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
	int row;
	int col;
	Pair(int row, int col){
		this.row=row;
		this.col=col;
	}
}

public class SurroundedRegions {

	/**
	 * dfs : stackoverflow
	 * bfs: ok
	 * @param args
	 */
	
	
    public void solve(char[][] board) {
        if(board==null || board.length <=2 || board[0].length<=2) return;
        int m=board.length, n=board[0].length;
        for(int i=0;i<m;i++){
        	if(board[i][0]=='O'){
        		board[i][0]='.';
        		color(board,i,0);
        	}
        	if(board[i][n-1]=='O'){
        		board[i][n-1]='.';
        		color(board,i,n-1);
        	}
        }
        
        for(int j=1;j<n-1;j++){
        	if(board[0][j]=='O'){
        		board[0][j]='.';
        		color(board,0,j);
        	}
        	if(board[m-1][j]=='O'){
        		board[m-1][j]='.';
        		color(board,m-1,j);
        	}
        }
        
        for(int i=0;i<m;i++)
        	for(int j=0;j<n;j++){
        		if(board[i][j]=='.')
        			board[i][j]='O';
        		else board[i][j]='X';
        	}
    }
    
    private void color(char[][] board, int row0, int col0){
    	Queue<Pair> queue = new LinkedList<Pair>();
    	queue.offer(new Pair(row0,col0));
    	while(!queue.isEmpty()){
    		Pair cur=queue.poll();
    		int row=cur.row, col=cur.col;
        	if(row-1>=0 && board[row-1][col]=='O'){
        		board[row-1][col]='.';
        		queue.offer(new Pair(row-1,col));
        	}
        	if(row+1<board.length && board[row+1][col]=='O'){
        		board[row+1][col]='.';
        		queue.offer(new Pair(row+1,col));
        	}
        	if(col-1>=0 && board[row][col-1]=='O'){
        		board[row][col-1]='.';
        		queue.offer(new Pair(row,col-1));
        	}
        	if(col+1<board[0].length && board[row][col+1]=='O'){
        		board[row][col+1]='.';
        		queue.offer(new Pair(row,col+1));
        	}
    	}
    }


}
