package dfs;

import java.util.ArrayList;

public class NQueensII {

	/**
	 * @param args
	 */
	public int count=0;
    public int totalNQueens(int n) {
    	if(n<=0) return 0;
    	ArrayList<Integer> pos=new ArrayList<Integer>();
    	int level=1;
    	dfs(pos,level,n);
    	return count;
	}
	
	
	
	private void dfs(ArrayList<Integer> pos, int level, int n) {
		if(level>n){
			count++;
			return;
		}
		for(int col=1;col<=n;col++){
			if(isValid(pos,level,col)){
				ArrayList<Integer> next=new ArrayList<>(pos);
				next.add(col);
				dfs(next, level+1, n);
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
		// TODO Auto-generated method stub

	}

}
