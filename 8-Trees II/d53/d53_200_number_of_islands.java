public class d53_200_number_of_islands {

    /** DFS */
    /** Time: O(M*N)
     * Space: O(M*N) */
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';

        dfs(i-1, j, grid);
        dfs(i+1, j, grid);
        dfs(i, j-1, grid);
        dfs(i, j+1, grid);
    }

    /** BFS */
    /** Time: O(M*N)
     * Space: O(min(M, N)) */
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = { {0, -1}, {0, 1}, {-1, 0}, {1, 0} };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    q.offer(new int[] {i, j});
                    visited[i][j] = true;
                    while(!q.isEmpty()) {
                        int[] t = q.poll();
                        for(int[] dir: dirs) {
                            int x = t[0] + dir[0];
                            int y = t[1] + dir[1];
                            if(check(x, y, grid, visited)) {
                                visited[x][y] = true;
                                q.offer(new int[]{x, y});
                            }
                        }
                    }
                }
            }
        }

        return count;
    }

    private boolean check(int i, int j, char[][] grid, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == '0') {
            return false;
        }
        return true;
    }
}
