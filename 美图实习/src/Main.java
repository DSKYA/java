import java.util.*;
/*
class listnode implements Comparable<listnode> {

    private int t1;
    private int t2;

    public listnode(int a, int b) {
        this.t1 = a;
        this.t2 = b;
    }

    public int getT1() {
        return t1;
    }

    public int getT2() {
        return t2;
    }

    public void setT2(int t2) {
        this.t2 = t2;
    }

    public int compareTo(listnode o) {
        // 先按age排序
        if (this.t2 > o.getT2()) {
            return (this.t2 - o.getT2());
        }
        if (this.t2 < o.getT2()) {
            return (this.t2 - o.getT2());
        }

        if(this.t2 == o.getT2()){
            return (this.t1 - o.getT1());
        }
        // 按name排序
        return 0;
    }
}
public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<listnode> list = new ArrayList<listnode>();
        for(int i = 0; i < n; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            list.add(new listnode(a,b));
        }
        Collections.sort(list);
        int[] result = new int[n];
        result[0] = 0;
        int[] dp1 = new int[n];
        dp1[0] = list.get(0).getT1();
        for(int i = 1; i < n; i++){
            listnode tmp = list.get(i);
            if(dp1[i - 1] + tmp.getT1() <= tmp.getT2()){
                result[i] = result[i - 1];
                dp1[i] = dp1[i - 1] + tmp.getT1();
            }
            else {
                result[i] = result[i - 1] + 1;
                dp1[i] = dp1[i - 1];
            }
            for(int j = 0; j < i; j++){
                if(dp1[j] <= tmp.getT2() - tmp.getT1()){
                    if(result[j] + i - j - 1 < result[i]){
                        result[i] = result[j] + i - j - 1;
                        dp1[i] = dp1[j] + tmp.getT1();
                    }
                    else if(result[j] + i - j - 1 == result[i]){
                        dp1[i] = dp1[i] > dp1[j] + tmp.getT1()? dp1[j] + tmp.getT1() : dp1[i];
                    }
                }
            }

        }
        System.out.print(result[n - 1]);
    }
}
*/
public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int r = in.nextInt();
        int[] list = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++){
            list[i] = in.nextInt();
            if(list[i] > max)max = list[i];
        }
        Arrays.sort(list);
        int dp1[] = new int[max + 1];
        int dp2[] = new int[max + 1];
        for(int i = 0; i < m; i++){
            for(int j = 1; j <= max; j++){
                int sum = 0;
                for(int k = 0; k < n ; k++){
                    if(j < list[k]){
                        sum += max - list[k] - r > 0 ? max - list[k] - r : 0;
                    }
                }
                dp1[j] = sum + dp1[j];
            }
        }

    }
}