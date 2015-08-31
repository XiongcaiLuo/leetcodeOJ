package divideConquer;

public class Sqrt {

	/**
	 * @param args
	 */
    public int sqrt(int x) {
     	if(x < 2) return x;
        int left=1, right = x;
        int last_mid = 1;
        while(left < right){
        	int mid = (left + right) / 2;
        	if ( mid > x / mid){
        		right = mid - 1;
        	} else {
        	    last_mid = mid;
        		left = mid + 1;
        	}
        }
        return last_mid;  
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
