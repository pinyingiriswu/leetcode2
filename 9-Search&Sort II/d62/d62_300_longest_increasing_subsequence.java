public class d62_300_longest_increasing_subsequence {

    /** Method 1: DP */
    /** Time: O(n^2))
     * Space: O(n)*/
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int i, j, max = 0;

        for (i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        for (i = 0; i < n; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    /** Method 2: Binary Search */
    /** Time: O(nlogn))
     * Space: O(n)*/
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for (int i = 1; i < n; i++) {
            if (nums[i] < list.get(0)) {
                list.set(0, nums[i]);
            } else if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                int left = 0;
                int right = list.size() - 1;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (list.get(mid) < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                list.set(right, nums[i]);
            }
        }
        return list.size();
    }
}
