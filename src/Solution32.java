/**
 * Created by cxj on 17-3-28.
 */
public class Solution32 {
    public static int GetNumberOfK(int [] array , int k) {
        int st = 0, fin = array.length - 1;
        int sum = 0;
        //if(fin == st && array[st] == k)return 1;
        while(st <= fin && array[st] <= k && array[fin] >= k ){
            if(array[st] == k && array[fin] == k){
                if(st - 1 < 0 || array[st - 1] < k){
                    if(fin + 1 >= array.length || array[fin + 1] > k)return fin - st + 1;
                }
            }
            int i = st,j = fin;
            int mid = i + (j - i) / 2;
            if(array[mid] < k){
                st = mid;
                st++;
            }
            else if(array[mid] > k){
                fin = mid;
                fin--;
            }
            else {
                int nextst = mid;
                int nextfin = mid;
                while(array[st] != array[nextst]){
                    int tmid = st + (nextst - st + 1) / 2;
                    if(array[tmid] < array[nextst])st = tmid;
                    else{
                        nextst = tmid;
                        st++;
                    }
                }
                while (array[fin] != array[nextfin]){
                    int tmid = nextfin + (fin - nextfin) / 2;
                    if(array[tmid] > array[nextfin])fin = tmid;
                    else{
                        fin--;
                        nextfin = tmid;
                    }
                }
                return fin - st + 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(GetNumberOfK(new int[]{1,3,3,3,3,4,5},3));
    }
}
