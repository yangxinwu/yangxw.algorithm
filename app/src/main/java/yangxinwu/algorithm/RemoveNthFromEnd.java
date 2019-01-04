package yangxinwu.algorithm;

/**
 *
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

 示例：

 给定一个链表: 1->2->3->4->5, 和 n = 2.

 当删除了倒数第二个节点后，链表变为 1->2->3->5.


 */

public class RemoveNthFromEnd {
    public AddTwoNumbers.ListNode removeNthFromEnd(AddTwoNumbers.ListNode head, int n) {
        AddTwoNumbers.ListNode dummy = new AddTwoNumbers.ListNode(0);
        dummy.next = head;
        int length  = 0;
        AddTwoNumbers.ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
}
