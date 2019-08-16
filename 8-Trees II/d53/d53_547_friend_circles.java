public class d53_547_friend_circles {
    /** DFS */
    /** Time: O(n^2)
     * Space: O(n) */
    public int findCircleNum(int[][] M) {
        int count = 0;
        boolean[] visited = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == false) {
                dfs(visited, M, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(boolean[] visited, int[][] M, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == false) {
                visited[j] = true;
                dfs(visited, M, j);
            }
        }
    }

    /** BFS */
    /** Time: O(n^2)
     * Space: O(n) */
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == false) {
                q.add(i);
                while (!q.isEmpty()) {
                    int n = q.poll();
                    visited[n] = true;
                    for (int j = 0; j < M.length; j++) {
                        if (M[n][j] == 1 && visited[j] == false) {
                            q.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }

    /** Union find */
    /** Time: O(n^3)
     * Space: O(n) */
    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        int count = 0;
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }

        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                count++;
            }
        }
        return count;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }

    private void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if (xset != yset) {
            parent[xset] = yset;
        }
    }
}
