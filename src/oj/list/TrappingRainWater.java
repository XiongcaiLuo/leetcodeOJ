package oj.list;


public class TrappingRainWater{
	public static int trap(int[] A){
		int[] leftMax=new int[A.length];
		int[] rightMax=new int[A.length];
		int max=-1;
		for(int i=0;i<A.length;i++){
			if(A[i]>max){
				max=A[i];
			}
			leftMax[i]=max;
		}
		max=-1;
		for(int i=A.length-1;i>=0;i--){
			if(A[i]>max){
				max=A[i];
			}
			rightMax[i]=max;
		}
		int sum=0;
		for(int i=0;i<A.length;i++){
			sum+=Math.min(leftMax[i], rightMax[i])-A[i];
		}
		return sum;
		
	}
}