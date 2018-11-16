package me.brainbear.explore;

public class L21MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);

        ListNode cur = dummyHead;

        while (null != l1 && null != l2) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }

        if (null != l1) {
            cur.next = l1;
        } else if (null != l2) {
            cur.next = l2;
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
        L21MergeTwoLists mergeTwoLists = new L21MergeTwoLists();

        ListNode testList = createTestList(new int[]{1, 2, 4});
        ListNode testList1 = createTestList(new int[]{1, 3, 4});
        printList(testList);
        printList(testList1);
        printList(mergeTwoLists.mergeTwoLists(testList, testList1));


        testList = createTestList(new int[]{1, 2, 4});
        testList1 = createTestList(new int[]{});
        printList(testList);
        printList(testList1);
        printList(mergeTwoLists.mergeTwoLists(testList, testList1));

    }
}
