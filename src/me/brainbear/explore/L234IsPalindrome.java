package me.brainbear.explore;

public class L234IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (null == head || null == head.next) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        while (null != fast && null != fast.next) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        ListNode reverse = reverse(slow);

        boolean result = true;
        while (null != head && null != reverse) {
            if (head.val != reverse.val) {
                result = false;
                break;
            }
            head = head.next;
            reverse = reverse.next;
        }

        return result;
    }

    private ListNode reverse(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;

        while (null != cur) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
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
        int i = 0;
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
            i++;

            if (i > 100) {
                return;
            }
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        L234IsPalindrome isPalindrome = new L234IsPalindrome();

        ListNode testList = createTestList(new int[]{1, 2});

        printList(testList);
        System.out.println(isPalindrome.isPalindrome(testList));

        testList = createTestList(new int[]{1, 2, 2, 1});

        printList(testList);
        System.out.println(isPalindrome.isPalindrome(testList));


    }
}
