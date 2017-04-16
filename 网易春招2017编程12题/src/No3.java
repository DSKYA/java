import java.util.Scanner;

/**
 * Created by cxj on 17-4-16.
 */
public class No3 {
    public static void main(String args[]){
        String list;
        Scanner in = new Scanner(System.in);
        list = in.nextLine();
        int last1 = 0;
        int last2 = 0;
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i < list.length(); i++){
            if(list.charAt(i) == 'G'){
                sum1 += last1;
            }
            else last1++;
            if(list.charAt(list.length() - 1 - i) == 'G'){
                sum2 += last2;
            }
            else last2++;
            //System.out.print(sum2 + " ");
        }
        System.out.print(sum1 < sum2 ? sum1 : sum2);
    }
}
