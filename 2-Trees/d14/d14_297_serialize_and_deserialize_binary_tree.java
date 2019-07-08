public class d14_297_serialize_and_deserialize_binary_tree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        public String serialHelper(TreeNode root, String s) {
            if (root == null) {
                s += "null,";
            } else {
                s += s.valueOf(root.val) + ",";
                s = serialHelper(root.left, s);
                s = serialHelper(root.right, s);
            }

            return s;
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return serialHelper(root, "");
        }

        public TreeNode dserialHelper(List<String> list) {
            if (list.get(0).equals("null")) {
                list.remove(0);
                return null;
            }

            TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
            list.remove(0);
            root.left = dserialHelper(list);
            root.right = dserialHelper(list);

            return root;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] str_array = data.split(",");
            List<String> list = new LinkedList<String>(Arrays.asList(str_array));
            return dserialHelper(list);
        }

    }
}
