/**
 * Created by cxj on 17-3-27.
 */
import java.util.TreeSet;
import java.util.ArrayList;
public class Solution22 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeSet<Integer> tree = new TreeSet<Integer>();
        for (int tmp:input) {
            tree.add(tmp);
        }
        int i = 0;
        for (int tmp:tree) {
            result.add(tmp);
            i++;
            if(i >= k)break;
        }
        return result;
    }
}
