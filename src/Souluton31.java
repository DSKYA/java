/**
 * Created by cxj on 17-3-28.
 */
public class Souluton31 {
    public static int l1,l2;
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    int i = 0;
    ListNode p = pHead1;
    while(p != null){
        i++;
        p = p.next;
    }
    l1 = i;
    i = 0;
    p = pHead2;
    while(p != null){
        i++;
        p = p.next;
    }
    l2 = i;
    while(l2 > l1){
        pHead2 = pHead2.next;
        l2 --;
    }
    while(l1 > l2){
        pHead1 = pHead1.next;
        l1--;
    }
    while (pHead1 != pHead2){
        pHead1 = pHead1.next;
        pHead2 = pHead2.next;
    }
    return pHead1;
    }
}
