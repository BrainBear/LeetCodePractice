package me.brainbear.explore;

public class L2AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        ListNode current = null;
        ListNode head = null;
        while (!(l1 == null && l2 == null && !carry)) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            int temp = val1 + val2 + (carry ? 1 : 0);
            ListNode listNode = new ListNode(temp % 10);

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            carry = temp >= 10;
            if(current == null){
                current = listNode;
                head = listNode;
            }else{
                current.next = listNode;
                current = listNode;
            }
        }
        return head;
    }

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        return addTwoNumbers(l1, l2, false);
//    }
//
//    private ListNode addTwoNumbers(ListNode l1, ListNode l2, boolean carry) {
//        if(l1 == null && l2 == null && !carry){
//            return null;
//        }
//
//        int val1 = l1 == null ? 0 : l1.val;
//        int val2 = l2 == null ? 0 : l2.val;
//
//        int temp = val1 + val2 + (carry ? 1 : 0);
//
//        ListNode listNode = new ListNode(temp % 10);
//
//        listNode.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next, temp >= 10);
//
//        return listNode;
//    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        L2AddTwoNumbers addTwoNumbers = new L2AddTwoNumbers();

        ListNode l1;
        ListNode l2;
        ListNode listNode;

        l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);


        l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        listNode = addTwoNumbers.addTwoNumbers(l1, l2);

        printListNode(listNode);

        listNode = addTwoNumbers.addTwoNumbers(null, l2);
        printListNode(listNode);

        listNode = addTwoNumbers.addTwoNumbers(l1, null);
        printListNode(listNode);


        l1 = new ListNode(5);
        l2 = new ListNode(5);

        listNode = addTwoNumbers.addTwoNumbers(l1, l2);
        printListNode(listNode);


        l1 = new ListNode(1);
        l1.next = new ListNode(8);
        l2 = new ListNode(5);

        listNode = addTwoNumbers.addTwoNumbers(l1, l2);
        printListNode(listNode);

        l1 = new ListNode(1);
        l2 = new ListNode(9);
        l2.next = new ListNode(9);

        listNode = addTwoNumbers.addTwoNumbers(l1, l2);
        printListNode(listNode);
    }


    private static void printListNode(ListNode listNode) {
        while (null != listNode) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
        System.out.println();
    }
}
