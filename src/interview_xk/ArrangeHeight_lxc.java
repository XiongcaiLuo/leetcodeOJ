package interview_xk;


//package interviewquestions.google;

import java.util.*;

/**
 * You are given two array, first array contain integer which represent heights
 * of persons and second array contain how many persons in front of him are
 * standing who are greater than him in term of height and forming a queue. Ex
 * A: 3 2 1 B: 0 1 1 It means in front of person of height 3 there is no person
 * standing, person of height 2 there is one person in front of him who has
 * greater height then he, similar to person of height 1. Your task to arrange
 * them Ouput should be. 3 1 2 Here - 3 is at front, 1 has 3 in front ,2 has 1
 * and 3 in front.
 */
/**
 * Main idea of this problem is that, when sorting in descending order, and we
 * insert from the back to the front, wont affects the already existed order.
 */

public class ArrangeHeight_lxc {
	/**
	 * if time permits, a statistic-order tree is useful.(a special red-black tree)
	 * it supports dynamic topk query.
	 * @author luoxiongcai
	 *
	 */
	private static class HeightArray{
		int [] height;
		int num;
		public HeightArray(int [] height){
//			this.height = height;        // may change the original height array.
			this.height = Arrays.copyOf(height, height.length);
			Arrays.sort(this.height);
			reverse();
			this.num = height.length;
		}
		private void reverse(){
			for (int i = 0; i < height.length/ 2; i++){
				int temp = height[i];
				height[i] = height[ height.length - 1 - i];
				height[ height.length - 1 - i] = temp;
			}
		}
		
		public int pollK(int k){ // top -k max.
			int nk = height[k-1];
			System.arraycopy(height, k, height, k - 1 , num - k );
			num--;
			return nk;
		}
	}

    public void findArrange(int[] height, int[] tallerPerson) {
    	assert height.length == tallerPerson.length;
    	HeightArray ha = new HeightArray(height);
    	int[] result = new int[height.length];
    	for (int i = result.length - 1; i >= 0 ; i--){
    		result[i] = ha.pollK(tallerPerson[i] + 1);
    	}
    	// if needed.
    	System.arraycopy(result, 0, height, 0, result.length);
    }
    
    public static void main(String[] args){
    	ArrangeHeight_lxc ah = new ArrangeHeight_lxc();
    	int[] height = {2,3,1};
    	int[] tallerPerson = {0,1,1};
    	ah.findArrange(height, tallerPerson);
    	for (int a : height)
    		System.out.print(a+" ");
    }
}
