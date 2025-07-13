package com.patterns.first.and.slow;

public class LinkedListUtil {

    public static void main(String[] args) {
        ListNode linkedList = createLinkedList(1, 10);
        System.out.println(linkedList);
    }

    public static ListNode createLinkedList(int start, int end) {
        if (start > end) {
            return null;
        }
        ListNode listNode = new ListNode(start);
        listNode.next = createLinkedList(start + 1, end);
        return listNode;
    }
}
