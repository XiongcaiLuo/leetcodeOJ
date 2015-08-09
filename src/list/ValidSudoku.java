package oj.list;

import java.util.ArrayList;

public class ValidSudoku {

	/**
	 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
	 * @param args
	 */
	
    public static  boolean isValidSudoku(char[][] board) {
    	ArrayList<Character> nums=new ArrayList<Character>();
    	for(int i=0;i<9;i++){
    		for(int j=0;j<9;j++){
    			if(board[i][j]=='.') continue;
    			if(nums.contains(board[i][j])) return false;
    			else nums.add(board[i][j]);
    		}
    		nums.clear();
    	}
    	nums.clear();
    	for(int j=0;j<9;j++){
    		for(int i=0;i<9;i++){
    			if(board[i][j]=='.') continue;
    			else if(nums.contains(board[i][j])) return false;
    			else nums.add(board[i][j]);
    		}
    		nums.clear();
    	}
    	nums.clear();
    	for(int i=0;i<3;i++){
    		for(int j=0;j<3;j++){
    			for(int row=0;row<3;row++)
    				for(int col=0;col<3;col++){
    					if(board[row+3*i][col+3*j]=='.') continue;
    					else if(nums.contains(board[row+3*i][col+3*j]))return false;
    					else nums.add(board[row+3*i][col+3*j]);
    				}
    			nums.clear();		
    		}
    	}
		return true;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
