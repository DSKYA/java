import java.util.ArrayList;
import java.lang.String;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public  static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        sum = sum * 2;
        int top = (int)Math.sqrt(sum);
        while(top > 1){
            if(sum % top == 0){
                int tmp = sum / top;
                if(tmp + 1 - top > 0 && (tmp + 1 - top) % 2 == 0)
                {
                    int i = (tmp + 1 - top) / 2;
                    ArrayList<Integer> curr = new ArrayList<Integer>();
                    for (int j = i; j < i + top; j++){
                        curr.add(j);
                    }
                    result.add(curr);
                }
            }
            top--;
        }
        return result;
    }

    public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int st = 0,fin = array.length - 1;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(st < fin){
            if(array[st] + array[fin] == sum){
                result.add(array[st]);
                result.add(array[fin]);
                if(array[st + 1] - array[st] < array[fin] - array[fin - 1])st++;
                else fin--;
                break;
            }
            else if(array[st] + array[fin] < sum){
                st++;
            }
            else{
                fin--;
            }
    }
    return result;
}
    public static String LeftRotateString(String str,int n) {
        int sum = n % str.length();
        String s1 = new String(str.substring(0 + sum));
        String s2 = new String(str.substring(0,0 + sum));
        return s1 + s2;
    }

    public  static String ReverseSentence(String str) {
        if(str == null){ return null;}
        if(str.trim().equals("")){
            return str;
        }
        StringBuilder list = new StringBuilder();
        String[] s = str.split(" ");
        for(int i = s.length - 1; i >= 0; i--){
            list.append(s[i]);
            if(i != 0)list.append(" ");
        }
        return list.toString();
    }


public boolean isContinuous(int [] numbers) {
        if(numbers.length != 5) return false;
        byte[] istmp = new byte[2];
        int min = 14;
        int max = -1;
        for(int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if(number < 0 || number > 13) return false;
            if(number == 0) continue;

            if(((istmp[number / 8] >> number % 8) & 1) == 1) return false;
            istmp[number / 8] |= (1 << number % 8);
            if(number > max) max = number;
            if(number < min) min = number;
            if(max - min >= 5) return false;
        }
        return true;
    }

    public static int LastRemaining_Solution(int n, int m) {
        if(n == 0)return -1;
        if(n == 1)return 0;
        int i = 2;
        int getout;
        int winner = 1;
        int next;
        while(i <= n){
            getout = m % i;
            if(getout == 0)getout = i;
            next = (getout + 1) % i;
            if(next == 0)next = i;
            winner = (winner + next - 1) % i;
            if(winner == 0)winner = i;
            i++;
        }
        return  winner - 1;
    }

    public int StrToInt(String str) {
        if(str.equals("0"))return 0;
        int sum = 0;
        for(int i = 0; i < str.length(); i++){
            if((int)str.charAt(i) < (int)'0' || ((int)str.charAt(i) > (int)'9'))return 0;
            else{
                sum = (sum << 3) + (sum << 1) + (int)str.charAt(i) - (int)'0';
            }
        }
        return sum;
    }

    public static boolean duplicate(int [] duplication,int length,int numbers[]) {
        int n = duplication.length;
        if(n <= 0)
        {
            numbers[0] = -1;
            return false;
        }
        for(int i = 0; i < duplication.length; i++){
            int tmp = duplication[i];
            if(tmp < 0){
                tmp = tmp + n;
            }
            if(duplication[tmp] < 0){numbers[0] = tmp; return true;}
            else {
                duplication[tmp] -= n;
            }
        }
        numbers[0] = -1;
        return false;
    }

    public static boolean match(char[] str, char[] pattern)
    {
        int i = 0;
        int j = 0;
        int n = str.length;
        int m = pattern.length;
        if(n <= 0 && m <= 0)return  true;
        do{
            if(i < n && j < m && pattern[j] == str[i]){
                if(j + 1 < m && pattern[j + 1] == '*'){
                    char tmpc = str[i];
                    j += 2;
                    while (j < m && i < n && str[i] == tmpc){
                        if(match(Arrays.copyOfRange(str,i,n),Arrays.copyOfRange(pattern,j,m)))return true;
                        i++;
                    }
                    if(j >= m)while(i < n && str[i] == tmpc)i++;
                }
                else{
                    i++;
                    j++;
                }
            }
            else{
                if(i < n && j < m && pattern[j] =='.'){
                    if(j +1 < m && pattern[j + 1] == '*'){
                        j += 2;
                        if(j >= m)return true;
                        while (i < n){
                            if(match(Arrays.copyOfRange(str,i,n),Arrays.copyOfRange(pattern,j,m)))return true;
                            i++;
                        }
                    }
                    else{
                        i++;
                        j++;
                    }
                }
                else if(j + 1 < m && pattern[j + 1] == '*')j+=2;
                else return false;
            }
        }while(i <= n && j < m);
        if(i >= n && j >= m)return true;
        else return false;
    }

    public static boolean isNumeric(char[] str) {
//        String regx = "((/+|-)?)(/d{1,}|/d{1,}./d{1,}|(/d{1,}|/d{1,}./d{1,})(e|E)-?(/d{1,}|/d{1,}./d{1,}))";
        String regx = "[\\+-]?(\\d+|\\d*\\.\\d+|(\\d+|\\d*\\.\\d+)(e|E)(-|\\+)?\\d+)";
        String tmp = new String(str);
        if(Pattern.matches(regx,tmp))return true;
        else return false;
    }

    public static void main(String []args){
        //System.out.println(FindNumbersWithSum(new int[]{1,2,3,4},4));
      //  System.out.println(ReverseSentence(" "));
     //   System.out.println(LastRemaining_Solution(5,3));
    //    System.out.println(match(new char[]{'a','a','a'},new char[]{'a','b','*','a','c','*','a'}));
        System.out.println(isNumeric(new char[]{'-','1','0','e','-','1'}));
        //System.out.println(duplicate(new int[],));
    }
}
