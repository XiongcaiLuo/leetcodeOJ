package list;

public class SingleNumberK {

	/**
	 * all number exits k times, except one exits just one time.
	 * k>=3
	 * @param args
	 */
	public int findSingle(int[]A,int k){
		int[] mask = new int[k];
		for(int i=0;i<A.length;i++){
			int jinwei = mask[1] & A[i];  
			mask[1] ^=A[i];
			for(int j=2;j<k;j++){
				int jinweiNext = mask[j] & A[i];
				mask[j] &= ~jinweiNext;
				mask[j] |=jinwei;
				jinwei =jinweiNext;
			}
			if(jinwei !=0){
				for(int j=1;j<k;j++)
					mask[j] &= ~jinwei;
			}
				

		}
		return mask[1];
	}
	public static void main(String[] args) {
		SingleNumberK s=new SingleNumberK();
		int[] A={-2,-2,1,1,-3,1,-3,-3,-4,-2};
		int k=3;
		int target = s.findSingle(A, k);
		System.out.println("target:"+target);
		
		System.out.println(Integer.toBinaryString(100)+"\t"+Integer.parseInt("1000100", 2));
		
	}

}
