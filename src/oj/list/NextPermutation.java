package oj.list;

public class NextPermutation {

	/**
	 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
	 * @param args
	 */
	public static void reverse(int[]num,int begin,int end){
    	for(int i=begin,j=end;i<j;i++,j--){
    		int temp=num[i];
    		num[i]=num[j];
    		num[j]=temp;
    	}
	}
    public static void nextPermutation(int[] num) {
        int len=num.length;
        int index=len-1;
        int minIndex=-1;
        int min=Integer.MAX_VALUE;
        for(;index>=1;index--){
        	if(num[index-1]<num[index])
        		break;

        }

        
        if(index==0){
        	//reverse the array
        	reverse(num,0,len-1);
        }
        else{
            //swap the index-1 with the minIndex; 
        	for(minIndex=index;minIndex<len;minIndex++)
        		if(num[minIndex]<=num[index-1])
        			break;
        	if(minIndex!=index) minIndex--;
            int temp=num[index-1];
            num[index-1]=num[minIndex];
            num[minIndex]=temp;
            //reverse  from the index to the end;
            reverse(num,index,len-1);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num={1,5,1};
		nextPermutation(num);
		for(int i:num)
			System.out.println("\t"+i);
	}

}
