package me.brainbear.explore;

public class L328OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);

        ListNode oddPoint = oddHead;
        ListNode evenPoint = evenHead;

        ListNode cur = head;
        while (null != cur) {
            oddPoint.next = cur;
            oddPoint = oddPoint.next;

            cur = cur.next;

            if (null != cur) {
                evenPoint.next = cur;
                evenPoint = evenPoint.next;
                cur = cur.next;
            }
        }

        oddPoint.next = evenHead.next;
        evenPoint.next = null;
        return oddHead.next;
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
        L328OddEvenList oddEvenList = new L328OddEvenList();

        ListNode testList = createTestList(new int[]{1, 2, 3, 4, 5});
        printList(testList);
        printList(oddEvenList.oddEvenList(testList));


        testList = createTestList(new int[]{2, 1, 3, 5, 6, 4, 7});
        printList(testList);
        printList(oddEvenList.oddEvenList(testList));

        testList = createTestList(new int[]{2, 1, 3, 5, 6, 4, 7, 8});
        printList(testList);
        printList(oddEvenList.oddEvenList(testList));

        testList = createTestList(new int[]{1});
        printList(testList);
        printList(oddEvenList.oddEvenList(testList));

        testList = createTestList(new int[]{});
        printList(testList);
        printList(oddEvenList.oddEvenList(testList));

    }
}
