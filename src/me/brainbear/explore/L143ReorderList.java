package me.brainbear.explore;

public class L143ReorderList {

    public void reorderList(ListNode head) {
        if (null == head || null == head.next) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = head;
        while (null != fast && null != fast.next) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        ListNode reverse = reverse(slow);

        ListNode cur = head;
        head = head.next;
        while (null != head && null != reverse) {
            cur.next = reverse;
            reverse = reverse.next;
            cur = cur.next;

            cur.next = head;
            head = head.next;
            cur = cur.next;
        }

        if (null != head) {
            cur.next = head;
        }
        if (null != reverse) {
            cur.next = reverse;
        }
    }


    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;

        while (null != cur) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
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
        int i = 0;
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
            i++;

            if (i > 100) {
                return;
            }
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        L143ReorderList reorderList = new L143ReorderList();

        ListNode testList = createTestList(new int[]{1, 2, 3, 4, 5});

        printList(testList);
        reorderList.reorderList(testList);
        printList(testList);

        testList = createTestList(new int[]{1, 2});

        printList(testList);
        reorderList.reorderList(testList);
        printList(testList);

        testList = createTestList(new int[]{1});

        printList(testList);
        reorderList.reorderList(testList);
        printList(testList);

        testList = createTestList(new int[]{});

        printList(testList);
        reorderList.reorderList(testList);
        printList(testList);

    }
}
