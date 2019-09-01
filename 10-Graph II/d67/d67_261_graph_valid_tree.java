public class d67_261_graph_valid_tree {
    /** DFS */
    /** Time: O(n)
     * Space: O(n)
     * */
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int[] e: edges) {
            if (!graph.containsKey(e[0])) graph.put(e[0], new HashSet<>());
            if (!graph.containsKey(e[1])) graph.put(e[1], new HashSet<>());
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];

        // make sure there are no cycles in the graph
        if (!dfs(graph, 0, visited)) return false;

        // make sure if the nodes are all connected and visited
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Map<Integer, Set<Integer>> graph, int index, boolean[] visited) {
        if (visited[index]) {
            return false;
        }
        visited[index] = true;

        // check the neighbors
        if (graph.containsKey(index)) {
            for (int adj: graph.get(index)) {
                graph.get(adj).remove(index);
                if (!dfs(graph, adj, visited)) return false;
            }
        }
        return true;
    }


    /** Union Find */
    /** Time: O(n)
     * Space: O(n)
     * */
    public boolean validTree(int n, int[][] edges) {
        // for n nodes, there should be n-1 edges
        // if there are more than n-1 edges, there must be a cycle, thus can't form a tree
        if (n - 1 != edges.length) return false;
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int[] e: edges) {
            int p1 = find(parents, e[0]);
            int p2 = find(parents, e[1]);
            // union
            if (p1 == p2) {
                return false;
            } else {
                parents[p2] = p1;
            }
        }
        return true;
    }

    private int find(int[] parents, int index) {
        if (parents[index] == index) {
            return index;
        }
        return find(parents, parents[index]);
    }
}
