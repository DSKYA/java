/**
 * Created by cxj on 17-3-29.
 */
public class Solution_add {
    public int Sum_Solution(int n) {
    int sum = n;
    boolean result = (n > 0) && ((sum += Sum_Solution(n - 1))> 0);
        return sum;

    }
}
