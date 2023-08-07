package com.anuj.binary.tree;

import java.util.Scanner;

public class Height {

    public static void main(String[] args) {
        Node root = BTImplementation.createTree();
        int height = findHeight(root);
        System.out.println(height);
    }

    private static int findHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }

}
