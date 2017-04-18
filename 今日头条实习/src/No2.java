import java.util.HashSet;
import java.util.Scanner;

public class No2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long tmp = in.nextLong();
        HashSet<Long> list = new HashSet<Long>();
        while(tmp != 0){
            if(!list.contains(tmp))list.add(tmp);
            tmp = in.nextLong();
        }
        System.out.print(list.size());
        //System.out.println("Hello World!");
    }
}
