/**
 * Created by cxj on 17-3-27.
 */
public class Solution24 {
    public int NumberOf1Between1AndN_Solution(int n) {
    	if(n == 0 )return 0;
    	int x = 1;
    	int high,low,curr,tmp,i = 1;
    	high = n;
    	int total = 0;
    	while(high != 0){
            high = n/(int)Math.pow(10, i);
            tmp = n%(int)Math.pow(10, i);
            curr = tmp/(int)Math.pow(10, i-1);// 获取第i位
            low = tmp%(int)Math.pow(10, i-1);
            if(curr == x){
                total += high * (int)Math.pow(10,i - 1) + low + 1;
            }
            else if(curr < x){
                total += high * (int)Math.pow(10,i - 1);
            }
            else{
                total += (high + 1) * (int)Math.pow(10,i - 1);
            }
            i++;
        }
        return total;
    }
}
