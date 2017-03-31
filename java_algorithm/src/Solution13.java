/**
 * Created by cxj on 17-4-1.
 */
public class Solution13 {
        public int movingCount(int threshold, int rows, int cols) {
            int flag[][] = new int[rows][cols];
            return process(0, 0, rows, cols, flag, threshold);
        }

        private int process(int i, int j, int rows, int cols, int[][] flag, int threshold) {
            if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j)  > threshold || flag[i][j] == 1) return 0;
            flag[i][j] = 1;
            return process(i - 1, j, rows, cols, flag, threshold)
                    + process(i + 1, j, rows, cols, flag, threshold)
                    + process(i, j - 1, rows, cols, flag, threshold)
                    + process(i, j + 1, rows, cols, flag, threshold)
                    + 1;
        }

        private int numSum(int i) {
            int a= 0;
            do{
                a+= i%10;
            }while((i = i/10) > 0);
            return a;
        }

    public static void main(String []args){
        System.out.print(movingCount(5,10,10));
    }
}
