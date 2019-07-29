public class d35_486_predict_the_winner {
    /** Time: O(n^2)
     * Space: O(n^2) */
    public boolean PredictTheWinner(int[] nums) {
        /** If player1 picks nums[i] (nums[j]),
         * then dp[i - 1][j] (dp[i][j - 1]) denotes the max sum player2 can get */

        /** Transfer formula:
         * dp[i][j] = Math.max(sum[i][j] - dp[i + 1][j], sum[i][j] - dp[i][j - 1]) */
        if (nums.length == 1) {
            return true;
        }
        // dp[i][j]: the max sum a player can get from nums[i] to nums[j]
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        int sum = 0;
        for (int end = 1; end < nums.length; end++) {
            sum = nums[end];
            for (int start = end - 1; start >= 0; start--) {
                sum += nums[start];
                dp[start][end] = Math.max(sum - dp[start + 1][end], sum - dp[start][end - 1]);
            }
        }
        return dp[0][nums.length - 1] * 2 >= sum;
    }
}
