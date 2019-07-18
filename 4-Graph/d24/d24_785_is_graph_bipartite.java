public class d24_785_is_graph_bipartite {

    /** DFS */
    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        int[] colors = new int[m];
        Arrays.fill(colors, -1);

        for (int i = 0; i < m; i++) {
            if (colors[i] == -1 && !dfs(colors, graph, 1, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[] colors, int[][] graph, int color, int pos) {
        if (colors[pos] != -1) {
            return colors[pos] == color;
        }

        colors[pos] = color;
        for (int node: graph[pos]) {
            if (!dfs(colors, graph, 1-color, node)) {
                return false;
            }
        }
        return true;
    }

    /** BFS */
    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        int[] colors = new int[m];
        Arrays.fill(colors, 0); // color = 0 means not colored yet
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            if (colors[i] != 0) continue;
            q.add(i);
            colors[i] = 1;
            while (!q.isEmpty()) {
                int t = q.poll();
                for (int node: graph[t]) {
                    if (colors[node] == colors[t]) return false;
                    if (colors[node] == 0) {
                        colors[node] = -1 * colors[t];
                        q.add(node);
                    }
                }
            }
        }
        return true;
    }
}
