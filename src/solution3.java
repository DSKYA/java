import java.util.ArrayList;

/**
 * Created by cxj on 17-3-24.
 */
public class solution3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode current) {
        int[] stack = new int[5000];
        int top = 0;
        ArrayList<Integer> a = new ArrayList<Integer>();
        while(current != null && current.next != null){
            stack[top] = current.val;
            current = current.next;
            top++;
        }
        if(top > 0){
            stack[top] = current.val;
            for(; top >=0; top--){
                a.add(stack[top]);
            }
        }
        else{
            a.clear();
        }
        return a;
    }
}
