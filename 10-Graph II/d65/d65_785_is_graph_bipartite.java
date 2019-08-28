public class d65_785_is_graph_bipartite {
    /** Time: O(V+E)
     * Space: O(V+E)
     * */
    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        int[] colors = new int[m];
        Arrays.fill(colors, -1); // -1 means all nodes not colored yet
        for (int i = 0; i < m; i++) {
            // if not colored, we give the uncolored node a color (1 in this case)
            // and then color its children nodes 0.
            // If there's a conflict during the coloring process, return false
            if (colors[i] == -1 && !dfs(colors, graph, 1, i)) {
                return false;
            }
        }
        return true;
    }

    // there are two colors: 0, 1
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
}
