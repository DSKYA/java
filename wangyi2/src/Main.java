import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int sum = 0;
        for (int i = 0; i < s1.length(); i++){
            switch (s1.charAt(i)){
                case 'A':
                    if(s2.charAt(i) != 'T')sum++;
                    break;
                case 'T':
                    if(s2.charAt(i) != 'A')sum++;
                    break;
                case 'C':
                    if(s2.charAt(i) != 'G')sum++;
                    break;
                case 'G':
                    if(s2.charAt(i) != 'C')sum++;
                    break;
            }
        }
        System.out.print(sum);
    }
}
