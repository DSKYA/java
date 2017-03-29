import java.util.ArrayList;
public class Solution3 {
    public  static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        sum = sum * 2;
        int top = (int)Math.sqrt(sum);
        while(top > 1){
            if(sum % top == 0){
                int tmp = sum / top;
                if(tmp + 1 - top > 0 && (tmp + 1 - top) % 2 == 0)
                {
                    int i = (tmp + 1 - top) / 2;
                    ArrayList<Integer> curr = new ArrayList<Integer>();
                    for (int j = i; j < i + top; j++){
                        curr.add(j);
                    }
                    result.add(curr);
                }
            }
            top--;
        }
        return result;
    }
    public static void main(String []args){
        System.out.print(FindContinuousSequence(100));
    }
}
