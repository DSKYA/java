/**
 * Created by cxj on 17-3-27.
 * 搜索树转双向链表
 */
public class solution19 {
    static int times = 0;
    public static TreeNode Convert(TreeNode root){
        times++;
        if(root.left == null && root.right == null){times--;return root;}
        TreeNode tree1 = null;
        if(root.left != null){
            tree1 = Convert(root.left);
            // if(tree1.left == null)result = tree1;
            while(tree1.right != null)tree1 = tree1.right;
            tree1.right = root;
            root.left = tree1;
        }
        tree1 = root;
        if(root.right != null){
            tree1 = Convert(root.right);
            while(tree1.left != null)tree1 = tree1.left;
            tree1.left = root;
            root.right = tree1;
        }

        times--;
        if(times == 0){
            while(root.left!=null)root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode tmp =new TreeNode(8);
        tmp.left = new TreeNode(6);
        tmp.right = new TreeNode(12);
        tmp.right.right = new TreeNode(14);
        tmp.right.right.right = new TreeNode(16);
        tmp.left.left = new TreeNode(4);
        tmp.right.left = new TreeNode(10);
        tmp = Convert(tmp);
        System.out.println("solution1");
    }

}
