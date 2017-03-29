import java.util.Arrays;

/**
 * Created by cxj on 17-3-29.
 */
public class Solution5 {
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
}
