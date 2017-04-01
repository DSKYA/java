import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = 0;
        boolean tflg = false;
        n = in.nextLong();
        int m = (int) Math.floor(Math.log((double)n)/Math.log((double)2));

        for (int i = m; i > 1; i--){
           // long tmp = (long)(Math.log((double)n)/Math.log((double)i));
            long tmp = (long)Math.pow((double)n,1.0/(double)i);
            long tt = 1;
            for(int j = 0; j < i; j++){
                tt *= tmp;
            }
            if(tt == n){
                boolean flg = true;
                for (long j = 2; j <= Math.sqrt((double)tmp); j++){
                    if(tmp % j == 0){
                        flg = false;
                        break;
                    }
                }
                if(flg){
                    System.out.print(tmp + " " + i);
                    tflg = true;
                    break;
                }
            }
        }
        if(!tflg)System.out.print("No");
    }
}
