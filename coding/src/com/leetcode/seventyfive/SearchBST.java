package com.leetcode.seventyfive;

import com.tree.Node;
import com.tree.TreeUtil;

public class SearchBST {
    public static void main(String[] args) {
        Node root = TreeUtil.createTree(2);
        // TreeUtil.preOrder(root);
        Node res = findVal(root, 2);
        System.out.println(res);
        TreeUtil.preOrder(res);
    }

    private static Node findVal(Node root, int val) {
        if (root == null) {
            return null;
        }
        if (root.data == val) {
            return root;
        }
        if (root.data < val) {
            return findVal(root.right, val);
        } else {
            return findVal(root.left, val);
        }
    }
}
