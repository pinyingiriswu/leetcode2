public class d30_322_coin_change {
    /** Time: O(S*n) => where S is the amount, n is the number of elements
     * Space: O(S) => construct table of length S+1 */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin: coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1: dp[amount];
    }
}
