package me.brainbear.explore;

public class L61RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (null == head || null == head.next) {
            return head;
        }

        int len = -1;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        ListNode q = dummyHead;

        while (k > 0) {
            len++;
            q = q.next;
            k--;

            if (q == null) {
                q = dummyHead.next;
                k = k % len;
            }
        }

        while (null != q.next) {
            q = q.next;
            p = p.next;
        }

        if (p == dummyHead) {
            return dummyHead.next;
        }

        q.next = dummyHead.next;
        dummyHead.next = p.next;
        p.next = null;

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
        L61RotateRight rotateRight = new L61RotateRight();

        ListNode testList = createTestList(new int[]{1, 2, 3, 4, 5});
        printList(testList);
        printList(rotateRight.rotateRight(testList, 2));

        testList = createTestList(new int[]{0, 1, 2});
        printList(testList);
        printList(rotateRight.rotateRight(testList, 4));

        testList = createTestList(new int[]{1, 2});
        printList(testList);
        printList(rotateRight.rotateRight(testList, 2));
    }
}
