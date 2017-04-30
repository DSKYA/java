import javax.xml.soap.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by cxj on 17-4-30.
 */
public class Meiju {
    ArrayList<Node> ls = new ArrayList<Node>();
    HashSet<Node> hs  = new HashSet<>();
    int n;

    public Meiju(int n){
        this.n = n;
        File file = new File("test" + String.valueOf(n) + ".txt");
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
                String[] tmp = tempString.split(" ");
                Node x = new Node(Double.valueOf(tmp[0]),Double.valueOf(tmp[1]));
                ls.add(x);
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
    public void getTubao(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(i != j){
                    boolean fg = false;
                    boolean isans = true;
                    double fst= 0;
                    Node n1 = ls.get(i);
                    Node n2 = ls.get(j);
                    Node n3;
                    double rt = 0;
                    for (int l = 0; l < n; l++){
                        if(l != i && l != j){
                            n3 = ls.get(l);
                            rt = n1.x * n2.y + n3.x * n1.y + n2.x * n3.y - n3.x * n2.y - n2.x * n1.y - n1.x * n3.y;
                            if (!fg){
                                if(rt != 0){
                                    fg = true;
                                    fst = rt;
                                }
                            }
                            else{
                                if(rt * fst < 0){
                                    isans = false;
                                    break;
                                }
                            }
                        }
                    }
                    if(isans){
                        hs.add(n1);
                        hs.add(n2);
                    }
                }
            }
        }
        System.out.println("凸包计算完毕");
    }
    public void writeTubao(){
        Iterator iterator = hs.iterator();
        try {

            String content = "This is the content to write into file";

            File file = new File("meiju" + String.valueOf(n) + ".txt");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWritter = new FileWriter(file.getName(),true);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            while (iterator.hasNext()) {
                Node temp = (Node) iterator.next();
                bufferWritter.write(String.valueOf(temp.x + " " + temp.y + "\n"));
            }
            bufferWritter.close();
            System.out.println("Done");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
