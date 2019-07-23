public class d29_121_best_time_to_buy_and_sell_stock {

    public int maxProfit(int[] prices) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minVal) {
                minVal = Math.min(minVal, prices[i]);
            }
            maxVal = Math.max(maxVal, prices[i] - minVal);
        }
        return maxVal;
    }
}
