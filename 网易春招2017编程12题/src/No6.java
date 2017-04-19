import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by cxj on 17-4-19.
 */

class node{
    boolean[] b;
    int step;
    int now;
    public node(int step,boolean c[],int now){
        b = c;
        this.step = step;
        this.now = now;
    }
}

public class No6 {
    static int n;
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        n = Integer.valueOf(in.nextLine());
        String[] list = new String[n];
        for(int i = 0; i < n; i++){
            list[i] = in.nextLine();
        }
        LinkedList<node> r = new LinkedList<node>();
        for(int i = 0; i < n ; i++){
            if(list[i].contains("0")){
                boolean p[] = new boolean[n];
                p[i] = true;
                r.addLast(new node(1,p,1));
            }
        }
        int sum = 0;
        while(!r.isEmpty()){
            node t = r.pollFirst();
            int k = t.step;
            boolean a[] = t.b;
            int now = t.now;
            if(now == 6 || now == n)sum++;
            else if(k < 6){
                for (int i = 0; i < n; i++){
                    if(!a[i] && list[i].contains(String.valueOf((char) (k + '0')))){
                        boolean p[] = a.clone();
                        p[i] = true;
                        r.addLast(new node(k + 1,p,now + 1));
                    }
                }
                r.addLast(new node(k + 1,a,now));
            }
        }
        System.out.print(sum);
    }
}
