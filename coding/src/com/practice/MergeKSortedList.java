package com.practice;

import com.linkedlist.LinkedListUtil;
import com.linkedlist.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedList {

    public static void main(String[] args) {
        MergeKSortedList mergeKSortedList = new MergeKSortedList();

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];
        lists[0] = listNode1;
        lists[1] = listNode2;
        lists[2] = listNode3;

        ListNode curr = mergeKSortedList.mergeKLists(lists);
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println();
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.add(node.next);
            }
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }
}