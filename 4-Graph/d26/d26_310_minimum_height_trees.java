public class d26_310_minimum_height_trees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<Integer> leaves = new ArrayList<>();
        List<Set<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) leaves.add(i);
        }

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int l: leaves) {
                int t = graph.get(l).iterator().next();
                graph.get(t).remove(l);
                if (graph.get(t).size() == 1) newLeaves.add(t);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
