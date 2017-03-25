/**
 * Created by cxj on 17-3-25.
 */
public class solution12 {
    public boolean Has(TreeNode root1,TreeNode root2) {
        if(root2 == null)return true;
        if(root1 != null && root2 != null && root1.val == root2.val){
            if(Has(root1.left,root2.left) && Has(root1.right,root2.right))return true;
            else return false;
        }
        else return false;
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean flg = false;
        if(root2 == null)return false;
        flg = flg | Has(root1,root2);
        if(root1 == null)return flg;
        flg = flg | HasSubtree(root1.left,root2) | HasSubtree(root1.right,root2);
        return flg;
    }
}
