package me.brainbear.explore;

public class L82DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode cur = dummyHead;

        while (null != cur.next) {

            int val = cur.next.val;

            if (null != cur.next.next && val == cur.next.next.val) {
                ListNode temp = cur.next.next.next;
                while (null != temp && temp.val == val) {
                    temp = temp.next;
                }
                cur.next = temp;
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
        L82DeleteDuplicates deleteDuplicates = new L82DeleteDuplicates();

        ListNode testList = createTestList(new int[]{1, 1, 2});
        printList(testList);
        printList(deleteDuplicates.deleteDuplicates(testList));

        testList = createTestList(new int[]{1, 1, 2, 2, 3, 3});
        printList(testList);
        printList(deleteDuplicates.deleteDuplicates(testList));
    }
}
