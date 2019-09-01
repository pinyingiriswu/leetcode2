public class d67_505_the_maze_ii {
    /** Reference: http://www.noteanddata.com/leetcode-505-The-Maze-II-java-solution-note.html */

    /** Time: O(m * n * max(m, n))
     * Space: O(m * n)
     * */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
        int m = maze.length;
        int n = maze[0].length;
        int[][] minDist = new int[m][n];
        for (int[] md: minDist) {
            Arrays.fill(md, Integer.MAX_VALUE);
        }
        q.offer(start);
        minDist[start[0]][start[1]] = 0;

        while (!q.isEmpty()) {
            int[] top = q.poll();
            for (int[] dir: dirs) {
                int x = top[0] + dir[0];
                int y = top[1] + dir[1];
                int step = minDist[top[0]][top[1]];
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    step++;
                }
                // meet wall, step back
                x -= dir[0];
                y -= dir[1];

                // when reaching stop point, only when the current distance (step) is smaller
                // then previous distance stored in minDist we choose to proceed until next stop point
                if (step < minDist[x][y]) {
                    minDist[x][y] = step;
                    q.offer(new int[] {x, y});
                }
            }
        }

        return minDist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1: minDist[destination[0]][destination[1]];
    }
}
