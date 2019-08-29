public class d66_286_walls_and_gates {
    /** Time: O(m*n)
     * Space: O(m*n) --> worst case
     * */
    int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();

        // we do BFS on the gates to find the closest empty room instead
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] top = q.poll();
            for (int[] dir: dirs) {
                int x = top[0] + dir[0];
                int y = top[1] + dir[1];
                if (check(rooms, x, y)) {
                    rooms[x][y] = rooms[top[0]][top[1]] + 1;
                    q.offer(new int[] {x, y});
                }
            }
        }
    }

    private boolean check(int[][] rooms, int x, int y) {
        if (x < 0 || x > rooms.length - 1 || y < 0 || y > rooms[0].length - 1 || rooms[x][y] != Integer.MAX_VALUE) {
            return false;
        } else {
            return true;
        }
    }
}
