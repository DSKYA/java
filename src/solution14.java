/**
 * Created by cxj on 17-3-26.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class solution14 {
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        ArrayList<Integer> list1= new ArrayList<Integer>(),list2= new ArrayList<Integer>();
        for (int i = 0; i < pushA.length; i++) list1.add(pushA[i]);
        Iterator ira = list1.iterator();
        for (int i = 0; i < pushA.length; i++) list2.add(popA[i]);
        Iterator irb = list2.iterator();
        Stack<Integer> stack= new Stack<Integer>();
        while(irb.hasNext()){
            int tmpb = (Integer)irb.next();
            if(stack.empty() || stack.peek() != tmpb && ira.hasNext()){
                while(ira.hasNext()){
                    int tmpa = (Integer) ira.next();
                    if(tmpa == tmpb)break;
                    else stack.push(tmpa);
                }
            }
            else if(stack.peek() != tmpb && !ira.hasNext()){
                return false;
            }
            else{
                stack.pop();
            }
        }
        if(!stack.empty())return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(IsPopOrder(new int[]{1, 2, 3, 4, 5},new int[]{4,5,3,2,1}));
        System.out.println("solution1");
    }
}
