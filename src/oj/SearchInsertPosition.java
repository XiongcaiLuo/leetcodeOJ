package oj;

public class SearchInsertPosition {

	/**
	 * @param args
	 */
    public static int searchInsert(int[] A, int target) {
        if(A==null||A.length==0) return 0;
        int len=A.length;
        int ptr=0;
        for(;ptr<len;ptr++){
        	if(target<=A[ptr]){
        		break;
        	}
        	
        }
        
        return ptr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]A={1,3,5,6};
		System.out.println(searchInsert(A,7));
	}

}
