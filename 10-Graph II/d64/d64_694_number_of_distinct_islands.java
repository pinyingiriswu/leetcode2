public class d64_694_number_of_distinct_islands {
    /** Time: O(m*n)
     * Space: O(n)
     * */
    public int numDistinctIslands(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        Set<String> set = new HashSet<String>();
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb);
                    set.add(sb.toString());
                }
            }
        }

        return set.size();
    }

    private void dfs(int[][] grid, int row, int col, StringBuilder sb) {
        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1 || grid[row][col] == 0) {
            return;
        }

        grid[row][col] = 0;

        // define different shapes in string format and add it to hashset afterwards
        dfs(grid, row - 1, col, sb.append('T'));
        dfs(grid, row + 1, col, sb.append('B'));
        dfs(grid, row, col - 1, sb.append('L'));
        dfs(grid, row, col + 1, sb.append('R'));
    }
}
