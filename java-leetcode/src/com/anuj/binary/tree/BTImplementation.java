package com.anuj.binary.tree;

import java.util.Scanner;

/**
 *
 *          1
 *      2      3
 *   4
 *
 */



public class BTImplementation {


    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final Node node = createTree();
        System.out.println(node);
    }

    public static Node createTree() {

        System.out.println("Data : ");
        final int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        Node root = new Node(data);

        System.out.println("LEFT of " + data);
        root.left = createTree();

        System.out.println("RIGHT of " + data);
        root.right = createTree();

        return root;
    }
}
