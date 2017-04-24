import java.util.Scanner;

public class Main {

    public static int func (){
        try{
            return 1;
        }catch (Exception e){
            return 2;
        }finally{
            return 3;
        }
    }


    public static void main(String[] args) {
        /*
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int sum = 0;
        n = n << 1;
        boolean flg = false;
        for(int l = m; l <= 100; l++){
            if(n % l == 0){
                int tmp = n / l;
                tmp = tmp + 1 -l;
                if(tmp % 2 == 0){
                    tmp = tmp >> 1;
                    for(int i = tmp; i < tmp + l; i++){
                        System.out.print(i);
                        if(i < tmp + l - 1)System.out.print(" ");
                        sum += i;
                    }
                    flg = true;
                    break;
                }
            }
        }
        */
      // if(!flg)System.out.print("No");
        System.out.print(func());
        //System.out.println();
       // System.out.print(sum);
    }
}
