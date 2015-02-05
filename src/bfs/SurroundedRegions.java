package bfs;

import java.util.ArrayList;

public class SurroundedRegions {

	/**
	 * here is a test for eclipse jee .
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> re =new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> triple = new ArrayList<Integer>();
		triple.add(3);
		triple.add(4);
		re.add(triple);
		ArrayList<Integer> triple2 = new ArrayList<Integer>();
		triple2.add(3);
		triple2.add(4);
		
		System.out.println(re.contains(triple2));
	}

}
