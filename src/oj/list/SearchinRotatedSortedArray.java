package oj.list;

public class SearchinRotatedSortedArray {

	/**
	 * @param args
	 */

    public static int search(int[] A, int target) {
        int begin=0,end=A.length-1;
        while(begin<=end){
        	int middle=(begin+end)/2;
        	if(A[middle]==target) return middle;
        	if(A[begin]<=A[middle]){
        		if(A[begin]<=target &&target<A[middle])
        			end=middle-1;
        		else begin=middle+1;
        			
        	}
        	else{
        		if(A[middle]<target && target<=A[end])
        			begin=middle+1;
        		else end=middle-1;
        	}
        }
        return -1;
    }
    
    public static boolean search2(int[] A, int target) {
        int begin=0,end=A.length-1;
        while(begin<=end){
        	int middle=(begin+end)/2;
        	if(A[middle]==target ) return true;
        	
        	if(A[begin]<A[middle]){
        		if(A[begin]<=target &&target<A[middle])
        			end=middle-1;
        		else begin=middle+1;
        			
        	}
        	else if(A[begin]>A[middle]){
        		if(A[middle]<target && target<=A[end])
        			begin=middle+1;
        		else end=middle-1;
        	}
        	else{
        		boolean flag=meiju(A,begin,end,target);
        		if(flag) return true;
        		else{
        			begin=middle+1;
        			
        		}
        	}
        }
        return false;
    }
    public static boolean meiju(int[]A,int begin,int end,int target){
    	for(int i=begin;i<=end;i++){
    		if(A[i]==target) return true;
    	}
    	return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A={1,1,3,1};
//		System.out.println(search(A,1));
		System.out.println(search2(A,3));
	}

}
