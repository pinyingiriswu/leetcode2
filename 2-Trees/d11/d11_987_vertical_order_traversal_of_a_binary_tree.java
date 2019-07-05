public class d11_987_vertical_order_traversal_of_a_binary_tree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Location implements Comparable<Location> {
        int x, y, val;
        public Location(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Location loc) {
            if (this.x != loc.x) {
                return this.x - loc.x;
            }
            if (this.y != loc.y) {
                return loc.y - this.y;
            }
            else {
                return this.val - loc.val;
            }
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        List<Location> loc = new ArrayList<>();
        dfs(loc, 0, 0, root);
        Collections.sort(loc);

        int prev = loc.get(0).x;
        res.add(new ArrayList<Integer>());
        for (Location location: loc) {
            if (location.x == prev) {
                res.get(res.size()-1).add(location.val);
            } else {
                prev = location.x;
                res.add(new ArrayList<Integer>());
                res.get(res.size()-1).add(location.val);
            }
        }
        return res;
    }

    public void dfs(List<Location> loc, int x, int y, TreeNode root) {
        loc.add(new Location(x, y, root.val));
        if (root.left != null) {
            dfs(loc, x-1, y-1, root.left);
        }
        if (root.right != null) {
            dfs(loc, x+1, y-1, root.right);
        }
    }
}
