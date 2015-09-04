package lxc.sorts;

public class LSD {
	/**
	 * assume all strings have the same length;
	 * @param strs
	 */
	public static void sortStrings(String[] strs){
		if (strs == null || strs.length == 0) return ;
	
		int len = strs[0].length();
		String[] aux = new String[strs.length];
		for (int d = len - 1; d >= 0; d-- ){
			int[] count = new int[256];
			for (String s : strs)
				count[s.charAt(d)]++;
			for (int i = 1; i < 256; i++)
				count[i] += count[i - 1];
			for (int i = strs.length - 1; i >= 0 ; i--){
				aux[--count[strs[i].charAt(d)]] = strs[i];
			}
			System.arraycopy(aux, 0, strs, 0, strs.length);	
		}
	}
	
    // LSD radix sort: another way using count[];
    public static void sort(String[] a, int W) {
        int N = a.length;
        int R = 256;   // extend ASCII alphabet size
        String[] aux = new String[N];

        for (int d = W-1; d >= 0; d--) {
            // sort by key-indexed counting on dth character

            // compute frequency counts
            int[] count = new int[R+1];
            for (int i = 0; i < N; i++)
                count[a[i].charAt(d) + 1]++;

            // compute cumulates
            for (int r = 0; r < R; r++)
                count[r+1] += count[r];

            // move data
            for (int i = 0; i < N; i++)
                aux[count[a[i].charAt(d)]++] = a[i];

            // copy back
            for (int i = 0; i < N; i++)
                a[i] = aux[i];
        }
    }
    
	/**
	 * strings may have any length.
	 * 
	 * @param strs
	 */
	public static void sortStrings2(String[] strs){
		if (strs == null || strs.length == 0) return ;
		int w = 0;
		for (String s : strs)
			w = Math.max(w, s.length());
		String[] aux = new String[strs.length];
		for (int d = w - 1; d >= 0; d-- ){
			int[] count = new int[256 + 1];
			for (String s : strs)
				count[charAt(s,d) + 1]++;
			for (int i = 1; i <= 256; i++)
				count[i] += count[i - 1];
			for (int i = strs.length - 1; i >= 0 ; i--){
				int n = charAt(strs[i], d) + 1;
				aux[--count[n]] = strs[i];
			}
			System.arraycopy(aux, 0, strs, 0, strs.length);
		}
	}
	
	private static int charAt(String s, int d){
		if (d  >= s.length()) return -1;
		else return (int) s.charAt(d);
	}
    
    /**
     * SORT INTEGERS.
     * @param nums
     */
    public void sort(int[] nums){
    	if ( nums == null || nums.length == 0) return;
    	int MASK = (1 << 8 )- 1;            // be careful about the priority of ">>"
    	int[] aux = new int[nums.length];
    	for (int d = 0; d < 4; d++){
    		int[] count = new int[256 + 1];
    		for (int num : nums){
    			int n = (num >> 8*d) & MASK;
    			count[n+1]++;
    		}
    		for (int i = 0; i < 256; i++)
    			count[i+1] += count[i];
    		
    		// dealing with the negative situation.
    		if (d == 3){
    			int pos = count[128];
    			int neg = count[256] - count[128];
    			for (int i = 0; i < 128; i++)
    				count[i] += neg;
    			for (int i =128; i < 256; i++)
    				count[i] -= pos;
    		}
    		for(int i = 0; i < nums.length; i++){
    			int n = (nums[i] >>(8 * d)) & MASK;
    			aux[count[n]++] = nums[i];
    		}
    		System.arraycopy(aux, 0 , nums, 0, nums.length);
    	}
    	
    }
	public static void main(String[] args) {
		LSD  lsd = new LSD();
		int[] nums = {-3,2,6,-1,-10,8,9};
		lsd.sort(nums);
		for (int n : nums)
			System.out.print(n+" ");
		String[] strs = {"luoxiongcaihahaha","zhangxiaokang","wanghongchuan"};
		lsd.sortStrings2(strs);
		for (String s : strs)
			System.out.print(s+" ");
	}

}
