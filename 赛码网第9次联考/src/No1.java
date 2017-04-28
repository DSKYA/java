import java.util.Scanner;

public class No1 {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        Scanner in = new Scanner(System.in);
        String tmp = in.nextLine();
        if(tmp.length() != 16)System.out.print("error");
        else{
            int sum = 0;
            for(int i = 0; i < 16; i++){
                int k = 0;
                if(i % 2 == 0){
                    k = (int)(tmp.charAt(i) - '0') * 2;
                    if(k >= 10)k -= 9;
                }
                else{
                    k = (int)(tmp.charAt(i) - '0');
                }
                sum += k;
            }
            if(sum % 10 == 0)System.out.print("ok");
            else System.out.print("error");
        }
    }
}
