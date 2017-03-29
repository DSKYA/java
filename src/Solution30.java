/**
 * Created by cxj on 17-3-28.
 */
import java.util.ArrayList;
import java.util.Iterator;
public class Solution30 {
    public static float sum = 0;

    public static ArrayList<Float> get(ArrayList<Float> root){
        if(root.size() <= 1)return root;
        int total = root.size();
        int i = 0;
        Iterator<Float> ir = root.iterator();
        ArrayList<Float> ar1 = new ArrayList<Float>();
        ArrayList<Float> ar2 = new ArrayList<Float>();
        while(ir.hasNext()){
            if(i < total / 2){
                ar1.add(ir.next());
                i++;
            }
            else{
                ar2.add(ir.next());
                i++;
            }
        }
        ar1 = get(ar1);
        ar2 = get(ar2);
        int f1 = ar1.size();
        int f2 = ar2.size();
        int s1 = 0;
        int s2 = 0;
        root.clear();
        while(s1 < f1 && s2 < f2){
            if(ar1.get(s1) <= ar2.get(s2)){
                root.add(ar1.get(s1));
                s1++;
            }
            else{
                sum += f1 - s1;
                sum = sum % 1000000007;
                root.add(ar2.get(s2));
                s2++;
            }
        }
        if(s2 < f2){
            while(s2 < f2){
                root.add(ar2.get(s2));
                s2++;
            }
        }
        if(s1 < f1){
            while(s1 < f1){
                root.add(ar1.get(s1));
                s1++;
            }
        }
        return root;
    }
    public static int InversePairs(int [] array) {
        ArrayList<Float> tmp = new ArrayList<Float>();
        for(int curr: array){
            tmp.add((float)curr);
        }
        get(tmp);
        return (int)sum % 1000000007;
    }

    public static void main(String[] args) {
        int[] s = new int[500000];
        for(int i = 0; i < 1000; i++){
                s[i] = 199999 - i;
        }
        System.out.print(InversePairs(s));
    }
}
