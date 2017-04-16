import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by cxj on 17-4-16.
 */


public class No2 {

    public static void main(String args[]){
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int[] xx = new int[n];
        int[] yy = new int[n];
        for(int i = 0; i < n; i++){
            xx[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++){
            yy[i] = in.nextInt();
        }
        int dex,dey;
        dex = in.nextInt();
        dey = in.nextInt();
        int sta = in.nextInt();
        int stb = in.nextInt();
        int min = Math.abs(dex) + Math.abs(dey);
        min = min * sta;
        for(int i = 0; i < n; i++){
            int tmpa = Math.abs(xx[i]) + Math.abs(yy[i]);
            int tmpb = Math.abs(xx[i] - dex) + Math.abs(yy[i] - dey);
            min = min < tmpa * sta + tmpb * stb ? min : tmpa * sta + tmpb * stb;
        }
        System.out.print(min);
    }
}
