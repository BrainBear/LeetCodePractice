package me.brainbear.explore;

import java.util.Stack;

public class L25ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode cur = head;
        ListNode prev = dummyHead;

        Stack<ListNode> stack = new Stack<>();
        while (true) {
            int i = 0;
            ListNode temp = null;
            for (; i < k && null != cur; i++) {
                System.out.println("push:" + cur.val);
                stack.push(cur);
                cur = cur.next;
            }

            if (stack.size() != k) {
                break;
            }

            temp = cur;
            while (!stack.isEmpty()) {
                prev.next = stack.pop();
                System.out.println("pop:" + prev.next.val);
                prev = prev.next;
            }

            prev.next = temp;
        }

        return dummyHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode createTestList(int[] nums) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 0; i < nums.length; i++) {
            ListNode listNode = new ListNode(nums[i]);
            cur.next = listNode;
            cur = listNode;
        }
        return head.next;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        L25ReverseKGroup reverseKGroup = new L25ReverseKGroup();

        ListNode testList = createTestList(new int[]{1, 2, 3, 4, 5});
        printList(testList);
        printList(reverseKGroup.reverseKGroup(testList, 2));

        testList = createTestList(new int[]{1, 2, 3, 4, 5});
        printList(testList);
        printList(reverseKGroup.reverseKGroup(testList, 3));


        testList = createTestList(new int[]{1, 2});
        printList(testList);
        printList(reverseKGroup.reverseKGroup(testList, 2));

    }
}
