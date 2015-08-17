package list;

import java.util.LinkedList;

public class Test extends LinkedList<Integer> {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s ="1+2-3*4=3";
		String [] tokens = s.split("\\+|\\-|\\*|=");
		System.out.println(tokens);
	}

}
