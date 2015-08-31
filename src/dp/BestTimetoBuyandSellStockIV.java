package dp;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most k
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 * 
 * @author luoxiongcai
 *
 */
public class BestTimetoBuyandSellStockIV {
	/**
	 * 
	 * @param k
	 * @param prices
	 * @return
	 */
    public int maxProfit(int k, int[] prices) {
		if (prices.length < 2) return 0;
	    if (k > (prices.length - 1)/2 ){
		    return maxProfit2(prices);
		}
		int[] nums = new int[prices.length-1];
		for (int i = 0 ; i < nums.length; i++)
			nums[i] = prices[i+1] - prices[i];
		int n =  nums.length;

		int[] sum = new int[n+1];
		int[] preMax = new int[n+1];
		int max = 0;
		for (int i = 1; i <= k; i++){
			int[] curMax = new int[n+1];
			for( int j = i; j <=n ; j++){
				sum[j] = Math.max(sum[j-1], preMax[j-1])+nums[j-1] ;
				curMax[j] = Math.max(sum[j],curMax[j-1]);
			}
			preMax = curMax;
			if (max < preMax[n])
				max = preMax[n];
			else if (max == preMax[n])
				return max;
		}
		return max;       
    }

	public int maxProfit2(int[] prices){
		int sum = 0;
		for (int i = 1; i < prices.length; i++) {
		int diff = prices[i] - prices[i - 1];
		if (diff > 0) sum += diff;
		}
		return sum;
	}
	public static void main(String[] args) {
		BestTimetoBuyandSellStockIV bb = new BestTimetoBuyandSellStockIV();
		int k = 2;
		int[] prices = {0,8,5,7,4,7};
		int max = bb.maxProfit(k, prices);
		System.out.println(max);
	}

}
