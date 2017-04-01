import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] curr = new int[n];
        for (int i = 0; i < n; i++){
            curr[i] = in.nextInt();
        }
        Arrays.sort(curr);
        int sum = 0;
        int result = 0;
        int tmp = curr[0] - 1;
        for(int i = 0; i < n; i++){
            if(curr[i] <= 0){
                sum = 2;
                break;
            }
            if(curr[i] > tmp + 1)result = tmp + 1;
            if(curr[i] - tmp - 1 >= 0) sum += curr[i] - tmp - 1;
            else {
                sum = 2;
                break;
            }
            tmp = curr[i];
        }
        if(sum > 1)System.out.print("mistake");
        else if(sum == 1)System.out.print(result);
        else if(curr[0] != 1){
            System.out.print((curr[0] - 1)+" "+(curr[n - 1] + 1));
        }
        else{
            System.out.print(curr[n - 1] + 1);
        }
    }
}
