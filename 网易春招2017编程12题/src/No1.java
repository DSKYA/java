import java.util.Scanner;


/**
 * Created by cxj on 17-4-16.
 */
public class No1 {
    public static void main(String[] args) {
        int n;
        int kb = 1024;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int[] list =new int[n];
        int min = 0;
        int max = -1;
        for(int i = 0; i < n; i++){
            list[i] = in.nextInt() / kb;
            min += list[i];
            if(list[i] > max)max = list[i];
        }
        int midd = 204800;
        int[] dp1 = new int[409601];
        int[] dp2 = new int[409601];
        boolean[] flg1 = new boolean[409601];
        boolean[] flg2 = new boolean[409601];
        flg1[204800] = true;
        int sum = 0;

        int result = min;
        for (int i = 0; i < n; i++){
            sum += list[i];
            //if(sum > max)sum = max;
            for(int j = 0; j <= sum; j++){
                int tmpa = midd - j;
                int tmpb = midd + j;
                int mmin = min;
                if(flg1[tmpa + list[i]]){
                    int tmp;
                    tmp = dp1[tmpa + list[i]] + list[i];
                    dp2[tmpa] = tmp;
                    flg2[tmpa] = true;
                    mmin = tmp;
                }
                if(tmpa - list[i] >= 0 && flg1[tmpa - list[i]]){
                    int tmp = dp1[tmpa - list[i]];
                    if(tmp < mmin){
                        dp2[tmpa] = tmp;
                        flg2[tmpa] = true;
                    }
                }
                mmin = min;
                if(flg1[tmpb - list[i]]){
                    int tmp;
                    tmp = dp1[tmpb - list[i]];
                    dp2[tmpb] = tmp;
                    flg2[tmpb] = true;
                    mmin = tmp;
                }
                if(tmpb + list[i] <= 409600 && flg1[tmpb + list[i]]){
                    int tmp = dp1[tmpb + list[i]] + list[i];
                    if(tmp < mmin){
                        dp2[tmpb] = tmp;
                        flg2[tmpb] = true;
                    }
                }
                //d
            }
            for(int j = 0; j <= sum ; j++){
                int tmpa = midd - j;
                int tmpb = midd + j;
                dp1[tmpa] = dp2[tmpa];
                dp1[tmpb] = dp2[tmpb];
                flg1[tmpa] = flg2[tmpa];
                flg1[tmpb] = flg2[tmpb];
                dp2[tmpa] = 0;
                dp2[tmpb] = 0;
                flg2[tmpa] = false;
                flg2[tmpb] = false;

                if(i == n -1){
                    if(flg1[tmpa]) {
                        if (dp1[tmpa] < result) result = dp1[tmpa];
                    }
                    if (flg1[tmpb])
                        {
                            if(dp1[tmpb] + tmpb - midd < result)result = dp1[tmpb] + tmpb - midd;
                        }
                }
            }
        }
        System.out.print(result * 1024);
    }
}
