import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class No1 {
    public static List<String> list = new ArrayList<String>();
    public static String a;
    public static String b;

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    public static void match(String str, String nstr) {
        LinkedList<String> tmp = new LinkedList<String>();
        tmp.addLast(new String("2"));
        tmp.addLast(new String("3"));
        tmp.addLast(new String("4"));
        tmp.addLast(new String("5"));
        int aa = (int)(a.charAt(0) - '0');
        int bb = (int)(b.charAt(0) - '0');
        while(!tmp.isEmpty()){
            String t = tmp.pollFirst();
            // System.out.println(t);
            if(t.length() == 6){
                list.add(t);
            }
            else{
                int[] p = new int[6];
                for(int i = 0; i < t.length(); i++){
                    char c = t.charAt(i);
                    p[(int)(c - '0')]++;
                }
                for(int i = 1; i < 6; i++){
                    if(p[i] == 0 || i == 5 && p[i] < 2){
                        if(i == aa){
                            if((int)(t.charAt(t.length() - 1) - '0') == bb){
                                continue;
                            }
                        }
                        if(i == bb){
                            if((int)(t.charAt(t.length() - 1) - '0') == aa){
                                continue;
                            }
                        }
                        if(i == 1 && t.length() < 4)continue;
                        tmp.addLast(new String(t + String.valueOf((char)(i + '0'))));
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        a = s.next();
        b = s.next();
        match("", "123455");
        System.out.println(list.size());
    }
}