package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implement an iterator to flatten a 2d vector.
 * 
 * For example, Given 2d vector =
 * 
 * [ [1,2], [3], [4,5,6] ] By calling next repeatedly until hasNext returns
 * false, the order of elements returned by next should be: [1, 2, 3, 4, 5, 6].
 * 
 * @author luoxiongcai
 *
 */
public class Flatten2DVector {
	private final List<List<Integer>> nums;
	private int row,col;
	private int count,cur;
	public Flatten2DVector(List<List<Integer>> nums){
		this.nums = nums;
		row = 0;
		col = -1;
		cur = 0;
		for (List<Integer> ns : nums)
			count += ns.size();
	}
	public boolean hasNext(){
		return cur < count;
	}
	
	public int next(){
		cur++;
		while (nums.get(row).size() ==  col + 1){
			row++;
			col = -1;
		}
		col++;
		return nums.get(row).get(col);
	}
	public static void main(String[] args) {
		
		List<Integer> n1 = Arrays.asList(1,2,3);
		List<Integer> n2 = new ArrayList<Integer>();
		List<Integer> n3 = Arrays.asList(4);
		List<List<Integer>> nums = new ArrayList<List<Integer>>();
		nums.add(n1);
		nums.add(n2);
		nums.add(n3);
		Flatten2DVector f2 = new Flatten2DVector(nums);
		while(f2.hasNext()){
			int num = f2.next();
			System.out.print(num+"/");
		}
			
	}

}
