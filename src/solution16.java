/**
 * Created by cxj on 17-3-26.
 */
public class solution16 {
    public static boolean istree(int a,int b,int [] s){
        if(b <= a)return true;
        int i = 0,tmp = s[b];
        int tmpa;
        while(s[i] < tmp && i < b)i++;
        tmpa = i;
        while(s[i] > tmp && i < b)i++;
        if(i < b)return false;
        else {
            return istree(0,tmpa - 1,s) & istree(tmpa,b - 1,s);
        }
    }
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence.length == 0)return false;
        if(istree(0,sequence.length - 1,sequence))return true;
        else return false;
    }
    public static void main(String[] args) {
        System.out.println(VerifySquenceOfBST(new int[]{7,4,6,5}));
        System.out.println("solution1");
    }
}
