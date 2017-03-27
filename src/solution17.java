/**
 * Created by cxj on 17-3-26.
 */
import java.util.ArrayList;
import java.util.Iterator;
public class solution17 {
    static ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();

    public static void findone(TreeNode current,ArrayList<Integer> s){
        ArrayList<Integer> next = new ArrayList<Integer>(s);
        if(current == null)tmp.add(next);
        else {
            next.add(Integer.valueOf(current.val));
            if(current.left != null) findone(current.left,next);
            if(current.right != null)findone(current.right,next);
            if(current.left == null && current.right == null) tmp.add(next);
        }
    }

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null)return new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> s = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> newone = new ArrayList<ArrayList<Integer>>();
        findone(root,s);
        Iterator ir = tmp.iterator();
        while(ir.hasNext()){
            ArrayList<Integer> currt = new ArrayList<Integer>((ArrayList<Integer>)ir.next());
            int sum = 0;
            Iterator ir2 = currt.iterator();
            while(ir2.hasNext()){
                int a = (Integer)ir2.next();
                sum += a;
            }
            while(sum > target){
                int a = currt.get(0);
                sum -= a;
                currt.remove(0);
            }
            if(sum == target){
                if(newone.indexOf(currt) < 0)newone.add(currt);
            }
        }
        return newone;
    }
}
