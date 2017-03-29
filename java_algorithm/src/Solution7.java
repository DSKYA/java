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
    public static void main(String []args) {
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
    }
}
