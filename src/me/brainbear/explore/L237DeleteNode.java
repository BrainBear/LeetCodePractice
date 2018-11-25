package me.brainbear.explore;

public class L237DeleteNode {

    public void deleteNode(ListNode node) {

        ListNode next = node.next;

        node.val = next.val;
        node.next = next.next;
        next.next = null;
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
        L237DeleteNode deleteNode = new L237DeleteNode();

        ListNode testList = createTestList(new int[]{4, 5, 1, 9});
        printList(testList);
        deleteNode.deleteNode(testList);
        printList(testList);


    }
}
