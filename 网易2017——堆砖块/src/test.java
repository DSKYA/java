import java.util.Scanner;

/**
 * Created by cxj on 17-4-15.
 */


public class test {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] list = new int[n];
        int[] r1 = new int [1000001];
        int[] r2 = new int [1000001];
        boolean[] flg1 = new boolean[1000001];
        boolean[] flg2 = new boolean[1000001];
        for(int i = 0; i < n; i++){
            list[i] = in.nextInt();
        }
        int sum = 0;
        int max = -1;
        r1[500000] = 0;
        r2[500000] = 0;
        flg1[500000] = true;
        for(int i = 0; i < n; i++){
            sum += list[i];
            if(sum >= 500000)sum = 500000;
            for(int j = 0; j <= sum; j++){
                    int tmpa = 500000 - j;
                    int tmpb = 500000 + j;
                    r2[tmpa] = r1[tmpa];
                    r2[tmpb] = r1[tmpb];
                    flg2[tmpa] = flg1[tmpa];
                    flg2[tmpb] = flg2[tmpb];
                    if(tmpa - list[i] >= 0 && flg1[tmpa - list[i]] && r2[tmpa] < r1[tmpa - list[i]]){
                        flg2[tmpa] = true;
                        r2[tmpa] = r1[tmpa - list[i]];
                    }
                    if(flg1[tmpa + list[i]] && r2[tmpa] < r1[tmpa + list[i]] + list[i]){
                        flg2[tmpa] = true;
                        r2[tmpa] = r1[tmpa + list[i]] + list[i];
                    }
                    if(tmpb + list[i] <= 1000000 && flg1[tmpb + list[i]] && r2[tmpb] < r1[tmpb + list[i]] + list[i]){
                        flg2[tmpb] = true;
                        r2[tmpb] = r1[tmpb + list[i]] + list[i];
                    }
                    if(flg1[tmpb - list[i]] && r2[tmpb] < r1[tmpb - list[i]]){
                        flg2[tmpb] = true;
                        r2[tmpb] = r1[tmpb - list[i]];
                    }
                    if(tmpa == 500000 && r2[tmpa] > max)max = r2[tmpa];
            }
            for (int j = 0; j <= sum; j++){
                int tmpa = 500000 - j;
                int tmpb = 500000 + j;
                r1[tmpa] = r2[tmpa];
                r1[tmpb] = r2[tmpb];
                flg1[tmpa] = flg2[tmpa];
                flg1[tmpb] = flg2[tmpb];
            }
        }
        if(max <= 0)System.out.print(-1);
        else System.out.print(max);
    }
}
