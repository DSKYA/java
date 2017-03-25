/**
 * Created by cxj on 17-3-24.
 */
public class solution7 {
    public int Fibonacci(int n) {
        int i =1;
        int last = 0;
        int sum = 1;
        for ( i = 2; i <= n; i++){
            int tmp = sum;
            sum = sum + last;
            last = tmp;
        }
        if(n == 0)return 0;
        if(n == 1)return 1;
        else return sum;
    }
}
