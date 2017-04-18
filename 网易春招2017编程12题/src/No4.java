import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by cxj on 17-4-17.
 */
public class No4 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashSet<Integer> list = new HashSet<Integer>();
        int[] a = new int[n];
        int[] b = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        for(int i = n - 1; i >= 0; i--){

            if(!list.contains(a[i])){
                b[total] = a[i];
                total++;
                list.add(a[i]);
            }
        }
        total--;
        for(int i = total; i >= 0; i--){
            if(i != 0)System.out.print(b[i] + " ");
            else System.out.print(b[i]);
        }
    }
}
