package me.brainbear.explore;

public class L24SwapPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        ListNode cur = dummyHead.next;

        while (true) {

            if (null == cur || null == cur.next) {
                break;
            }

            ListNode next = cur.next;
            ListNode temp = cur.next.next;

            prev.next = next;
            next.next = cur;
            cur.next = temp;

            prev = cur;
            cur = cur.next;
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
        L24SwapPairs swapPairs = new L24SwapPairs();

        ListNode testList = createTestList(new int[]{1, 2, 3, 4});
        printList(testList);
        printList(swapPairs.swapPairs(testList));


    }
}
