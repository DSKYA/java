import java.util.Stack;

public class Main {

    public static boolean Find(int target, int[][] array) {
        int x = array.length;
        int y = array[0].length;
        Stack<Integer> ai0 = new Stack<Integer>(),ai1 = new Stack<Integer>(),aj0 = new Stack<Integer>(),aj1 = new Stack<Integer>();
        ai0.push(0);
        ai1.push(x - 1);
        aj0.push(0);
        aj1.push(y - 1);
        int i0,i1,j0,j1;
        while(!ai0.empty()){
            i0 = (int)ai0.pop();
            i1 = (int)ai1.pop();
            j0 = (int)aj0.pop();
            j1 = (int)aj1.pop();
            if(i0 > i1 || j0 > j1)return false;
            if(i0 < i1 - 1|| j0 < j1 -1){
                if(array[(i0 + i1)/2][(j0 + j1)/2] < target){
                    if((i0 + i1)/2 + 1 <= i1 && (j0 + j1)/2 - 1 >= j0) {
                        ai0.push((i0 + i1) / 2 + 1);
                        ai1.push(i1);
                        aj0.push(j0);
                        aj1.push((j0 + j1) / 2 - 1);
                    }
                    if((i0 + i1)/2 - 1 >= i0 && (j0 + j1)/2 + 1 <= j1) {
                        ai0.push(i0);
                        ai1.push((i0 + i1) / 2 - 1);
                        aj0.push((j0 + j1) / 2 + 1);
                        aj1.push(j1);
                    }
                    ai0.push((i0 + i1)/2);
                    ai1.push(i1);
                    aj0.push((j0 + j1)/2);
                    aj1.push(j1);
                }
                else if(array[(i0 + i1)/2][(j0 + j1)/2] > target){
                    if((i0 + i1)/2 + 1 <= i1 && (j0 + j1)/2 - 1 >= j0) {
                        ai0.push((i0 + i1) / 2 + 1);
                        ai1.push(i1);
                        aj0.push(j0);
                        aj1.push((j0 + j1) / 2 - 1);
                    }

                    if((i0 + i1)/2 - 1 >= i0 && (j0 + j1)/2 + 1 <= j1) {
                        ai0.push(i0);
                        ai1.push((i0 + i1) / 2 - 1);
                        aj0.push((j0 + j1) / 2 + 1);
                        aj1.push(j1);
                    }

                    ai0.push(i0);
                    ai1.push((i0 + i1)/2);
                    aj0.push(j0);
                    aj1.push((j0 + j1)/2);
                }
                else return true;
            }
            else {
                    if (array[i0][j0] == target) return true;
                    if (array[i0][j1] == target) return true;
                    if (array[i1][j0] == target) return true;
                    if (array[i1][j1] == target) return true;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        int a[][] = {{1,2,3},{2,4,6},{3,8,9}};
        System.out.println(Find(9,a));
        System.out.println("Hello World!");
    }
}
