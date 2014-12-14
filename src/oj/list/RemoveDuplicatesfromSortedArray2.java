package oj.list;

public class RemoveDuplicatesfromSortedArray2 {

    public int removeDuplicates(int[] A) {
    	int size=A.length;
    	if(size<=2) return size;
    	int index=2;
    	for(int i=2;i<size;i++){
    		if(A[i]!=A[index-2]){
    			A[index]=A[i];
    			index++;
    		}
    	}
    	return index;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesfromSortedArray2 t=new RemoveDuplicatesfromSortedArray2();
		int [] A={1,1,2,2,2,3};
		for(int a :A)
			System.out.print(a+"\t");
		System.out.println();
		System.out.println(t.removeDuplicates(A));
	}

}
