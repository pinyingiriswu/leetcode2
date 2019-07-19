public class d25_802_find_eventual_safe_states {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        //use colors to denote states of the nodes
        // 0: white (not visited)
        // 1: gray (visiting)
        // 2: black (visited and reached end)
        // for DFS approach, in order to find out nodes with eventual safe states,
        // there must not be cycles, i.e. the nodes can't be in gray states

        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, 0);
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(graph, colors, i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean dfs(int[][] graph, int[] colors, int pos) {
        if (colors[pos] > 0) return colors[pos] == 2;
        colors[pos] = 1;
        for (int node: graph[pos]) {
            if (colors[node] == 2) continue;
            if (colors[node] == 1 || !dfs(graph, colors, node)) {
                return false;
            }
        }
        colors[pos] = 2;
        return true;
    }
}
