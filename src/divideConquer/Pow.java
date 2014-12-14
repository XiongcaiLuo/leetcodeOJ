package divideConquer;

public class Pow {

	/**
	 * 
	 * @param args
	 */
    public double pow(double x, int n) {
        if(n<0) return 1.0/power(x,-n);
        else return power(x,n);
    }
	private double power(double x, int n) {
		if(n==0) return 1;
		else if(n==1) return x;
		double v=pow(x,n/2);
		if(n%2==0) return v*v;
		else return v*v*x;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
