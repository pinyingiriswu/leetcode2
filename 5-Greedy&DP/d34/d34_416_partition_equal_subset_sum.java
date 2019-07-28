public class d34_416_partition_equal_subset_sum {
    /** Time: O(n^2)
     * Space: O(n) */
    public boolean canPartition(int[] nums) {
        int sum  = 0;
        for (int num: nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        sum /= 2;

        boolean[] dp = new boolean[sum + 1];

        // dp[i]: can we retrieve numbers from nums array that sums up to i?
        dp[0] = true;

        for (int num: nums) {
            for (int j = sum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[sum];
    }
}
