/**
 * Created by cxj on 17-4-30.
 */

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.math.BigDecimal;

class Node{
    double x;
    double y;
    public Node(double x, double y){
        this.x = x;
        this.y = y;
    }
    public boolean equals(Object st)
    {
        Node temp= (Node) st;
        if (x == temp.x && y == temp.y) return true;
        else return false;
    }
}

public class Makerand {
    public Makerand(int n) {
        HashSet<Node> hs = new HashSet<Node>();
        for (int i = 0; i < n; i++) {
            do {
                double x = Math.random() * 100;
                BigDecimal bg = new BigDecimal(x);
                x = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                double y = Math.random() * 100;
                bg = new BigDecimal(y);
                y = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                Node tmp = new Node(x, y);
                if (!hs.contains(tmp)) {
                    hs.add(tmp);
                    break;
                }
            } while (true);
        }

        Iterator iterator = hs.iterator();
        try {

            String content = "This is the content to write into file";

            File file = new File("test" + String.valueOf(n) + ".txt");

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