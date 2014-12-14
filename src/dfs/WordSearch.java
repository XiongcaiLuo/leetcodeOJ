package dfs;

public class WordSearch {

	/**
	 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
	 * @param args
	 */

	 public boolean exist(char[][] board, String word) {
	        if(board==null || board.length==0) return false;
	        if(word==null || word.length()==0) return true;
	        int m=board.length;
	        int n=board[0].length;
	        int index=0;
	        for(int i=0;i<m;i++){
	        	for(int j=0;j<n;j++){
	        		if(isValid(board,i,j,word,index))
	        			return true;
	        	}
	        }
	        return false;
	    }
	 
	 public boolean isValid(char[][]board, int row, int col, String word, int index){
		 if(index>=word.length())
			 return true;
		 if(row>=board.length || col>=board[0].length || row<0 || col<0)
			 return false;
		 if(board[row][col]!=word.charAt(index))
			 return false;
		 else return isValid(board,row+1,col, word, index+1) || 
				 isValid(board,row-1,col, word, index+1) ||
				 isValid(board,row,col+1, word, index+1) ||
				 isValid(board,row,col-1, word, index+1);
	 }
	public static void main(String[] args) {
		char [][] board=new char[][]{{'A','B'}};
		WordSearch t=new WordSearch();
		String word="BAa";
		System.out.println(t.exist(board, word));
	}

}
