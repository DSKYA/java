/**
 * Created by cxj on 17-3-27.
 */
import java.util.Arrays;

public class Solution21 {
    public int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);
        int i = 0;
        if (array.length == 0)return 0;
        int sum = 0;
        int lastone = array[0] - 1;
        for (int tmp:array) {
            if(tmp != lastone){
                sum = 1;
                lastone = tmp;
            }
            else{
                sum++;
                if(sum > array.length/2)return tmp;
            }
        }
        return 0;
    }
}
