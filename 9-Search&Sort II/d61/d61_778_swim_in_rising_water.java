public class d61_778_swim_in_rising_water {
    /** Time: O(n^2)
     * Space: O(n)*/
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (grid[a[0]][a[1]] - grid[b[0]][b[1]]));
        pq.add(new int[]{0, 0});
        int level = 0;
        int n = grid.length;
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        boolean[][] visited = new boolean[n][n];

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            level = Math.max(level, grid[top[0]][top[1]]);
            if (top[0] == n-1 && top[1] == n-1) {
                break;
            }
            for (int[] dir: dirs) {
                int x = top[0] + dir[0];
                int y = top[1] + dir[1];
                if (!(x < 0 || x > n - 1 || y < 0 || y > n-1) && !visited[x][y]) {
                    visited[top[0]][top[1]] = true;
                    pq.offer(new int[]{x, y});
                }
            }
        }
        return level;
    }
}
