package array;

public class BestBuySellStock {
    public int maxProfit(int[] prices) {
        int min = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[min]) {
                if (prices[i] - prices[min] > profit)
                    profit = prices[i] - prices[min];
            } else {
                min = i;
            }
        }
        return profit;
    }
}
