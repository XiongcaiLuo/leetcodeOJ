package dfs;

import java.util.ArrayList;
import java.util.List;
/**
 * The n-queens puzzle is the problem of placing n queens on an n��n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
[".Q..",  // Solution 1
"...Q",
"Q...",
"..Q."],

["..Q.",  // Solution 2
"Q...",
"...Q",
".Q.."]
]
 * @param args
 */
public class NQueens {


	List<String[]> results=new ArrayList<String[]>();

	public List<String[]> solveNQueens(int n) {
        if(n<=0) return results;
        ArrayList<Integer> pos=new ArrayList<Integer>();
        int level=1;
        dfs(pos,level,n);
        return results;
    }
	private void dfs(ArrayList<Integer> pos, int level, int n) {
		if(level>n){
			String[] result=getPrint(pos);
			results.add(result);
			return;
		}
		for(int col=1;col<=n;col++){
			if(isValid(pos,level,col)){
				pos.add(col);
				dfs(pos, level+1, n);
				pos.remove(pos.size()-1);
			}
		}
		
	}
	private boolean isValid(ArrayList<Integer> pos, int row, int col) {
		if(pos.contains(col))
			return false;
		for(int i=0;i<pos.size();i++){
			if(Math.abs(row-i-1)==Math.abs(col-pos.get(i)))
				return false;
		}
		return true;
	}
	
	
	
	public String[] getPrint(ArrayList<Integer> pos) {
		String[] result=new String[pos.size()];
		for(int i=0;i<pos.size();i++){
			String temp="";
			int index=pos.get(i);
			for(int k=0;k<pos.size();k++){
				if(k==index-1)
					temp+="Q";
				else temp+=".";
			}
			result[i]=temp;
		}
		return result;
	}
	
	
	

	public static void main(String[] args) {


	}

}
