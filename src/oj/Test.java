package oj;

import java.util.HashMap;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 HashMap<Double,Integer > slops=new HashMap();
		 slops.put(1.01, 1);
		 slops.put(1.01,2);
		 System.out.println(slops.size());
		 slops.put(1.0101, 2);
		 System.out.println(slops.size());
	}

}
