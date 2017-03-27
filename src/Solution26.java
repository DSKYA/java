import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by cxj on 17-3-27.
 */
public class Solution26 {

    public static ArrayList<Treenode2> list = new ArrayList<Treenode2>();

    public static Treenode2 find_tree(Treenode2 now,char target){
        if(now == null)return null;
        if(now.val == target)return now;
        Treenode2 result = find_tree(now.left,target);
        if(result == null) find_tree(now.right,target);
        return result;
    }

    public static Treenode2 buildtree(Treenode2 root, String tmps){
        String[] tmp = tmps.split(" ");
        int sum = 0;
        Treenode2 tt = null;
        for (String i:tmp) {

            char c = i.charAt(0);
            if(sum == 0){
                if(find_tree(root,c) == null){
                    Treenode2 newone = new Treenode2(c);
                    root = newone;
                    list.add(newone);
                    tt = newone;
                }
                else{
                    tt = find_tree(root,c);
                }
            }
            else if(sum == 1){
                tt.left = new Treenode2(c);
            }
            else {
                for(int j = 2; j < sum; j++){
                  tt = tt.right;
                }
                tt.right = new Treenode2(c);
            }
            sum++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Treenode2 root = null;
        while(s.hasNextLine()){
            String z = s.nextLine();
            root = buildtree(root,z);
        }
        Treenode2 p = null;
        Treenode2 head = null;//head 为 二叉树的头
        for (Treenode2 x:list) {
            if(p == x){
                head = x;
                p = x;
            }
            else{
                p.right = x;
                p = x;
            }
        }
        System.out.println("OK");
    }
}
