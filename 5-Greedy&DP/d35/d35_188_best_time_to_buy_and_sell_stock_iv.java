public class d35_188_best_time_to_buy_and_sell_stock_iv {
    /** Time: O(n^2)
     * Space: O(n) */
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        int res = 0;

        // if k >= prices.length/2, that means we can make any number of transactions
        // as long as the profit between any two days > 0
        if (k >= n/2) {
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i-1]) {
                    res += prices[i] - prices[i-1];
                }
            }
            return res;
        }

        // if k < prices.length/2, we track the max profit for each buy and sell operation of k transactions
        // 1. The max profit of buy operation is the profit from (i-1)th sell operation - current price:
        // buy[i] = Math.max(sell[i - 1] + price, buy[i]);
        int[] buy = new int[n + 1];

        // 2. The max profit of sell operation is the profit from (i)th buy operation + current price:
        // sell[i] = Math.max(buy[i] + price, sell[i]);
        int[] sell = new int[n + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        Arrays.fill(sell, 0);

        for (int price: prices) {
            for (int i = 1; i <= k; i++) {
                buy[i] = Math.max(sell[i-1] - price, buy[i]);
                sell[i] = Math.max(buy[i] + price, sell[i]);
            }
        }
        return sell[k];
    }
}
