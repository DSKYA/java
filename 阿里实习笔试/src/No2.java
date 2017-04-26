import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class node{
    String x;
    int y;
    public node(String s,int a){
        this.x = s;
        this.y = a;
    }
    public int compareTo(Object obj) {// Comparable接口中的方法
        node b = (node)obj;
        return this.y - b.y;
    }
}

public class No2 {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/

    static class tComparator implements Comparator {
        public int compare(Object object1, Object object2) {// 实现接口中的方法
            node p1 = (node) object1; // 强制转换
            node p2 = (node) object2;
            return p1.y - p2.y;
        }
    }

    static int[] wordCount(String doc, int m, int n, String[] filterWords, String[] countwords) {
        LinkedList<node> list = new LinkedList<node>();
        int[] result = new int[countwords.length];
        //LinkedList<String> list = new LinkedList<String>();
        do {
            list.clear();
            for (String p : filterWords) {
                if (doc.contains(p)) {
                    list.addLast(new node(p, doc.indexOf(p)));
                }
            }
            Collections.sort(list, new tComparator());
            while (!list.isEmpty()) {
                String best = list.pollFirst().x;
                boolean fg = true;
                for (int i = 0; i < list.size(); i++) {
                    if (best.contains(list.get(i).x)) {
                        fg = false;
                        break;
                    }
                }
                if (fg) {
                    doc = doc.replace(best, " ");
                    break;
                }
            }
        } while (!list.isEmpty());
        String[] last = doc.split(" ");
        for (int i = 0; i < last.length; i++) {
            for (int j = 0; j < countwords.length; j++) {
                if (last[i].equals(countwords[j])) {
                    result[j]++;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] res;

        String _doc;
        try {
            _doc = in.nextLine();
        } catch (Exception e) {
            _doc = null;
        }

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        int _n;
        _n = Integer.parseInt(in.nextLine().trim());

        int _filterWords_size = _m;
        _filterWords_size = Integer.parseInt(in.nextLine().trim());
        String[] _filterWords = new String[_filterWords_size];
        String _filterWords_item;
        for(int _filterWords_i = 0; _filterWords_i < _filterWords_size; _filterWords_i++) {
            try {
                _filterWords_item = in.nextLine();
            } catch (Exception e) {
                _filterWords_item = null;
            }
            _filterWords[_filterWords_i] = _filterWords_item;
        }

        int _countwords_size = _n;
        _countwords_size = Integer.parseInt(in.nextLine().trim());
        String[] _countwords = new String[_countwords_size];
        String _countwords_item;
        for(int _countwords_i = 0; _countwords_i < _countwords_size; _countwords_i++) {
            try {
                _countwords_item = in.nextLine();
            } catch (Exception e) {
                _countwords_item = null;
            }
            _countwords[_countwords_i] = _countwords_item;
        }

        res = wordCount(_doc, _m, _n, _filterWords, _countwords);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}