/**
 * Created by cxj on 17-3-29.
 */
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
        System.out.println((deleteDuplication(root)));
    }
}
