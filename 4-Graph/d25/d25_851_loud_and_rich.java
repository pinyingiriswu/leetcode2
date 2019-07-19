public class d25_851_loud_and_rich {

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[] res = new int[n];
        boolean[] visited = new boolean[n];
        List<Integer>[] map = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            res[i] = i;
        }

        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i <richer.length; i++) {
            map[richer[i][1]].add(richer[i][0]);
        }

        for (int i = 0; i < n; i++) {
            dfs(map, visited, res, quiet, i);
        }

        return res;
    }

    private int dfs(List<Integer>[] map, boolean[] visited, int[] res, int[] quiet, int i) {
        if (visited[i]) return res[i];
        for (int node: map[i]) {
            int temp = dfs(map, visited, res, quiet, node);
            if (quiet[temp] < quiet[res[i]]) {
                res[i] = temp;
            }
        }
        visited[i] = true;
        return res[i];
    }
}
