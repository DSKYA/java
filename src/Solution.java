public class Solution {
    static int  cnt;
 
    public static int InversePairs(int[] array) {
        cnt = 0;
        if (array != null)
            mergeSortUp2Down(array, 0, array.length - 1);
        return cnt;
    }
 
    /*
     *     (    )
     */
    public static void mergeSortUp2Down(int[] a, int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) >> 1;
 
        mergeSortUp2Down(a, start, mid);
        mergeSortUp2Down(a, mid + 1, end);
 
        merge(a, start, mid, end);
    }
 
    /*
     *                     
     */
    public static void merge(int[] a, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
 
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (a[i] <= a[j])
                tmp[k++] = a[i++];
            else {
                tmp[k++] = a[j++];
                cnt += (mid - i + 1) % 1000000007;  // core code, calculate InversePairs............
            }
        }
 
        while (i <= mid)
            tmp[k++] = a[i++];
        while (j <= end)
            tmp[k++] = a[j++];
        for (k = 0; k < tmp.length; k++)
            a[start + k] = tmp[k];
    }

    public static void main(String[] args) {
        int[] s = new int[500000];
        for(int i = 0; i < 1000; i++){
            s[i] = 199999 - i;
        }
        System.out.print(InversePairs(s));
    }
}
