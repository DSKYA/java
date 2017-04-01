import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static boolean istest(String s1,String s2){
        for(int i = 0; i < s1.length(); i++){
            int j = i;
            int k = 0;
            while(k < s2.length() && s1.charAt(j) != s2.charAt(k))k++;
            if(k >= s2.length())continue;
            int sum = 0;
            while(sum < s1.length()){
                if(s1.charAt(j) == s2.charAt(k)){
                    sum++;
                    j++;
                    k++;
                    j = j % s1.length();
                    k = k % s1.length();
                }
                else break;
            }
            if(sum >= s1.length())return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        n = Integer.parseInt(in.nextLine());
        boolean[] has = new boolean[n];
        String[] test = new String[n];
        //HashSet<String> has = new HashSet<String>();
        for(int i = 0; i < n; i++){
            test[i] = in.nextLine();
            has[i] = true;
        }
        int sum = 0;
        for(int i = 0; i < n; i++){
            if(has[i]) {
                for (int j = i + 1; j < n; j++) {
                    if (has[j] && test[i].length() == test[j].length()) {
                        if (istest(test[i], test[j])) {
                            has[i] = false;
                            has[j] = false;
                        }
                    }
                }
                sum++;
            }
        }
        System.out.print(sum);
    }
}
