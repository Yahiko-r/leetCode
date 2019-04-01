package array;

public class BestBuySellStockII {
    public int maxProfit(int[] prices) {
        int min = 0, profit = 0;
        for (int i = 1; i < prices.length; i++) {

            if (prices[i] >= prices[i - 1]) {
                if (i == prices.length - 1)
                    profit += prices[i] - prices[min];
            } else {
                profit += prices[i - 1] - prices[min];
                min = i;
            }
        }
        return profit;
    }
}
