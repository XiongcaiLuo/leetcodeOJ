package oj.list;

public class RemoveElement {

	/**
	 * Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
	 * @param args
	 */
    public static int removeElement(int[] A, int elem) {
    	int len=A.length;
    	if(len==0) return 0;
    	int index=0;
    	for(int a:A){
    		if(a!=elem){
    			A[index++]=a;
    		}
    			
    	}
		return index;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] A={2};
		System.out.println(removeElement(A, 3));
	}

}