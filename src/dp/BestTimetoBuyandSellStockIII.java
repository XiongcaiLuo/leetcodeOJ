package dp;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 * 
 * @param args
 */
public class BestTimetoBuyandSellStockIII {

	/**
	 * 用两个数组分别储存[0,i],[i,n-1]两个区间的最大利润。
	 */

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;
		int n = prices.length;
		int[] leftProfit = new int[n];
		int[] rightProfit = new int[n];

		int curmin = prices[0];
		leftProfit[0] = 0;
		for (int i = 1; i < n; i++) {
			curmin = Math.min(curmin, prices[i]);
			leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - curmin);
		}
		int curmax = prices[n - 1];
		rightProfit[n - 1] = 0;
		for (int i = n - 2; i >= 0; i--) {
			curmax = Math.max(curmax, prices[i]);
			rightProfit[i] = Math.max(rightProfit[i + 1], curmax - prices[i]);
		}

		int maxpro = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++)
			maxpro = Math.max(maxpro, leftProfit[i] + rightProfit[i]);
		return maxpro;
	}
	

	public static void main(String[] args) {

	}

}
