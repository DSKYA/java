/**
 * Created by cxj on 17-3-29.
 */
public class Solution_chuquan {
    public static int LastRemaining_Solution(int n, int m) {
        if(n == 0)return -1;
        if(n == 1)return 0;
        int i = 2;
        int getout;
        int winner = 1;
        int next;
        while(i <= n){
            getout = m % i;
            if(getout == 0)getout = i;
            next = (getout + 1) % i;
            if(next == 0)next = i;
            winner = (winner + next - 1) % i;
            if(winner == 0)winner = i;
            i++;
        }
        return  winner - 1;
    }
}
