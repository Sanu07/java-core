package com.practice;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Tree1 {
    public static void main(String[] args) {
        // Create a hard coded tree.
        //         20
        //       /   \
        //      8     22
        //    /  \     \
        //   4   12    11
        //      /  \
        //     10   14
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.right.right = new Node(11);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        ArrayList<Integer> ans = zigZagTraversal(root);
        System.out.println(ans);
    }

    static ArrayList<Integer> zigZagTraversal(Node root) {

        // base case
        if (root == null)
            return new ArrayList<>();

        Deque<Node> dq = new LinkedList<>();
        dq.addFirst(root);

        ArrayList<Integer> ans = new ArrayList<>();
        boolean leftToRight = true;

        while (!dq.isEmpty()) {
            int size = dq.size();

            // Traverse in level order
            while (size-- > 0) {
                Node curr;

                // If direction is from left
                // to right, pop from front
                if (leftToRight) {
                    curr = dq.pollFirst();
                }

                // else pop from back
                else {
                    curr = dq.pollLast();
                }

                // Push current node to result
                ans.add(curr.data);

                // If direction is from left to
                // right, push the left node and
                // right node into the back of dq.
                if (leftToRight) {
                    if (curr.left != null)
                        dq.addLast(curr.left);
                    if (curr.right != null)
                        dq.addLast(curr.right);
                }

                // else push the right node and left
                // node into the front of the dq.
                else {
                    if (curr.right != null)
                        dq.addFirst(curr.right);
                    if (curr.left != null)
                        dq.addFirst(curr.left);
                }
            }

            // Flip the direction
            leftToRight = !leftToRight;
        }

        return ans;
    }

    private static class Node {
        int data;
        Node left, right;

        Node(int x) {
            data = x;
            left = null;
            right = null;
        }
    }
}
