/**
 * Created by cxj on 17-3-25.
 */
public class solution10 {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode nextNode = head.next;
        head.next = null;
        ListNode reverseRest = ReverseList(nextNode);
        nextNode.next = head;
        return reverseRest;
    }
}
