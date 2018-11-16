package me.brainbear.explore;

import java.util.Stack;

public class L445AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();

        while (null != l1) {
            s1.push(l1);
            l1 = l1.next;
        }
        while (null != l2) {
            s2.push(l2);
            l2 = l2.next;
        }

        ListNode prev = null;
        int carry = 0;
        while (true) {
            int val1 = 0;
            if (!s1.isEmpty()) {
                val1 = s1.pop().val;
            }

            int val2 = 0;
            if (!s2.isEmpty()) {
                val2 = s2.pop().val;
            }

            int temp = carry + val1 + val2;
            ListNode listNode = new ListNode(temp % 10);

            carry = temp >= 10 ? 1 : 0;
            listNode.next = prev;

            prev = listNode;

            if (s1.isEmpty() && s2.isEmpty() && carry == 0) {
                break;
            }
        }
        return prev;
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
        L445AddTwoNumbers addTwoNumbers = new L445AddTwoNumbers();

        ListNode testList = createTestList(new int[]{7, 2, 4, 3});
        ListNode testList1 = createTestList(new int[]{5, 6, 4});
        printList(addTwoNumbers.addTwoNumbers(testList, testList1));

    }
}
