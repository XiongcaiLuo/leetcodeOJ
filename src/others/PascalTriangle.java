package others;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	/**
	 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
	 * @param args
	 */
	
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> result = new ArrayList<List<Integer>>();
       for(int i=0;i<numRows;i++){
    	   fill(result,i);
       }
      return result;
    }
    
    private void fill(List<List<Integer>> result , int i){
    	if( i==0){
    		ArrayList<Integer> list=new ArrayList<Integer>();
    		list.add(1);
    		result.add(list);
    		return;
    	}
    	List<Integer> preList=result.get(i-1);
    	ArrayList<Integer> nextList=new ArrayList<Integer>();
    	nextList.add(1);
    	for(int k=1;k<i;k++){
    		nextList.add(preList.get(k-1)+preList.get(k));
    	}
    	nextList.add(1);
    	result.add(nextList);
    }
	public static void main(String[] args) {
		PascalTriangle t =  new PascalTriangle();
		t.generate(3);
	}

}
