package space.modx.coding;

/*
删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Question0019 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 先算出总长度，然后正向遍历删除第size-n+1 (下标: size-n)各节点
    public ListNode removeNthFromEnd_1(ListNode head, int n) {
        ListNode p = head;
        int size = 0;
        while (null != p) {
            size++;
            p = p.next;
        }

        int target = size - n;
        if (target == 0) {
            head = head.next;
        } else {
            p = head;
            int i = 0;
            while (i != target-1) {
                p = p.next;
                i++;
            }
            p.next = p.next.next;
        }

        return head;
    }

    // 使用两个指针，第一个先向前移动n+1，第二个才从头开始，两者相距n
    // 然后同时移动两者直到第一个到达null（末尾下一个），删除第二个指针的下一个节点即可
    public ListNode removeNthFromEnd_2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;

        for (int i = 1; i <= n+1; i++) {
            p1 = p1.next;
        }

        while (null != p1) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return dummy.next;
    }
}
