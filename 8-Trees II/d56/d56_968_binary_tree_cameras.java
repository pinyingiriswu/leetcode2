public class d56_968_binary_tree_cameras {
    /** Time: O(n)
     * Space: O(n) */
    int cams;
    public int minCameraCover(TreeNode root) {
        cams = 0;
        int r = setupCameras(root);
        if (r == -1) cams++;

        return cams;
    }

    private int setupCameras(TreeNode root) {
        if (root == null) {
            return -2; //no node here, ignore
        }
        if (root.left == null && root.right == null) {
            return -1; //this is leaf
        }

        int l = setupCameras(root.left);
        int r = setupCameras(root.right);

        if (l == -1 || r == -1) {
            root.val = 1; // being covered
            cams++;
            return 1; // set up camera for parent, parent being covered
        } else if (l == 1 || r == 1) {
            root.val = 1; // being covered
            return 0; // did not set up camera for parent, but parent being covered
        }
        return -1; // not being covered
    }
}
