public class d66_1135_connecting_cities_with_minimum_cost {
    /** Time: O(ElogE) --> sorting
     * Space: O(N)
     * */
    public int minimumCost(int N, int[][] connections) {
        // Kruskal's MST algo + Union-Find
        // 1. Sort th edges in increasing order
        // 2. Pick the smallest edge that does not form a cycle (UF is for detecting cycle)
        // 3. Repeat until every node is connected
        // After MST is completed, there should be N - 1 edges with N nodes (no cycle should be in MST)

        if (connections == null || connections.length == 0 || connections[0].length == 0) return -1;

        Arrays.sort(connections, (c1, c2) -> c1[2] - c2[2]);
        int cost = 0;
        int[] parents = new int[N + 1];
        int edges = 0;

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for (int[] connect: connections) {
            int p1 = findParent(parents, connect[0]);
            int p2 = findParent(parents, connect[1]);
            if (p1 != p2) {
                parents[p2] = p1;
                cost += connect[2];
                edges++;
                if (edges == N - 1) return cost;
            }
        }
        return -1;
    }

    private int findParent(int[] parents, int i) {
        if (parents[i] == i) {
            return i;
        }
        return findParent(parents, parents[i]);
    }
}
