/**
 * Created by cxj on 17-3-31.
 */
import java.util.LinkedList;
public class Solution9 {
    LinkedList<TreeNode> result = new LinkedList<TreeNode>();
    int top;
    TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot == null || k <= 0)return null;
        top = k;
        KthNode2(pRoot);
        if(k > result.size())return null;
        return result.get(k - 1);
    }

    void KthNode2(TreeNode pRoot)
    {
        if(result.size() < top){
            if(pRoot.left != null){
                KthNode2(pRoot.left);
            }
            result.addLast(pRoot);
            if(pRoot.right != null){
                KthNode2(pRoot.right);
            }
        }
    }


}