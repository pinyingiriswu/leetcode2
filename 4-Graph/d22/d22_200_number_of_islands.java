public class d22_200_number_of_islands {

    /** DFS */
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int row, int col, char[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;

        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == '0' || visited[row][col]) return;

        visited[row][col] = true;

        dfs(row + 1, col, grid, visited);
        dfs(row - 1, col, grid, visited);
        dfs(row, col + 1, grid, visited);
        dfs(row, col - 1, grid, visited);

    }


    /** BFS */
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    q.add(new int[] {i, j});
                    visited[i][j] = true;
                    while (!q.isEmpty()) {
                        int[] t = q.poll();
                        for (int[] dir: dirs) {
                            int x = t[0] + dir[0];
                            int y = t[1] + dir[1];
                            if (check(x, y, grid, visited)) {
                                visited[x][y] = true;
                                q.add(new int[] {x, y});
                            }
                        }
                    }

                }

            }
        }
        return count;

    }

    private boolean check(int x, int y, char[][] grid, boolean[][] visited) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] == '0' ) return false;
        else
            return true;
    }
}
