/**
 * Created by cxj on 17-3-29.
 */
import java.util.ArrayList;
import java.util.LinkedList;
public class Solution7 {
    static StringBuffer s = new StringBuffer();
    static byte[] istest = new byte[32];
    static byte[] num = new byte[32];
    public static void Insert(char ch)
    {
        s.append(ch);
        int curr = ch;
        int tmp = curr/8;
        if((num[tmp] >> (curr % 8)& 1) == 0){
            num[tmp] = (byte) (num[tmp]|(1 << (curr % 8)));
        }
        else{
            istest[tmp] = (byte) (istest[tmp]|(1 << (curr % 8)));
        }
    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce()
    {
        for (int i = 0; i < s.length(); i++){
            int curr = (int)s.charAt(i);
            int tmp = curr/8;
            if((istest[tmp] >> (curr % 8)& 1) == 0){
                return  s.charAt(i);
            }
        }
        return '#';
    }

    public static ListNode deleteDuplication(ListNode pHead)
    {
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        if(p2.next == null)return pHead;
        if(pHead.val != pHead.next.val){
            p2 = p2.next;
            while(p2 != null && p1.next != null){
                p2 = p2.next;
                if(p2 == null)return pHead;
                ListNode pp = p1;
                p1 = p1.next;
                if(p1.val == p2.val){
                    while(p2 !=null && p2.val == p1.val){
                        p2=p2.next;
                    }
                    pp.next = p2;
                }
                else{
                    pp = pp.next;
                }
                p1 = pp;
            }
            return pHead;
        }
        else{
            ListNode tmphead = new ListNode(pHead.val - 1);
            tmphead.next = pHead;
            p1 = tmphead;
            while(p2 != null && p1.next != null){
                p2 = p2.next;
                if(p2 == null)return tmphead.next;
                ListNode pp = p1;
                p1 = p1.next;
                if(p1.val == p2.val){
                    while(p2 !=null && p2.val == p1.val){
                        p2=p2.next;
                    }
                    pp.next = p2;
                }
                else{
                    pp = pp.next;
                }
                p1 = pp;
            }
            return tmphead.next;
        }
    }

    static boolean isleft = true;
    public static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        LinkedList a1 = new LinkedList();
        LinkedList a2 = new LinkedList();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null)return result;
        a1.addLast(pRoot);
        while(!a1.isEmpty()|| !a2.isEmpty()){
            if(isleft == true){
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                while(!a1.isEmpty()){
                    TreeNode p = (TreeNode) a1.removeLast();
                    tmp.add(p.val);
                    if(p.left != null)a2.addLast(p.left);
                    if(p.right != null)a2.addLast(p.right);
                }
                result.add(tmp);
                isleft = false;
            }
            else{
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                while(!a2.isEmpty()){
                    TreeNode p = (TreeNode) a2.removeLast();
                    tmp.add(p.val);
                    if(p.right != null)a1.addLast(p.right);
                    if(p.left != null)a1.addLast(p.left);
                }
                result.add(tmp);
                isleft = true;
            }
        }
        return result;
    }

    ArrayList<ArrayList<Integer> > Print2(TreeNode pRoot) {
        boolean isleft = true;
        LinkedList a1 = new LinkedList();
        LinkedList a2 = new LinkedList();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null)return result;
        a1.addLast(pRoot);
        while(!a1.isEmpty()|| !a2.isEmpty()){
            if(isleft == true){
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                while(!a1.isEmpty()){
                    TreeNode p = (TreeNode) a1.removeFirst();
                    tmp.add(p.val);
                    if(p.left != null)a2.addLast(p.left);
                    if(p.right != null)a2.addLast(p.right);
                }
                result.add(tmp);
                isleft = false;
            }
            else{
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                while(!a2.isEmpty()){
                    TreeNode p = (TreeNode) a2.removeFirst();
                    tmp.add(p.val);
                    if(p.left != null)a1.addLast(p.left);
                    if(p.right != null)a1.addLast(p.right);
                }
                result.add(tmp);
                isleft = true;
            }
        }
        return result;
    }

    static String Serialize(TreeNode root) {
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

    static int index = -1;

    static TreeNode Deserialize2(String[] strs) {
        index++;
        if(index < strs.length && !strs[index].equals("#")) {
            TreeNode root = new TreeNode(0);
            root.val = Integer.parseInt(strs[index]);
            root.left = Deserialize2(strs);
            root.right = Deserialize2(strs);
            return root;
        }
        return null;
    }

    static TreeNode Deserialize(String str) {
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


    public static void main(String []args) {
        /*
        Insert('h');
        System.out.println(FirstAppearingOnce());
        Insert('e');
        System.out.println(FirstAppearingOnce());
        Insert('l');
        System.out.println(FirstAppearingOnce());
        Insert('l');
        System.out.println(FirstAppearingOnce());
        Insert('o');
        System.out.println(FirstAppearingOnce());
        Insert('w');
        System.out.println(FirstAppearingOnce());
        Insert('w');
        System.out.println(FirstAppearingOnce());
        Insert('o');
        System.out.println(FirstAppearingOnce());
        Insert('r');
        System.out.println(FirstAppearingOnce());
        Insert('d');
        System.out.println(FirstAppearingOnce());
        */
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next.next = new ListNode(5);
       // System.out.println((deleteDuplication(root)));
        TreeNode root2 =new TreeNode(5);
        root2.left = new TreeNode(4);
        //root2.right = new TreeNode(10);
        root2.left.left = new TreeNode(3);
        root2.left.left.left = new TreeNode(2);
        //System.out.println((Print(root2)));
        System.out.println(Serialize((Deserialize("5,4,#,3,#,2"))));
    }
}
