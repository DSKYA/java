import java.util.ArrayList;

/**
 * Created by cxj on 17-4-1.
 */
public class Solution11 {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(size > num.length || size == 0)return result;
        int i = 0;
        int sum = 0;
        int tmp = 0;
        sum = 1;
        tmp = num[i];
        if(size == 1)result.add(tmp);
        for(i = 1; i < num.length; i++){
            if(num[i] == tmp){
                sum = 1;
            }
            else if(num[i] < tmp){
                sum++;
            }
            else{
                tmp = num[i];
                sum = 1;
            }

            if(sum > size) {
                int j = i - size + 1;
                tmp = num[j];
                sum = 1;
                j++;
                for(;j <= i; j++){
                    if(num[j] == tmp){
                        sum = 1;
                    }
                    else if(num[j] < tmp){
                        sum++;
                    }
                    else{
                        tmp = num[j];
                        sum = 1;
                    }
                }
            }
            if(i >= size - 1){
                result.add(tmp);
            }
        }
        return result;
    }
}
