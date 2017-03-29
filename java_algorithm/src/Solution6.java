import java.util.regex.Pattern;

/**
 * Created by cxj on 17-3-29.
 */
public class Solution6 {
    public static boolean isNumeric(char[] str) {
//        String regx = "((/+|-)?)(/d{1,}|/d{1,}./d{1,}|(/d{1,}|/d{1,}./d{1,})(e|E)-?(/d{1,}|/d{1,}./d{1,}))";
        String regx = "[\\+-]?(\\d+|\\d*\\.\\d+|(\\d+|\\d*\\.\\d+)(e|E)(-|\\+)?\\d+)";
        String tmp = new String(str);
        if(Pattern.matches(regx,tmp))return true;
        else return false;
    }
}
