package dfs;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Test {



	public static void main(String[] args)  {
		BitSet bs = BitSet.valueOf(new long[]{(26+256)});
		int preSet = bs.previousSetBit(0);
		int nextSet = bs.nextSetBit(0);
		int preC = bs.previousClearBit(1);
		int nextC = bs.nextClearBit(1);
		byte[] bytes = bs.toByteArray();
		long[] longs = bs.toLongArray();
		String str = bs.toString();
		System.out.println(str);
		
		BitSet bs2 = BitSet.valueOf(new long[]{(6)});
		boolean inter = bs.intersects(bs2);
//		bs.and(bs2);
//		bs.or(bs2);
//		bs.xor(bs2);
		bs.andNot(bs2);
		System.out.println(bs.toString());
		
	}

}
