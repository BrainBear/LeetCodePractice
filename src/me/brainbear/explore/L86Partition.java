package me.brainbear.explore;

public class L86Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyBiggerHead = new ListNode(0);
        ListNode dummySmallerHead2 = new ListNode(0);

        ListNode bigCur = dummyBiggerHead;
        ListNode smallCur = dummySmallerHead2;

        ListNode cur = head;
        while (null != cur){
            if(cur.val < x){
                bigCur.next = cur;
                bigCur = cur;
            }else{
                smallCur.next = cur;
                smallCur = cur;
            }
            cur = cur.next;
        }

        bigCur.next = dummySmallerHead2.next;
        smallCur.next = null;

        return dummyBiggerHead.next;
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
        L86Partition partition = new L86Partition();

        ListNode testList = createTestList(new int[]{1, 4, 3, 2, 5, 2});
        printList(testList);
        printList(partition.partition(testList, 3));

        testList = createTestList(new int[]{});
        printList(testList);
        printList(partition.partition(testList, 3));

    }
}
