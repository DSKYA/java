import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by cxj on 17-4-30.
 */
public class Gs {
    Node[] ch; //点集p的凸包
    Node[] p; //给出的点集
    int n;
    int l = 0;
    int len=0;

    public Gs(int n){
        this.n = n;
        ch = new Node[n];
        p = new Node[n];
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
                p[line - 2] = x;
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

    public double multiply(Node p1, Node p2, Node p0) {
        return ((p1.x - p0.x) * (p2.y - p0.y) - (p2.x - p0.x) * (p1.y - p0.y));
    }

    //求距离
    public double distance(Node p1, Node p2) {
        return (Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y)
                * (p1.y - p2.y)));
    }

    public void answer(){
        double sum = 0;
        for (int i = 0; i < len - 1; i++) {
            sum += distance(ch[i], ch[i + 1]);
        }
        if (len > 1) {
            sum += distance(ch[len - 1], ch[0]);
        }
        sum += 2 * l * Math.PI;
        System.out.println(Math.round(sum));
    }

    public int Graham_scan() {
        int k = 0, top = 2;
        Node tmp;

//找到最下且偏左的那个点
        for (int i = 1; i < n; i++)
            if ((p[i].y < p[k].y)
                    || ((p[i].y == p[k].y) && (p[i].x < p[k].x)))
                k = i;
//将这个点指定为pts[0],交换pts[0]与pts[k]
        tmp = p[0];
        p[0] = p[k];
        p[k] = tmp;

//按极角从小到大,距离偏短进行排序
        for (int i = 1; i < n - 1; i++) {
            k = i;
            for (int j = i + 1; j < n; j++)
                if ((multiply(p[j], p[k], p[0]) > 0)
                        || ((multiply(p[j], p[k], p[0]) == 0) && (distance(
                        p[0], p[j]) < distance(
                        p[0], p[k]))))
                    k = j; //k保存极角最小的那个点,或者相同距离原点最近 
            tmp = p[i];
            p[i] = p[k];
            p[k] = tmp;
        }

//前三个点先入栈
        ch[0] = p[0];
        ch[1] = p[1];
        ch[2] = p[2];

//判断与其余所有点的关系
        for (int i = 3; i < n; i++) {
//不满足向左转的关系,栈顶元素出栈
            while (top > 0 && multiply(p[i], ch[top], ch[top - 1]) >= 0)
                top--;

//当前点与栈内所有点满足向左关系,因此入栈.
            ch[++top] = p[i];
        }
        len=top+1;
        return len;
    }
    
    public void getTubao(){
        this.len = Graham_scan();
    }

    public void writeTubao(){
        try {

            String content = "This is the content to write into file";

            File file = new File("gs" + String.valueOf(n) + ".txt");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWritter = new FileWriter(file.getName(),true);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            for(int i = 0; i < this.len; i++){
                bufferWritter.write(String.valueOf(ch[i].x + " " + ch[i].y + "\n"));
            }
            bufferWritter.close();
            System.out.println("Done");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
