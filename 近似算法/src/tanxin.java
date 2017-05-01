import java.io.*;
import java.util.HashSet;

/**
 * Created by cxj on 17-5-1.
 */
public class tanxin {
    int n;
    Node[] ls;
    boolean[] fg;
    int[] result;
    int rcount = 0;
    HashSet<Integer> hs = new HashSet<Integer>();
    public  tanxin(int n){
        this.n = n;
        ls = new Node[n];
        fg = new boolean[n];
        result = new int[n];
        File file = new File("test" + String.valueOf(n) + ".txt");
        BufferedReader reader = null;
        try {
            //System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 0;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                String[] tmp = tempString.split(" ");
                ls[line] = new Node(tmp);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
    public void getjihe(){
        while(hs.size() < n){
            int tmp_max = -1;
            int tmp_sum = 0;
            int tmp_loc = 0;
            for(int i = 0; i < n; i++){
                tmp_sum = 0;
                if(!fg[i]){
                    for (int j = 0; j < ls[i].n; j++){
                        if(!hs.contains(ls[i].ls[j]))tmp_sum++;
                    }
                    if(tmp_sum > tmp_max){
                        tmp_loc = i;
                        tmp_max = tmp_sum;
                    }
                }
            }
            for (int j = 0; j < ls[tmp_loc].n; j++){
                if(!hs.contains(ls[tmp_loc].ls[j])){
                    hs.add(ls[tmp_loc].ls[j]);
                }
            }
            fg[tmp_loc] = true;
            result[rcount] = tmp_loc;
            rcount++;
        }
        System.out.println("贪心完成");
    }
    public void writetanxin(){
        try {

            File file = new File("tanxin" + String.valueOf(n) + ".txt");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWritter = new FileWriter(file.getName(),true);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write("集合C的大小是：" + String.valueOf(rcount) + "\n");
            for (int i = 0; i < rcount; i++){
                bufferWritter.write(String.valueOf("编号:" + result[i] + "-->"));
                for (int j = 0; j < ls[result[i]].n; j++)bufferWritter.write(String.valueOf(" " + String.valueOf(ls[result[i]].ls[j])));
                bufferWritter.write(String.valueOf("\n"));
            }
            bufferWritter.close();
            System.out.println("Done");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
