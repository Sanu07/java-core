package com.linkedlist;

import java.util.List;

public class LinkedListUtil {

    ListNode head;

    // Constructor to initialize an empty linked list
    public LinkedListUtil() {
        this.head = null;
    }

    // Method to add a new node at the end of the list
    public void add(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;  // If the list is empty, set the head to the new node
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;  // Traverse to the last node
            }
            current.next = newNode;  // Add the new node at the end
        }
    }

    public void printList() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static LinkedListUtil createLinkedList(List<Integer> nums) {
        LinkedListUtil linkedListUtil = new LinkedListUtil();
        for (int i = 0; i < nums.size(); i++) {
            linkedListUtil.add(nums.get(i));
        }
        return linkedListUtil;
    }
}
