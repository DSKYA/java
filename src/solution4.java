/**
 * Created by cxj on 17-3-24.
 */


public class solution4 {
    public static int[] getleft(int[] in,int target){
        int i = 0;
        for(i = 0; i < in.length; i++){
            if(in[i] == target)break;
        }
        int[] result = new int[i];
        for(int j = 0; j < i; j++){
            result[j] = in[j];
        }
        return result;
    }

    public static int[] getright(int[] in,int target){
        int i = 0;
        for(i = 0; i < in.length; i++){
            if(in[i] == target)break;
        }
        int[] result = new int[in.length - i - 1];
        for(int j = i + 1,k = 0; j < in.length; j++,k++){
            result[k] = in[j];
        }
        return result;
    }

    public static int[] getallpre(int[] pre,int sum){
        int[] result = new int[sum];
        for(int i = 1; i < sum + 1; i++){
            result[i - 1] = pre[i];
        }
        return result;
    }

    public static int[] getallin(int[] pre,int sum){
        int[] result = new int[sum];
        for(int i = sum; i > 0; i--){
            result[i - 1] = pre[pre.length - 1 - sum + i];
        }
        return result;
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if(pre.length > 0){
            TreeNode tree = new TreeNode(pre[0]);
            int left[] = getleft(in,pre[0]);
            int right[] = getright(in,pre[0]);
            int preleft[] = getallpre(pre,left.length);
            int preright[] = getallin(pre,right.length);
            tree.left = reConstructBinaryTree(preleft,left);
            tree.right = reConstructBinaryTree(preright,right);
            return tree;
        }
        else return null;
    }
    public static void main(String[] args) {
        int[] a =new int[]{1,2,3,4,5,6,7},b = new int[]{3,2,4,1,6,5,7};
        reConstructBinaryTree(a,b);
        System.out.println("4");
    }
}
