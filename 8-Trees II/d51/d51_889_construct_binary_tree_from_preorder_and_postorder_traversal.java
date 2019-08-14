public class d51_889_construct_binary_tree_from_preorder_and_postorder_traversal {
    /** Time: O(n^2) --> need to traverse pre[] for each node again to find rightNodeIdx
     * Space: O(n) */
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || post == null || pre.length != post.length) return null;
        int preLen = pre.length;
        int postLen = post.length;
        return helper(pre, 0, preLen - 1, post, 0, postLen - 1);
    }

    private TreeNode helper(int[] pre, int preStart, int preEnd, int[] post, int poStart, int poEnd) {
        if (preStart > preEnd || poStart > poEnd) return null;
        int rootVal = post[poEnd];
        TreeNode root = new TreeNode(rootVal);
        if (poStart == poEnd) return root;
        int rightNodeVal = post[poEnd - 1];
        int rightNodeIdx = preEnd;
        while (rightNodeIdx >= 0) {
            if (pre[rightNodeIdx] == rightNodeVal) {
                break;
            }
            rightNodeIdx--;
        }

        root.left = helper(pre, preStart + 1, rightNodeIdx - 1, post, poStart, poStart + (rightNodeIdx - 2 - preStart));
        root.right = helper(pre, rightNodeIdx, preEnd, post, poStart + (rightNodeIdx - 1 - preStart), poEnd - 1);
        return root;
    }
}
