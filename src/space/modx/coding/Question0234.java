package space.modx.coding;

/*
回文链表
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Question0234 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x ) { val = x; }
    }
    public boolean isPalindrome(ListNode head) {
        if (null == head || null == head.next) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode at = head, pre = null;

        while (null != fast && null != fast.next) {
            at = slow;
            slow = slow.next;
            fast = fast.next.next;
            at.next = pre;
            pre = at;
        }
        if (null != fast) {
            slow = slow.next;
        }

        while (null != at && null != slow) {
            if (at.val != slow.val) {
                return false;
            }
            at = at.next;
            slow = slow.next;
        }
        return true;
    }
}
