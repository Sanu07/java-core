package com.companies.atlassian;

class InsertInBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // Base case: insert here
        if (root == null) return new TreeNode(val);

        // Recurse left or right
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else { // val > root.val
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
