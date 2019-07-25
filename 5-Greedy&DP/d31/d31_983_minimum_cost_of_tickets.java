public class d31_983_minimum_cost_of_tickets {
    /** Time: O(n)
     * Space: O(n) */
    public int mincostTickets(int[] days, int[] costs) {
        int max = days[days.length - 1];
        int[] dp = new int[max + 1];
        int j = 0;

        // dp[i] means the minimum cost to cover up to ith day
        for (int i = days[0]; i <= max; i++) {
            if (days[j] == i) {
                dp[i] = dp[i - 1] + costs[0];
                dp[i] = Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[i]);
                dp[i] = Math.min(dp[Math.max(0, i - 30)] + costs[2], dp[i]);
                j++;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[max];
    }
}
