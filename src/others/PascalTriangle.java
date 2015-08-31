package others;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	Queue<Integer> queue = new LinkedList<Integer>();
    	queue.offer(1);
    	int count = 0;
    	while (count < numRows){
    		List<Integer> re = new ArrayList<Integer>();
    		int size = queue.size();
    		for (int i = 0; i < size; i++){  
    			re.add(queue.poll());
    		}
    		queue.offer(re.get(0));
    		for (int i = 1; i < re.size(); i++)
    			queue.offer(re.get(i) + re.get(i-1));
    		queue.offer(re.get(re.size()-1));
    		result.add(re);
    		count++;
    	}
    	return result;
    }
	public static void main(String[] args) {
		PascalTriangle t =  new PascalTriangle();
		t.generate(3);
	}

}
