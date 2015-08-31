package greedy;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * @param args
 */
public class BestTimetoBuyandSellStock {

	public int maxProfit(int[] prices) {
		if (prices.length == 0) return 0;
		int curMinBuy = prices[0];
		int curProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			curMinBuy = Math.min(curMinBuy, prices[i]);
			curProfit = Math.max(curProfit, prices[i] - curMinBuy);
		}
		return curProfit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
