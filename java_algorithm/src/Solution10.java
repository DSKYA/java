/**
 * Created by cxj on 17-4-1.
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
public class Solution10 {
    LinkedList<Integer> list1 = new LinkedList();
    LinkedList<Integer> list2 = new LinkedList();

    public void Insert(Integer num) {
        if(list1.isEmpty())list1.addLast(num);
        else if(list2.isEmpty()){
            if(num > list1.peekFirst()) list2.addLast(num);
            else{
                list2.addLast(list1.pollFirst());
                list1.addLast(num);
            }
        }
        else {
            if(num <= list1.peekLast()){
                list1.addFirst(num);
                Collections.sort(list1);
            }
            else{
                list2.addFirst(num);
                Collections.sort(list2);
            }
            while(Math.abs(list1.size() - list2.size()) > 1){
                if(list1.size() > list2.size()){
                    list2.addFirst(list1.pollLast());
                }
                else{
                    list1.addLast(list2.pollFirst());
                }
            }
        }
    }

    public Double GetMedian() {
            if((list1.size() + list2.size()) % 2 == 0){
                return ((double)list1.peekLast() + (double)list2.peekFirst()) / 2;
            }
            else{
                if(list1.size() > list2.size())return (double)list1.peekLast();
                else return (double)list2.peekFirst();
            }
    }


}