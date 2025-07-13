package com.patterns.first.and.slow;

public class FirstAndSlow {

    public static void main(String[] args) {
        FirstAndSlow firstAndSlow = new FirstAndSlow();

        // Middle of LinkedList
        ListNode middleNode = LinkedListUtil.createLinkedList(1, 10);
        // 1 -> 2 -> 3 -> 4-> 5 -> 6 -> 7 -> 8 -> 9 -> 10
        ListNode middleNodeRes = firstAndSlow.middleNode(middleNode);
        System.out.println(middleNodeRes);

        // Remove Nth Node From End of List
        // 1 -> 2 -> 3 -> 4-> 5
        ListNode removeNthFromEnd = LinkedListUtil.createLinkedList(1, 5);
        ListNode removeNthFromEnd1 = firstAndSlow.removeNthFromEnd(removeNthFromEnd, 2);
        System.out.println(removeNthFromEnd1);

        // Detect cycle in LL
        // 1 -> 2 -> 3 -> 4-> 5
        //      |_____________|
         //
        ListNode cycle = LinkedListUtil.createLinkedList(1, 5);
        {
            ListNode curr = cycle;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = cycle.next.next;
            System.out.println(firstAndSlow.hasCycle(cycle));

            // Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
            System.out.println(firstAndSlow.detectCycle(cycle).val);

            // remove the cycle
            firstAndSlow.removeLoop(cycle);
            System.out.println(cycle);
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // only one element in the LL but n = 2
        if (fast == null) {
            return head.next;
        }

        // this makes sure that slow pointer is at the position just before the node that is to be deleted
        // works for both odd and even
        // 1 -> 2 -> 3 -> 4
        // slow pointer will be at 2 if n = 2
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // this will remove the desired node
        slow.next = slow.next.next;
        return head;
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    // Remove loop in Linked List
    public void removeLoop(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                ListNode temp = slow;
                while (temp.next != slow) {
                    temp = temp.next;
                }
                temp.next = null;
            }
        }
    }
}
