/**
 * Created by cxj on 17-3-27.
 */
public class Solution23 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int sum = 0;
        int max = -1;
        for(int i = 0; i < array.length; i++){
            if(sum + array[i] < 0){
                sum = 0;
            }
            else{
                sum += array[i];
                max = max < sum?sum:max;
            }
        }
        return max;
    }
}
