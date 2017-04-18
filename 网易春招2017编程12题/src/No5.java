import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by cxj on 17-4-17.
 */
public class No5 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int sum = 0;
        int min = 100;
        HashSet<String> list = new HashSet<String>();
        int r1 = 0;
        StringBuilder ls = new StringBuilder();
        int tmp[] = new int[n];
        int origin[] = new int[n];
        int last[] = new int[n];

        for (int i = 0; i < n; i++){
            tmp[i] = in.nextInt();
            sum += tmp[i];
            if(tmp[i] < min) min = tmp[i];
            last[i] = tmp[i];
            origin[i] = tmp[i];
        }
        int g[] = new int[101];
        int tsum = sum;
        int b2 = 0;
        for(int i = 1; i <= 100; i++){
            tsum = (tsum << 1) % 100;
            if(g[tsum] == 0)g[tsum] = i;
            else {
                b2 = i;
                break;
            }
        }
        int b1 = g[tsum];
        b2 = b2 - b1;
        System.out.println("b1 " + b1 + " b2 " + b2);

        for (int a:tmp) {
            ls.append(a - min);
        }
        list.add(ls.toString());
        do{
            min = 100;
            for(int i = 0; i < n; i++){
                tmp[i] = (last[i] + last[(i + 1) % n]) % 100;
                if(tmp[i] < min)min = tmp[i];
            }
            for (int i = 0; i < n; i++)last[i] = tmp[i];
            ls.delete(0,ls.length());
            for (int a:tmp) {
                ls.append(a - min);
            }
            r1++;
            if(list.contains(ls.toString()))break;
            else list.add(ls.toString());
        }while(true);
        System.out.println("r1 " + r1);
        int r2 = 0;
        list.clear();
        list.add(ls.toString());
        do{
            min = 100;
            for(int i = 0; i < n; i++){
                tmp[i] = (last[i] + last[(i + 1) % n]) % 100;
                if(tmp[i] < min)min = tmp[i];
            }
            for (int i = 0; i < n; i++)last[i] = tmp[i];
            ls.delete(0,ls.length());
            for (int a:tmp) {
                ls.append(a - min);
            }
            r2++;
            if(list.contains(ls.toString()))break;
            else list.add(ls.toString());
        }while(true);
        System.out.println("r2 " + r2);
        for(int i = 0; i < n ;i++){
            tmp[i] = origin[i];
            last[i] = origin[i];
        }
        if(k <= r1){
            for(int j = 0; j < k; j++){
                min = 100;
                for(int i = 0; i < n; i++){
                    tmp[i] = (last[i] + last[(i + 1) % n]) % 100;
                    if(tmp[i] < min)min = tmp[i];
                }
                for (int i = 0; i < n; i++)last[i] = tmp[i];
            }
        }
        else{
            for(int j = 0; j < r1; j++){
                min = 100;
                for(int i = 0; i < n; i++){
                    tmp[i] = (last[i] + last[(i + 1) % n]) % 100;
                    if(tmp[i] < min)min = tmp[i];
                }
                for (int i = 0; i < n; i++)last[i] = tmp[i];
            }
            int a = (k - r1) % r2;
            for(int j = 0; j < a; j++){
                min = 100;
                for(int i = 0; i < n; i++){
                    tmp[i] = (last[i] + last[(i + 1) % n]) % 100;
                    if(tmp[i] < min)min = tmp[i];
                }
                for (int i = 0; i < n; i++)last[i] = tmp[i];
            }
        }
        int c;
        if(k <= 2){
            c = (1)<<k;
        }
        else {
            c = 4 << ((k - b1) % b2);
        }
        //sum = (c % 100) * sum;
        sum = c * sum;
        for(int i = 0; i < n; i++){
            sum -= tmp[i];
        }
        sum = sum / n;
        for(int i = 0; i < n; i++){
            if(i != n -1)System.out.print((sum + tmp[i]) % 100 + " ");
            else System.out.print((sum + tmp[i]) % 100);
        }
    }
}
