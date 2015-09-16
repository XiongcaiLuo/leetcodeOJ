package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Suppose you have a Iterator class with has_next() and get_next() methods.
 * 
 * Please design and implement a ZigzagIterator class as a wrapper of two
 * iterators.
 * 
 * For example, given two lists: i0 = [1,2,3,4] i1 = [5,6]
 * 
 * ZigzagIterator it(i0, i1);
 * 
 * while(it.has_next()) { print(it.get_next()); } The output of the above
 * pseudocode would be [1,5,2,6,3,4].
 * 
 * @author luoxiongcai
 *
 */
public class ZigzagIterator<T> {
	private List<T> list1 ;
	private  List<T> list2;
	private int size1 = 0;
	private int size2 = 0;
	private int ite1 = 0;
	private int ite2 = 0;
	private boolean choose1 = true;
	public ZigzagIterator(List<T> list1, List<T> list2) {
		this.list1 = list1;
		this.list2 = list2;
		this.size1 = list1 == null ? 0 : list1.size();
		this.size2 = list2 == null ? 0 : list2.size();
	}
	
	public boolean hasNext(){
		return ite1 < size1 || ite2 < size2;
	}
	
	public T next(){
		T result = null;
		if (choose1){
			result = list1.get(ite1++);
			choose1 = list2 == null || ite2 == list2.size() ? true : false;
		} 
		else {
			result = list2.get(ite2++);
			choose1 = list1 == null || ite1 == list1.size() ? false : true;
		}
		return result;
		
	}
	
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		list1.addAll(Arrays.asList(1,2,3));
		List<Integer> list2 = new ArrayList<Integer>();
//		list2.addAll(Arrays.asList(1));
		ZigzagIterator<Integer> zig = new ZigzagIterator<Integer>(null,null);
		while(zig.hasNext())
			System.out.println(zig.next());
	}

}
