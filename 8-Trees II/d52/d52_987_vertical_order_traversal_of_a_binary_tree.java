public class d52_987_vertical_order_traversal_of_a_binary_tree {
    /** Time: O(n)
     * Space: O(n) */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // TreeMap sort keys in ascending order
        Map<Integer, Queue<int[]>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        List<List<Integer>> res = new ArrayList<>();
        for (int k: map.keySet()) {
            List<Integer> temp = new ArrayList<>();
            while(!map.get(k).isEmpty()) {
                temp.add(map.get(k).poll()[1]);
            }
            res.add(temp);
        }
        return res;
    }

    private void dfs(TreeNode root, int x, int y, Map<Integer, Queue<int[]>> map) {
        if (root == null) return;
        // map.computeIfAbsent provides associated value for new key
        // pq sorts in ascending order by y; if y are the same, sort by root.val
        map.computeIfAbsent(x, k -> new PriorityQueue<>((t1, t2) -> t1[0] == t2[0]? t1[1] - t2[1] : t1[0] - t2[0])).offer(new int[] {y, root.val});

        dfs(root.left, x - 1, y + 1, map);
        dfs(root.right, x + 1, y + 1, map);
    }
}
