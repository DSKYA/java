import java.util.Scanner;

/**
 * Created by cxj on 17-4-19.
 */
public class No5_test {
    static int n;
    static int d[][];
    public static int[][] get(int k){
        int b[][] = new int[n][n];
        if(k == 2){
            for(int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    int sum = 0;
                    for(int p = 0; p < n; p++)sum += d[i][p] * d[p][j];
                    b[i][j] = (sum % 100);
                }
            }
        }
        else if(k == 3){
            int c[][] = new int[n][n];
            for(int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    int sum = 0;
                    for(int p = 0; p < n; p++)sum += d[i][p] * d[p][j];
                    c[i][j] = (sum % 100);
                }
            }
            for(int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    int sum = 0;
                    for(int p = 0; p < n; p++)sum += c[i][p] * d[p][j];
                    b[i][j] = (sum % 100);
                }
            }
        }
        else{
            if(k % 2 == 0){
                int c[][] = get(k / 2);
                for(int i = 0; i < n; i++){
                    for (int j = 0; j < n; j++){
                        int sum = 0;
                        for(int p = 0; p < n; p++)sum += c[i][p] * c[p][j];
                        b[i][j] = (sum % 100);
                    }
                }
            }
            else{
                b = get(k / 2);
                int c[][] = new int[n][n];
                for(int i = 0; i < n; i++){
                    for (int j = 0; j < n; j++){
                        int sum = 0;
                        for(int p = 0; p < n; p++)sum += b[i][p] * b[p][j];
                        c[i][j] = (sum % 100);
                    }
                }
                for(int i = 0; i < n; i++){
                    for (int j = 0; j < n; j++){
                        int sum = 0;
                        for(int p = 0; p < n; p++)sum += c[i][p] * d[p][j];
                        b[i][j] = (sum % 100);
                    }
                }
            }
        }
        return b;
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int k = in.nextInt();
        d = new int[n][n];
        int a[] = new int[n];

        for (int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        for(int i =  0; i < n; i++){
            d[i][i] = 1;
            d[i][(i + n - 1)%n] = 1;
        }
        int last[][] = get(k);
        int result[] = new int[n];
        for(int i = 0; i < n; i++){
                int sum = 0;
                for(int p = 0; p < n; p++)sum += a[p] * last[p][i];
                result[i] = (sum % 100);
        }
        for(int i = 0; i < n; i++){
            if(i != n - 1)System.out.print(result[i] + " ");
            else System.out.print(result[i]);
        }
    }
}
