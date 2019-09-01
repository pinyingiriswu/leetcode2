public class d67_861_possible_bipartition {
    /** DFS */
    /** Time: O(n)
     * Space: O(n)
     * */
    public boolean possibleBipartition(int N, int[][] dislikes) {
        // colors[i] = 0 means node i not visited
        // colors[i] = 1 means node i has color 1
        // colors[i] = -1 means node i has color -1
        // for possible bipartition, current node and its adjacent nodes should not have the same color
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] dis: dislikes) {
            graph.get(dis[0]).add(dis[1]);
            graph.get(dis[1]).add(dis[0]);
        }

        int[] colors = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            if (colors[i] == 0 && !dfs(graph, i, colors, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int i, int[] colors, int color) {
        colors[i] = color;
        for (int adj: graph.get(i)) {
            if (colors[adj] == 0 && !dfs(graph, adj, colors, -color)) {
                return false;
            }
            if (colors[adj] == color) {
                return false;
            }
        }
        return true;
    }



    /** BFS */
    /** Time: O(n)
     * Space: O(n)
     * */
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] dis: dislikes) {
            graph.get(dis[0]).add(dis[1]);
            graph.get(dis[1]).add(dis[0]);
        }

        int[] group = new int[N + 1];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i <= N; i++) {
            if (group[i] != 0) continue;
            group[i] = 1;

            q.offer(i);

            while (!q.isEmpty()) {
                int top = q.poll();
                for (int adj: graph.get(top)) {
                    if (group[adj] == 0) {
                        group[adj] = -group[top];
                        q.offer(adj);
                    } else if (group[adj] == group[top]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
