package me.brainbear.explore;

public class L203RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode cur = dummyHead;

        while (null != cur.next) {

            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
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
        L203RemoveElements removeElements = new L203RemoveElements();

        ListNode testList = createTestList(new int[]{1, 2, 6, 3, 4, 5, 6});
        printList(removeElements.removeElements(testList, 6));

        testList = createTestList(new int[]{6, 6, 6});
        printList(removeElements.removeElements(testList, 6));

    }
}
