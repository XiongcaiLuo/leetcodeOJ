package search;

/**
 * Suppose you are at a party with n people (labeled from 0 to n ¨C 1) and among
 * them, there may exist one celebrity. The definition of a celebrity is that
 * all the other n ¨C 1 people know him/her but he/she does not know any of them.
 * 
 * Now you want to find out who the celebrity is or verify that there is not
 * one. The only thing you are allowed to do is to ask questions like: ¡°Hi, A.
 * Do you know B?¡± to get information of whether A knows B. You need to find out
 * the celebrity (or verify there is not one) by asking as few questions as
 * possible (in the asymptotic sense).
 * 
 * You are given a helper function bool knows(a, b) which tells you whether A
 * knows B. Implement a function int findCelebrity(n), your function should
 * minimize the number of calls to knows.
 * 
 * Note: There will be exactly one celebrity if he/she is in the party. Return
 * the celebrity¡¯s label if there is a celebrity in the party. If there is no
 * celebrity, return -1.
 * 
 * @author luoxiongcai
 *
 */
public class FindCelebrity {
    public int findCelebrity(int n) {
        if(n <=1) return 0;
         
        //Below is the elimination process. If the left people knows right, we will eliminate left person, which is left++; else we will eliminate the right person, which is the step right--. After we go through all these steps, we'll know that only one person is left that satisfies our logic.
        int left = 0;
        int right = n-1;
        while(left < right){
            if(knows(left, right)) left++;
            else right--;
        }
         
        //Last but not least, here we need to check whether the only person is the real celebrity. Consider one example, if A does not know B and B does not know A either, then A and B would not be celebrity. So we need to check the negative case, which is left knows some person or any person does not know the left person.
        for(int i = 0; i < n; i++){
            if(i != left){
                if(knows(left, i) || !knows(i, left)) return -1;
            }
        }
         
        return left;
    }
    
    private boolean knows(int i, int j){
    	return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
