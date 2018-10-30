package me.brainbear.explore;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L92ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        List<ListNode> list = new ArrayList<>();
        Stack<ListNode> stack = new Stack<>();

        ListNode cur = head;
        for (int i = 1; i < m; i++) {
            list.add(cur);
            cur = cur.next;
        }

        for (int i = 0; i < n - m + 1; i++) {
            stack.push(cur);
            cur = cur.next;
        }

        ListNode tail = cur;

        ListNode dummyHead = new ListNode(0);
        ListNode nCur = dummyHead;

        for (ListNode node : list) {
            nCur.next = node;
            nCur = nCur.next;
        }

        while (!stack.isEmpty()) {
            nCur.next = stack.pop();
            nCur = nCur.next;
        }

        nCur.next = tail;

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
        L92ReverseBetween reverseBetween = new L92ReverseBetween();

        ListNode testList = createTestList(new int[]{1, 2, 3, 4, 5});
        printList(testList);
        printList(reverseBetween.reverseBetween(testList, 2, 4));
    }
}
