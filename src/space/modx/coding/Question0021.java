package space.modx.coding;

/*
合并两个有序链表
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Question0021 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode at = head;
        ListNode p1 = l1;
        ListNode p2 = l2;

        while (null != p1 && null != p2) {
            if (p1.val < p2.val) {
                at.next = p1;
                p1 = p1.next;
            } else if (p1.val > p2.val) {
                at.next = p2;
                p2 = p2.next;
            } else {
                at.next = p1;
                p1 = p1.next;
                at = at.next;
                at.next = p2;
                p2 = p2.next;
            }
            at = at.next;
        }
        at.next = (null == p1 ? p2 : p1);

        return head.next;
    }
}
