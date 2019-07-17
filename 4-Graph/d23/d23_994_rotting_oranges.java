public class d23_994_rotting_oranges {
    
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return -1;
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        // 1. count the number of fresh oranges
        // 2. track the rotten oranges and place them in queue, mark them as visited
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                else if (grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        // if no fresh oranges, there's no time need to wait
        if (fresh == 0) return 0;

        // traverse the neighbors of rotten oranges and see if there are any fresh oranges
        // if there are fresh oranges, we mark them as visited and rotten, add them to the queue as well
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
                        q.add(new int[] {x, y});
                    }
                    if (fresh == 0) return time;
                }
            }
            time++;
        }
        return -1;
    }

    private boolean check(int x, int y, int[][] grid, boolean[][] visited) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] != 1) return false;
        else
            return true;
    }
}
