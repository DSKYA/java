import java.util.Scanner;
import java.util.HashMap;

public class Main {

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static  void getMemIds(String[] memberIds, String[] tradeIds, String[] tradeAmount, String[] cartIds, int amount) {
        HashMap<String,HashMap<String,Integer>> table= new HashMap<String,HashMap<String, Integer>>();
        int tmp;
        for (int i = 0; i < memberIds.length; i++){
            tmp = 0;
            HashMap<String,Integer> t = table.get(memberIds[i]);
            if(table.containsKey(memberIds[i])){

                tmp = t.get(cartIds[i]);
            }
            tmp += Integer.valueOf(tradeAmount[i]);
            t.put(cartIds[i],tmp);
            table.put(memberIds[i],t);
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] memberIds = s.nextLine().split(",");
        String[] tradeIds = s.nextLine().split(",");
        String[] tradeAmount = s.nextLine().split(",");
        String[] cartIds = s.nextLine().split(",");
        int amount = s.nextInt();

        getMemIds(memberIds, tradeIds, tradeAmount, cartIds, amount);
    }
}