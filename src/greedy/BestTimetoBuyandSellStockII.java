package greedy;

public class BestTimetoBuyandSellStockII {

	/**
	 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at many transactions as you like.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
	 * @param args
	 */
	public int maxProfit(int[] prices){
		int sum = 0;
		for (int i = 1; i < prices.length; i++) {
		int diff = prices[i] - prices[i - 1];
		if (diff > 0) sum += diff;
		}
		return sum;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
