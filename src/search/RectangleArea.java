package search;
/**
 * 
 * @author luoxiongcai
 *
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int s1 = (C-A)*(D-B);
        int s2 =(G-E)*(H-F);
        int total = s1+s2;
        if(E >=C || G <=A || F>=D ||H<=B) return total;
        return total - coverLen(A,C,E,G) * coverLen(B,D,F,H);
    }
    
    private int coverLen(int A,int B, int C, int D){
        if(C >=A) return Math.min(B-C,D-C);
        else return Math.min(D-A,B-A);  
    }
	public static void main(String[] args) {
		
	}

}
