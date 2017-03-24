/**
 * Created by cxj on 17-3-24.
 */
public class solution2 {
    public static String replaceSpace(StringBuffer str) {
        String tmp = str.toString();
        String[] s = tmp.split(" ");
        String result = new String("");
        int sum = 0;
        int i;
        for (i = 0; i < s.length - 1; i++){
            result += s[i];
            result += "%20";
            sum += s[i].length() + 1;
        }
        if(i == s.length - 1){
        result += s[i];
        sum += s[i].length();
        }
        for(i = sum; i < tmp.length(); i++){
            result += "%20";
        }
        return result;
    }
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer(" ");
        System.out.println(replaceSpace(s));
        System.out.println("solution2");
    }
}
