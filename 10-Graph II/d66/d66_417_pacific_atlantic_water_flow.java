public class d66_417_pacific_atlantic_water_flow {

    /** DFS */
    /** Time: O(m*n)
     * Space: O(m*n)
     * */
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // vertical direction
        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific, i, 0);
            dfs(matrix, atlantic, i, n - 1);
        }

        // horizontal direction
        for (int i = 0; i < n; i++) {
            dfs(matrix, pacific, 0, i);
            dfs(matrix, atlantic, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if location can both flow in pacific and atlantic,
                // that means water can flow back and forth to pacific and atlantic
                // thus, we add such location to the result
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int i, int j) {
        if (visited[i][j]) return;

        visited[i][j] = true;

        // if the height of the four directions are higher than current location, water can flow
        if (i >= 0 && i < matrix.length - 1 && j >= 0 && j < matrix[0].length && matrix[i][j] <= matrix[i + 1][j]) {
            dfs(matrix, visited, i + 1, j);
        }
        if (i > 0 && i < matrix.length && j >= 0 && j < matrix[0].length && matrix[i][j] <= matrix[i - 1][j]) {
            dfs(matrix, visited, i - 1, j);
        }
        if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length - 1 && matrix[i][j] <= matrix[i][j + 1]) {
            dfs(matrix, visited, i, j + 1);
        }
        if (i >= 0 && i < matrix.length && j > 0 && j < matrix[0].length && matrix[i][j] <= matrix[i][j - 1]) {
            dfs(matrix, visited, i, j - 1);
        }
    }

    /** BFS */
    /** Time: O(m*n)
     * Space: O(m*n) --> worst case
     * */

    int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();

        // vertical direction
        for (int i = 0; i < m; i++) {
            pQueue.offer(new int[] {i, 0});
            aQueue.offer(new int[] {i, n - 1});
            pacific[i][0] = true;
            atlantic[i][n - 1] = true;
        }

        // horizontal direction
        for (int i = 0; i < n; i++) {
            pQueue.offer(new int[] {0, i});
            aQueue.offer(new int[] {m - 1, i});
            pacific[0][i] = true;
            atlantic[m - 1][i] = true;
        }

        bfs(matrix, pacific, pQueue);
        bfs(matrix, atlantic, aQueue);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if location can both flow in pacific and atlantic,
                // that means water can flow back and forth to pacific and atlantic
                // thus, we add such location to the result
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    private void bfs(int[][] matrix, boolean[][] visited, Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] top = q.poll();
            for (int[] dir: dirs) {
                int x = top[0] + dir[0];
                int y = top[1] + dir[1];
                if (x < 0 || x > matrix.length - 1 || y < 0 || y > matrix[0].length - 1 || visited[x][y] || matrix[x][y] < matrix[top[0]][top[1]]) {
                    continue;
                }
                visited[x][y] = true;
                q.offer(new int[] {x, y});
            }
        }
    }
}
