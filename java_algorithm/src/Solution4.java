import java.util.ArrayList;

/**
 * Created by cxj on 17-3-29.
 */
public class Solution4 {
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int st = 0, fin = array.length - 1;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (st < fin) {
            if (array[st] + array[fin] == sum) {
                result.add(array[st]);
                result.add(array[fin]);
                if (array[st + 1] - array[st] < array[fin] - array[fin - 1]) st++;
                else fin--;
                break;
            } else if (array[st] + array[fin] < sum) {
                st++;
            } else {
                fin--;
            }
        }
        return result;
    }
}
