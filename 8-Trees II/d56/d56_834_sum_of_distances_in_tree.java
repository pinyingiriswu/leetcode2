public class d56_834_sum_of_distances_in_tree {
    /** Time: O(n^2)
     * Space: O(n^2) */

    /** Reference:
     * https://leetcode.com/problems/sum-of-distances-in-tree/discuss/321995/Java-DFS-%2B-Memoization.-Simple-Intuitive-Solution. */
    // for each node, cache the result for each edge. Each index in the array corresponds to one node.
    // each index contains a map where each entry (neighbour) corresponds to its computed result, which is a 2D array ( this 2D array is explained below).
    Map<Integer, int[]>[] cache;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        cache = new HashMap[N];
        int[] distances = new int[N];
        Arrays.fill(distances, 0);

        for(int i = 0; i < N; i++) {
            distances[i] = helper(i, -1, graph)[0];
        }

        return distances;
    }

    private int[] helper(int idx, int parent, List<List<Integer>> graph) {
        int res = 0;
        int numOfNodes = 1;
        for (int neighbor: graph.get(idx)) {
            if (neighbor == parent) {
                continue;
            }
            int[] t;
            if (cache[idx] == null) {
                cache[idx] = new HashMap<>();
            }
            // check if we have already traversed the edge from idx to neighbour
            if (cache[idx].containsKey(neighbor)) {
                t = cache[idx].get(neighbor);
            } else {
                t = helper(neighbor, idx, graph);
                cache[idx].put(neighbor, t);
            }
            numOfNodes += t[1]; // add the number of nodes
            res += (t[0] + t[1]); // add the result of that subtree. For every node, you add 1 to the result of neighbour.
        }

        return new int[] {res, numOfNodes};
    }
}
