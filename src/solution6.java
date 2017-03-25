/**
 * Created by cxj on 17-3-24.
 */
public class solution6 {
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0)return 0;
        else {
            int i = array.length - 1;
            while(i>0 && array[i - 1] <= array[i])i--;
            return array[i];
        }
    }
}

