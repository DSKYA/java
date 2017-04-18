import java.util.HashSet;
import java.util.Scanner;

public class No3 {
    static StringBuilder[] t = new StringBuilder[5];

    public static void getone(char c) {
        switch (c){
            case ' ':
                for (int i = 0; i < 5; i++)t[i].append(" ");
                break;
            case '1':
                for (int i = 0; i < 5; i++)t[i].append("*");
                break;
            case '2':
                t[0].append("***");
                t[1].append("  *");
                t[2].append("***");
                t[3].append("*  ");
                t[4].append("***");
                break;
            case '3':
                t[0].append("***");
                t[1].append("  *");
                t[2].append("***");
                t[3].append("  *");
                t[4].append("***");
                break;
            case '4':
                t[0].append("* *");
                t[1].append("* *");
                t[2].append("***");
                t[3].append("  *");
                t[4].append("  *");
                break;
            case '5':
                t[0].append("***");
                t[1].append("*  ");
                t[2].append("***");
                t[3].append("  *");
                t[4].append("***");
                break;
            case '6':
                t[0].append("***");
                t[1].append("*  ");
                t[2].append("***");
                t[3].append("* *");
                t[4].append("***");
                break;
            case '7':
                t[0].append("***");
                t[1].append("  *");
                t[2].append("  *");
                t[3].append("  *");
                t[4].append("  *");
                break;
            case '8':
                t[0].append("***");
                t[1].append("* *");
                t[2].append("***");
                t[3].append("* *");
                t[4].append("***");
                break;
            case '9':
                t[0].append("***");
                t[1].append("* *");
                t[2].append("***");
                t[3].append("  *");
                t[4].append("***");
                break;
            case '0':
                t[0].append("***");
                t[1].append("* *");
                t[2].append("* *");
                t[3].append("* *");
                t[4].append("***");
                break;
            case '+':
                t[0].append(" * ");
                t[1].append("***");
                t[2].append(" * ");
                t[3].append("   ");
                t[4].append("   ");
                break;
            case '-':
                t[0].append("   ");
                t[1].append("***");
                t[2].append("   ");
                t[3].append("   ");
                t[4].append("   ");
                break;
            case '*':
                t[0].append("* *");
                t[1].append(" * ");
                t[2].append("* *");
                t[3].append("   ");
                t[4].append("   ");
                break;
            case '/':
                t[0].append("  *");
                t[1].append(" * ");
                t[2].append("*  ");
                t[3].append("   ");
                t[4].append("   ");
                break;
            case '=':
                t[0].append("****");
                t[1].append("    ");
                t[2].append("****");
                t[3].append("    ");
                t[4].append("    ");
                break;
            case '.':
                t[0].append("   ");
                t[1].append("   ");
                t[2].append("   ");
                t[3].append(" **");
                t[4].append(" **");
                break;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        for (int i = 0; i < 5; i++)t[i] = new StringBuilder("");
        for(int i = 0; i < s.length(); i++){
            getone(s.charAt(i));
        }
        String[] rr = s.split(" ");
        int n = rr.length;
        boolean fg = true;
        double sum = 0;
        String last = "";
        sum = Double.valueOf(rr[0]);
        for(int i = 1; i < n; i++){
            if(fg){
                last = rr[i];
                fg = false;
                }
            else{
                double tmp = Double.valueOf(rr[i]);
                if(last.equals("+")){
                    sum += tmp;
                }
                if(last.equals("-")){
                    sum -= tmp;
                }
                if(last.equals("*")){
                    sum *= tmp;
                }
                if(last.equals("/")){
                    sum /= tmp;
                }
                fg = true;
            }
        }
        java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00");
        String add ="=" + df.format(sum);
        int k = add.length() - 1;
        while(add.charAt(k) == '0')k--;
        if(add.charAt(k) == '.')k--;
        for(int i = 0; i <= k; i++){
            getone(' ');
            getone(' ');
            getone(add.charAt(i));
        }
        for (int i = 0; i < 5; i++) System.out.println(t[i].toString());
        //System.out.println("Hello World!");
    }
}
