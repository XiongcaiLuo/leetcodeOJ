package greedy;

import java.util.ArrayList;

class Pair{
	public int row;
	public int col;
	public Pair(int row,int col){
		this.row=row;
		this.col=col;
	}
	@Override
	public boolean equals(Object obj) {
		Pair other=(Pair) obj;
		return (row==other.row) && (col==other.col);
	}
	
}
public class WordSearch {
	 public boolean exist(char[][] board, String word) {
	        if(board==null || board.length==0) return false;
	        if(word==null || word.length()==0) return true;
	        int m=board.length;
	        int n=board[0].length;
	        int index=0;
	        ArrayList<Pair> used=new ArrayList<Pair>();
	        
	        for(int i=0;i<m;i++){
	        	for(int j=0;j<n;j++){
	        		if(isValid(used,board,i,j,word,index))
	        			return true;
	        	}
	        }
	        return false;
	    }
	 
	 public boolean isValid( ArrayList<Pair> used,char[][]board, int row, int col, String word, int index){
		 if(index>=word.length())
			 return true;
		 if(row>=board.length || col>=board[0].length || row<0 || col<0)
			 return false;
		 if(used.contains(new Pair(row,col)))
			 return false;
		 if(board[row][col]!=word.charAt(index))
			 return false;
		 else{
			 ArrayList<Pair> used_next=new ArrayList<Pair>(used);
			 used_next.add(new Pair(row,col));
			 return isValid(used_next,board,row+1,col, word, index+1) || isValid(used_next,board,row-1,col, word, index+1) ||
			 isValid(used_next,board,row,col+1, word, index+1) || isValid(used_next,board,row,col-1, word, index+1);
			 
		 } 
	 }
	 
	 public static void main(String[]args){
		 ArrayList<Pair> used=new ArrayList<Pair>();
		 used.add(new Pair(1,2));
		 System.out.println(used.contains(new Pair(1,3)));
	 }
	 
}
