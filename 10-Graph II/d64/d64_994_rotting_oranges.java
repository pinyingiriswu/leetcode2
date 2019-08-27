public class d64_994_rotting_oranges {
    /** Time: O(m*n)
     * Space: O(m*n)
     * */
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int fresh = 0;

        // count the number of fresh oranges first
        // if there are rotten oranges, we push the location of rotten oranges into queue and mark them as visited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        // if there are no fresh oranges, no need to wait
        if (fresh == 0) return 0;

        // traverse the neighbors of the rotten oranges and see if there's any fresh oranges
        // if there are fresh oranges, we mark them as visited and rotten, then add their locations to the queue
        int time = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] top = q.poll();
                for (int[] dir: dirs) {
                    int x = top[0] + dir[0];
                    int y = top[1] + dir[1];
                    if (check(x, y, grid, visited)) {
                        fresh--;
                        visited[x][y] = true;
                        grid[x][y] = 2;
                        q.offer(new int[] {x, y});
                    }
                    if (fresh == 0) return time;
                }
            }
            time++;
        }
        return -1;
    }

    private boolean check(int x, int y, int[][] grid, boolean[][] visited) {
        if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1 || visited[x][y] || grid[x][y] != 1) {
            return false;
        } else {
            return true;
        }
    }
}
