package dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Test {


	public static void main(String[] args)  {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);a.add(2);
		lists.add(a);
		List<Integer> b = new ArrayList<Integer>();
		b.add(2);b.add(1);
		System.out.println(lists.contains(b));
	}

}
