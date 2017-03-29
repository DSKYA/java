/**
 * Created by cxj on 17-3-28.
 */
public class Solution29 {
    public static int FirstNotRepeatingChar(String str) {
        int sum = str.length();
        int i;
        int[] bucket = new int[100];
        int j = sum - 1;
        for(i = 0; i < sum; i++){
            while((j > i && str.charAt(j) != str.charAt(i) && bucket[(int)((str.charAt(i) - 'A'))] < 2 )){
                bucket[(int)(str.charAt(j) - 'A')]++;
                j--;
            }
            if(str.charAt(j) == str.charAt(i) && j >= i){
                bucket[(int)(str.charAt(j) - 'A')]++;
                j--;
            }
            if(bucket[(int)(str.charAt(i) - 'A')] == 1 && i > j)return i;
            bucket[(int)(str.charAt(i) - 'A')]++;

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.print(FirstNotRepeatingChar("NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp"));
    }
}
