public class d53_662_maximum_width_of_binary_tree {
    /** Time: O(n)
     * Space: O(n) */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);
        q.offer(root);
        int maxWidth = 1;

        while(!q.isEmpty()) {
            int size = q.size();
            int start = 0;
            int end = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == 0) {
                    start = map.get(node);
                }
                if (i == size - 1) {
                    end = map.get(node);
                }
                if (node.left != null) {
                    map.put(node.left, map.get(node) * 2);
                    q.offer(node.left);
                }
                if (node.right != null) {
                    map.put(node.right, map.get(node) * 2 + 1);
                    q.offer(node.right);
                }
            }
            maxWidth = Math.max(maxWidth, (end - start + 1));
        }
        return maxWidth;
    }
}
