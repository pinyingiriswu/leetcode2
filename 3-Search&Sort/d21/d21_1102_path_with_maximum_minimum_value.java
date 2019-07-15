public class d21_1102_path_with_maximum_minimum_value {

    public int maximumMinimumPath(int[][] A) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (A[b[0]][b[1]] - A[a[0]][a[1]]));
        int m = A.length;
        int n = A[0].length;
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int minScore = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[m][n];

        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            minScore = Math.min(minScore, A[top[0]][top[1]]);

            if (top[0] == m - 1 && top[1] == n - 1) {
                break;
            }

            for (int[] dir: dirs) {
                int x = top[0] + dir[0];
                int y = top[1] + dir[1];
                if (!(x < 0 || x > m - 1 || y < 0 || y > n - 1) && !visited[x][y]) {
                    visited[top[0]][top[1]] = true;
                    pq.add(new int[] {x, y});
                }
            }
        }
        return minScore;
    }
}
