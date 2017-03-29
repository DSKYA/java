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
public class Solution1 {
    public int TreeDepth(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        ArrayList<Integer> numlist = new ArrayList<Integer>();
        int sum = 0;
        if(root == null)return 0;
        list.add(root);
        numlist.add(1);
        while(!list.isEmpty()){
            TreeNode p = list.remove(0);
            sum = numlist.remove(0);
            if(p.left != null){
                list.add(p.left);
                numlist.add(sum + 1);
            }
            if(p.right != null){
                list.add(p.right);
                numlist.add(sum + 1);
            }
        }
        return sum;
    }
}