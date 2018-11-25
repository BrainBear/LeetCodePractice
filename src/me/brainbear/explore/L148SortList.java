package me.brainbear.explore;

public class L148SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode fast = head;
        ListNode slow = head;

        while (null != fast && null != fast.next) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        return merge(sortList(head), sortList(slow));
    }


    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);

        ListNode cur = dummyHead;
        ListNode index1 = l1;
        ListNode index2 = l2;


        while (null != index1 && null != index2) {
            if (index1.val > index2.val) {
                cur.next = index2;
                index2 = index2.next;
            } else {
                cur.next = index1;
                index1 = index1.next;
            }
            cur = cur.next;
        }
        if (null != index1) {
            cur.next = index1;
        }
        if (null != index2) {
            cur.next = index2;
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
        L148SortList sortList = new L148SortList();

        ListNode testList = createTestList(new int[]{4, 2, 1, 3});
        printList(testList);
        printList(sortList.sortList(testList));

        testList = createTestList(new int[]{-1, 5, 3, 4, 0});
        printList(testList);
        printList(sortList.sortList(testList));

    }
}
