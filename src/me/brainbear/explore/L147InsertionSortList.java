package me.brainbear.explore;

public class L147InsertionSortList {

    public ListNode insertionSortList(ListNode head) {

        ListNode dummyHead = new ListNode(0);

        ListNode cur = head;

        while (null != cur) {
            ListNode next = cur.next;

            insert(dummyHead, cur);
            cur = next;
        }

        return dummyHead.next;
    }

    private void insert(ListNode dummyHead, ListNode node) {
        ListNode cur = dummyHead;

        while (cur.next != null && cur.next.val < node.val) {
            cur = cur.next;
        }

        node.next = cur.next;
        cur.next = node;
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
        L147InsertionSortList insertionSortList = new L147InsertionSortList();

        ListNode testList = createTestList(new int[]{4, 2, 1, 3});
        printList(testList);
        printList(insertionSortList.insertionSortList(testList));

        testList = createTestList(new int[]{-1, 5, 3, 4, 0});
        printList(testList);
        printList(insertionSortList.insertionSortList(testList));

        testList = createTestList(new int[]{});
        printList(testList);
        printList(insertionSortList.insertionSortList(testList));

    }
}
