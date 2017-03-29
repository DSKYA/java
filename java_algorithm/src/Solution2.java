/**
 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }
 */
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution2 {
    public int getdepth(TreeNode root){
        if(root == null)return 0;
        int a = getdepth(root.left);
        int b = getdepth(root.right);
        if(Math.abs(a - b) > 1)return -2;
        else return a < b? b + 1 : a + 1;
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if(getdepth(root) == -2)return false;
        return true;
    }
}