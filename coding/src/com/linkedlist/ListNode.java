package com.linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    // Constructor to initialize a node
    public ListNode(int value) {
        this.val = value;
        this.next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
