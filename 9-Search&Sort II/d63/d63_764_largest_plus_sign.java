public class d63_764_largest_plus_sign {
    /** Time: O(n^2)
     * Space: O(n^2)*/

    /**
     * The basic idea is to record the min length of the 4 directions.
     * We go through 2 passes.
     *
     * The first pass is from left to right, top to bottom so that we can get the the min(left, top) for each element.
     * The second pass is from right to left , bottom to top so that we can get the min(right, bottom) for each element.
     *
     * Then, we can get the min value of 4 direction and find the max.
     * */

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(grid[i], 1);
        }
        for (int[] mine: mines) {
            grid[mine[0]][mine[1]] = 0;
        }

        int[] dp = new int[N];

        // first pass
        // count: length of left side
        // dp[j]: length of up side
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != 0) {
                    grid[i][j] = Math.min(++count, ++dp[j]);
                } else {
                    count = 0;
                    dp[j] = 0;
                }
            }
        }

        Arrays.fill(dp, 0);
        int max = 0;

        // second pass
        // count: length of right side
        // dp[j]: length of down side
        for (int i = N - 1; i >= 0; i--) {
            int count = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (grid[i][j] != 0) {
                    grid[i][j] = Math.min(grid[i][j], Math.min(++count, ++dp[j]));
                } else {
                    count = 0;
                    dp[j] = 0;
                }
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}
