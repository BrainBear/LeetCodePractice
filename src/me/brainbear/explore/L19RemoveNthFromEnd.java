package me.brainbear.explore;

public class L19RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode h = dummyHead;
        ListNode t = dummyHead;
        while (n + 1 > 0 && null != t) {
            t = t.next;
            n--;
        }

        while (null != t) {
            t = t.next;
            h = h.next;
        }
        h.next = h.next.next;
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
        L19RemoveNthFromEnd removeNthFromEnd = new L19RemoveNthFromEnd();

        ListNode testList = createTestList(new int[]{1, 2, 3, 4, 5});
        printList(testList);
        printList(removeNthFromEnd.removeNthFromEnd(testList, 2));

        testList = createTestList(new int[]{1});
        printList(testList);
        printList(removeNthFromEnd.removeNthFromEnd(testList, 1));


    }
}
