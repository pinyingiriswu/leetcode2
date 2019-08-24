public class d61_1062_longest_repeating_substring {
    /** Method 1: DP */
    /** Time: O(n^2)
     * Space: O(n^2)*/
    public int longestRepeatingSubstring(String S) {
        int n = S.length();
        //dp[i][j] means the longest repeating substring ending at i and j
        int[][] dp = new int[n+1][n+1];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (S.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }

    /** Method 2: Binary Search with HashSet */
    /** Time: O(nlogn) -> average case, O(n^2) -> worst case
     * Space: O(n^2) -> keeping hashset */
    public int longestRepeatingSubstring(String S) {
        int n = S.length();

        int left = 1; // smallest repeating substring length
        int right = n; // largest repeating substring length

        // finding longest repeating substring length using binary search
        while(left <= right) {
            int len = left + (right - left) / 2;
            if (check(len, n, S)) {
                left = len + 1; //if there is repeating substring with length of len, we continue to explore longer length
            } else {
                right = len - 1;
            }
        }
        return left - 1;
    }

    // check if any repeating substring with length of len
    private boolean check(int len, int n, String S) {
        HashSet<String> set = new HashSet<>();
        String tmp;
        for (int i = 0; i < n - len + 1; i++) {
            tmp = S.substring(i, i + len);
            if (set.contains(tmp)) {
                return true;
            }
            set.add(tmp);
        }
        return false;
    }
}
