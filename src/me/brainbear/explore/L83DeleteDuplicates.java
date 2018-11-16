package me.brainbear.explore;

public class L83DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if(null == head){
            return null;
        }

        ListNode cur = head;
        ListNode next = cur.next;

        while (next != null) {
            while (next != null && next.val == cur.val) {
                next = next.next;
            }

            cur.next = next;
            cur = next;
        }

        return head;
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
        L83DeleteDuplicates deleteDuplicates = new L83DeleteDuplicates();

        ListNode testList = createTestList(new int[]{1, 1, 2});
        printList(testList);
        printList(deleteDuplicates.deleteDuplicates(testList));

        testList = createTestList(new int[]{1, 1, 2, 2, 3, 3});
        printList(testList);
        printList(deleteDuplicates.deleteDuplicates(testList));
    }
}
