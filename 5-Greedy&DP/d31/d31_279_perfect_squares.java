public class d31_279_perfect_squares {
    /** Time: O(n^2)
     * Space: O(n) */
    public int numSquares(int n) {
        double sqrt = Math.sqrt(n);
        int t = (int) Math.ceil(sqrt);
        int[] nums = new int[t + 1];
        for (int i = 0; i <= t; i++) {
            nums[i] = i*i;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= t; j++) {
                if (nums[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - nums[j]] + 1);
                }
            }
        }
        return dp[n];
    }
}
