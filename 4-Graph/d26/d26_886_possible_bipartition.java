public class d26_886_possible_bipartition {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        // group[i] = 0 means node i not visited
        // group[i] = 1 means node i marked as group 1
        // group[i] = -1 means node i marked as group -1

        int[][] graph = new int[N][N];
        for (int[] d: dislikes) {
            // mark as connected edges
            graph[d[0]-1][d[1]-1] = 1;
            graph[d[1]-1][d[0]-1] = 1;
        }

        int[] group = new int[N];
        for (int i = 0; i < N; i++) {
            if (group[i] == 0 && !dfs(graph, group, i, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] group, int pos, int g) {
        group[pos] = g;
        for (int i = 0; i < graph.length; i++) {
            if (graph[pos][i] == 1) {
                if (group[i] == g) {
                    return false;
                }
                if (group[i] == 0 && !dfs(graph, group, i, -g)) {
                    return false;
                }
            }
        }
        return true;
    }
}
