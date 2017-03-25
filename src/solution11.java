/**
 * Created by cxj on 17-3-25.
 */
public class solution11 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode next1 = list1,next2 = null,tmp = null;
        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                if(tmp == null){
                    next1 = list2;
                    list2 = list2.next;
                    next1.next = list1;
                    tmp = next1;
                }
                else{
                    tmp.next = list2;
                    list2 = list2.next;
                    tmp = tmp.next;
                    tmp.next = list1;
                }
            }
            else{
                tmp = list1;
                list1 = list1.next;
            }
        }
        if(tmp != null){
            if(list2 == null)tmp.next = list1;
            else tmp.next = list2;
        }
        else{
            if(list1 == null)next1 = list2;
        }
        return next1;
    }
}
