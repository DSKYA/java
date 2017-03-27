/**
 * Created by cxj on 17-3-27.
 */
import java.util.*;
import java.util.Comparator;
public class Solution27 {
    public static String PrintMinNumber(int [] numbers) {
        final ArrayList<Integer> tmp = new ArrayList<Integer>();
        final StringBuilder result = new StringBuilder();
        int[] total = new int[numbers.length];
        for (int a:numbers) {
            tmp.add(a);
        }

        Collections.sort(tmp,new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {

                        String s1 = String.valueOf(o1) + String.valueOf(o2);
                        String s2 = String.valueOf(o2) + String.valueOf(o1);
                        return s1.compareTo(s2);
                    }
            });

        Iterator<Integer> ir = tmp.iterator();
        while(ir.hasNext()){
            result.append(ir.next());
        }
        return result.toString();
    }

    public static void main(String[] args){
        System.out.println(PrintMinNumber(new int[]{3,32,321}));
    }
}
