package oj.list;

public class RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] A) {
    	int size=A.length;
    	if(size==0 || size==1) return size;
    	int len=1;
    	for( int i=1;i<size;i++){
    		if(A[i]!=A[i-1]){
    			A[len]=A[i];
    			len++;
    		}
    			
    	}
    	return len;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesfromSortedArray t=new RemoveDuplicatesfromSortedArray();
		int [] A={1,1,2};
		System.out.println(t.removeDuplicates(A));
	}

}
