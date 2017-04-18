import java.util.HashSet;
import java.util.Scanner;

public class No1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashSet<Integer> list= new HashSet<Integer>();
        for(int i = 0; i < n; i++){
            int tmp = in.nextInt();
            if(!list.contains(tmp))list.add(tmp);
        }
        int m = in.nextInt();
        boolean f1 = false;
        int last = 0;
        for(int i = 0; i < m; i++){
            int tmp = in.nextInt();
            if(list.contains(tmp)){
                if(f1 == true){
                    System.out.print(last + " ");
                }
                last = tmp;
                f1 = true;
            }
        }
        System.out.print(last);
        //System.out.println("Hello World!");
    }
}
