import java.util.ArrayList;

/**
 * Created by cxj on 17-3-27.
 */
public class Solution28 {
    public int GetUglyNumber_Solution(int index) {

        if(index <= 0)return 0;
        int i2 = 0,i3 = 0,i5 = 0;
        ArrayList<Long> tree = new ArrayList<Long>();
        tree.add((long) 1);
        while(index > 0){
            long tmp2 = tree.get(i2);
            long tmp3 = tree.get(i3);
            long tmp5 = tree.get(i5);
            long min = tmp2 * 2 < (tmp3 * 3 < tmp5 * 5?tmp3 * 3:tmp5 * 5)?tmp2 * 2:(tmp3 * 3< tmp5 * 5?tmp3 * 3:tmp5 * 5);
            if(index == 1){
                return (int)min;
            }
            else{
                tree.add(min);
                if(min == tmp2 * 2)tmp2++;
                if(min == tmp3 * 3)tmp3++;
                if(min == tmp5 * 5)tmp5++;
            }
            index--;
        }
        return 0;
    }
}
