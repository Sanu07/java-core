package com.tree;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class TreeUtil {

    private static final Queue<Integer> QUEUE_1 = new ArrayDeque<>(List.of(1, 2, 4, -1, -1, 5, -1, -1, 3, -1, -1));
    private static final Queue<Integer> QUEUE_2 = new ArrayDeque<>(List.of(4, 2, 1, -1, -1, 3, -1, -1, 7, -1, -1));

    public static Node createTree(int num) {
        Node node = null;
        switch (num) {
            case 1: {
                Queue<Integer> queue = new ArrayDeque<>(QUEUE_1);
                node = createTree1(queue);
                break;
            }
            case 2: {
                Queue<Integer> queue = new ArrayDeque<>(QUEUE_2);
                node = createTree1(queue);
            }
        }
        return node;
    }



    private static Node createTree1(Queue<Integer> queue) {
        int data = queue.poll();
        if (data == -1) {
            return null;
        }
        Node root = new Node(data);
        root.left = createTree1(queue);
        root.right = createTree1(queue);
        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
