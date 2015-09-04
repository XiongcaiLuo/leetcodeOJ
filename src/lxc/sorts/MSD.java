package lxc.sorts;
/**
 * three-way radix quicksort.
 * Strings may have various length.
 * @author luoxiongcai
 *
 */
public class MSD {
	private final int CUTOFF = 5;
	public void sort(String[] strs){
		if (strs == null || strs.length == 0) return;
		sort(strs, 0, strs.length - 1, 0);
	}
	
	private void sort(String[] strs, int lo, int hi, int d){
		if ( hi <= lo + CUTOFF){
			insertionSort(strs, lo , hi, d);
			return;
		}
		int pivot = charAt(strs[lo], d);	
		int lt = lo + 1, gt = hi, i = lo + 1;
		while ( i <= gt ){
			if (charAt(strs[i],d) < pivot ) exch(strs, lt++, i++);
			else if(charAt(strs[i],d) > pivot) exch(strs, i, gt--);
			else i++;
		}
		sort(strs, lo, lt - 1, d);
		if (pivot > 0) sort(strs, lt, gt, d + 1);
		sort(strs, gt + 1, hi, d);
	}
	
	private void exch(String[] strs, int i, int j){
		String temp = strs[j];
		strs[j] = strs[i];
		strs[i] = temp;
	}
	
	private int charAt(String s, int d){
		if (d >= s.length()) return -1;
		else return (int) s.charAt(d);
	}
	
	private void insertionSort(String[] strs, int lo, int hi, int d){
		if ( hi <= lo) return;
		for ( int i = lo + 1; i <= hi; i++){
			for (int j = i ; j > lo; j--){
				if (charAt(strs[j],d) < charAt(strs[j-1],d)) exch(strs, j, j-1);
			}
		}
	}
	public static void main(String[] args) {
		MSD msd = new MSD();
		String[] strs = {"hello","liu","aha","y"};
		msd.sort(strs);
		for (String s : strs)
			System.out.print(s+" ");
	}

}
