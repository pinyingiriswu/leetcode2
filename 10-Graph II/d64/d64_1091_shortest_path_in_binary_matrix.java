public class d64_1091_shortest_path_in_binary_matrix {
    /** Time: O(m*n)
     * Space: O(m*n)
     * */
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        if (grid[0][0] != 0 || grid[m-1][n-1] != 0) return -1;

        Queue<int[]> q = new LinkedList<>();

        visited[0][0] = true;
        q.offer(new int[] {0, 0});
        int path = 0;

        while (!q.isEmpty()) {
            path++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] top = q.poll();
                if (top[0] == m - 1 && top[1] == n - 1) return path;
                for (int[] dir: dirs) {
                    int x = top[0] + dir[0];
                    int y = top[1] + dir[1];
                    if (check(x, y, grid, visited)) {
                        visited[x][y] = true;
                        q.offer(new int[] {x, y});
                    }
                }
            }
        }
        return -1;
    }

    private boolean check(int x, int y, int[][] grid, boolean[][] visited) {
        if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1 || visited[x][y] || grid[x][y] != 0) return false;
        else
            return true;
    }
}
