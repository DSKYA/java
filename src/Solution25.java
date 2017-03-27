/**
 * Created by cxj on 17-3-27.
 */
import java.util.*;

public class Solution25 {
    public String PrintMinNumber(int [] numbers) {
        ArrayList<String> tmp = new ArrayList<String>();
        StringBuilder result = new StringBuilder();
        for (int a:numbers) {
            tmp.add(String.valueOf(a));
        }
        Collections.sort(tmp);
        Iterator<String> ir = tmp.iterator();
        while(ir.hasNext()){
            result.append(String.valueOf(ir.next()));
        }
        return result.toString();
    }
}
