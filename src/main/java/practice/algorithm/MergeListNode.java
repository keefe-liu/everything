package practice.algorithm;

/**
 * Created by tingfang.liu on 2016/4/14.
 */
public class MergeListNode {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l5;
        l5.next = l6;
        l2.next = l3;
        l3.next = l4;
        ListNode ln = mergeByRecursive(l1, l2);
        printNode(ln);
    }

    public static void printNode(ListNode listNode) {
        if (listNode != null) {
            System.out.print(listNode.val);
            printNode(listNode.next);
        }
    }

    public static ListNode mergeByRecursive(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode result;
        if (list1.val <= list2.val) {
            result = list1;
            result.next = mergeByRecursive(list1.next, list2);
        } else {
            result = list2;
            result.next = mergeByRecursive(list1, list2.next);
        }
        return result;
    }

    public ListNode mergeByLoop(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = null;
        ListNode tmp = null;
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        tmp = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tmp.next = list1;
                list1 = list1.next;
                tmp = tmp.next;
            } else {
                tmp.next = list2;
                list2 = list2.next;
                tmp = tmp.next;
            }
        }
        if (list1 == null) {
            tmp.next = list2;
        }
        if (list2 == null) {
            tmp.next = list1;
        }
        return head;
    }
}
