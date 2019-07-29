public class d35_10_regular_expression_matching {
    /** Time: O(n^2)
     * Space: O(n^2) */
    public boolean isMatch(String s, String p) {
        /** Reference: https://blog.csdn.net/hk2291976/article/details/51165010
         * 1. p.charAt(j) == s.charAt(i) : dp[i][j] = dp[i-1][j-1]
         * 2. If p.charAt(j) == ‘.’ : dp[i][j] = dp[i-1][j-1];
         * 3. If p.charAt(j) == ‘*’:
         *      here are two sub conditions:
         *      if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2] //in this case, a* only counts as empty
         *      if p.charAt(j-1) == s.charAt(i) or p.charAt(i-1) == ‘.’:
         *          dp[i][j] = dp[i-1][j] //in this case, a* counts as multiple a
         *          dp[i][j] = dp[i][j-1] // in this case, a* counts as single a
         *          dp[i][j] = dp[i][j-2] // in this case, a* counts as empty */

        int ls = s.length() + 1;
        int lp = p.length() + 1;

        boolean[][] dp = new boolean[ls][lp];

        for (int i = 0; i < ls; i++) {
            for (int j = 0; j < lp; j++) {
                dp[i][j] = false;
            }
        }

        dp[0][0] = true;

        for (int i = 1; i < lp; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i < ls; i++) {
            for (int j = 1; j < lp; j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i][j] | dp[i-1][j];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
