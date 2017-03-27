/**
 * Created by cxj on 17-3-27.
 */
import java.util.ArrayList;
import java.util.TreeSet;
import java.lang.StringBuilder;
import java.util.Iterator;
public class solution20 {
    private int[] flag = new int[26];
    private StringBuilder edit = new StringBuilder("");
    private TreeSet<String> hashmap = new TreeSet<String>();
    private int times = 0;

    public void find(int nowtimes) {
        if (nowtimes == times) {
            hashmap.add(edit.toString());
        } else {
            for (int i = 0; i < 26; i++) {
                if (flag[i] > 0) {
                    edit.append((char)(i + 'a'));
                    flag[i]--;
                    find(nowtimes + 1);
                    flag[i]++;
                    edit.deleteCharAt(edit.length() - 1);
                }
            }
        }
    }

        public ArrayList<String> Permutation (String str){
            ArrayList<String> result = new ArrayList<String>();
            times = str.length();
            for (int i = 0; i < times; i++) {
                char tmp = str.charAt(i);
                flag[tmp - 'a']++;
            }
            find(0);
            Iterator ir = hashmap.iterator();
            while(ir.hasNext()){
                result.add(String.valueOf(ir.next()));
            }
            return result;
        }
}
