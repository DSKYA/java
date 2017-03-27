/**
 * Created by cxj on 17-3-26.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class solution15 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> list = new LinkedList<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        list.offer(root);
        while(!list.isEmpty()){
            TreeNode tmp = list.poll();
            if(tmp != null){
                result.add(tmp.val);
                list.offer(tmp.left);
                list.offer(tmp.right);
            }
        }
        return result;
    }
}
