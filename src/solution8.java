/**
 * Created by cxj on 17-3-24.
 */
public class solution8 {
    public int JumpFloor(int target) {
        int pre1 = 1;
        int pre2 = 2;
        int curr = 0;
        for(int i = 3; i <= target; i++){
            curr = pre1 + pre2;
            pre1 = pre2;
            pre2 = curr;
        }
        if(target == 0)return 0;
        if(target == 1)return 1;
        if(target == 2)return 2;
        else return curr;
    }
}
