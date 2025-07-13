package com.linkedlist;

import java.util.Arrays;

public class LinkedListProblems {

    public static void main(String[] args) {
        ListNode list1 = LinkedListUtil.createLinkedList(Arrays.asList(1, 2, 4)).head;
        ListNode list2 = LinkedListUtil.createLinkedList(Arrays.asList(1, 3, 4)).head;
        ListNode listNode = mergeTwoLists(list1, list2);
        System.out.println(listNode);

        ListNode list3 = LinkedListUtil.createLinkedList(Arrays.asList(1, 2, 3, 4, 5, 6, 7)).head;
        reorderList(list3);
        System.out.println(list3);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        // ListNode curr = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        } else {
            curr.next = l2;
        }
        return dummy.next;
    }

    public static void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // here slow points to the middle element;
        ListNode prev = null;
        ListNode mid = slow;
        ListNode curr = mid.next;
        mid.next = null;
        // reversing the linked list from mid
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        ListNode left = head;
        ListNode right = prev;
        ListNode nextl, nextr;

        while (left != null && right != null) {
            nextl = left.next;
            nextr = right.next;
            left.next = right;
            right.next = nextl;

            left = nextl;
            right = nextr;
        }
    }

    public void reorderList2(ListNode head) {

        if(head == null){
            return;
        }

        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null, curr = slow, temp;

        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode first = head, second = prev;

        while (second.next != null){
            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }


    }
}
