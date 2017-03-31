/**
 * Created by cxj on 17-3-31.
 */
import java.util.LinkedList;
public class Solution8 {
    String Serialize(TreeNode root) {
        LinkedList<TreeNode> tmp = new LinkedList<TreeNode>();
        StringBuffer result = new StringBuffer();
        int sum = 0;
        if(root == null)return result.toString();
        tmp.addLast(root);
        sum = 1;
        while(!tmp.isEmpty() && sum > 0){
            TreeNode p = tmp.removeFirst();
            sum--;
            if(p == null){
                sum++;
                result.append('#');
            }
            else {
                result.append(p.val);
                if(p.left != null){
                    sum++;
                    tmp.addLast(p.left);
                }
                else tmp.addLast(null);
                if(p.right != null){
                    sum++;
                    tmp.addLast(p.right);
                }
                else tmp.addLast(null);

            }
            if(sum > 0)result.append(',');
        }
        return result.toString();
    }

    int index = -1;


    TreeNode Deserialize(String str) {
        int i = 0;
        if(str.length() == 0)
            return null;
        String[] strs = str.split(",");
        LinkedList<TreeNode> tmp = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(strs[i]));
        i++;
        tmp.addLast(root);
        while(!tmp.isEmpty() && i < strs.length){
            TreeNode p = tmp.removeFirst();
            if(i < strs.length && !strs[i].equals("#")){
                p.left = new TreeNode(Integer.parseInt(strs[i]));
                tmp.addLast(p.left);
            }
            i++;
            if(i < strs.length && !strs[i].equals("#")){
                p.right = new TreeNode(Integer.parseInt(strs[i]));
                tmp.addLast(p.right);
            }
            i++;
        }
        return root;
    }
}
