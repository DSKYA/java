/**
 * Created by cxj on 17-4-30.
 */

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.math.BigDecimal;
import java.util.Random;

class Node {
    int a;
    int n;
    int[] ls;

    public Node(String[] a) {
        this.a = Integer.valueOf(a[0]);
        this.n = a.length - 1;
        this.ls = new int[n];
        for (int i = 0; i < n; i++) {
            ls[i] = Integer.valueOf(a[i + 1]);
        }
    }
}
public class Makerand {
        public Makerand(int n) {
            Random random = new Random();
            HashSet<Integer> hs = new HashSet<Integer>();
            int tmp_now = 100;
            int[][] result = new int[n][n];
            int[] count = new int[n];
            int p = 0;
            for (; p < 20; ) {
                int t = random.nextInt(n) + 1;
                if (!hs.contains(t)) {
                    result[0][p] = t;
                    p++;
                    hs.add(t);
                }
            }
            count[0] = 20;
            tmp_now -= 20;
            int i;
            for (i = 1; tmp_now > 0; i++) {
                p = 0;
                int tmp_max = random.nextInt(tmp_now) + 1;
                if(tmp_now < 20)tmp_max = tmp_now;
                for (; p < tmp_max; ) {
                    int t = random.nextInt(n) + 1;
                    if (!hs.contains(t)) {
                        result[i][p] = t;
                        p++;
                        hs.add(t);
                    }
                }
                tmp_now -= tmp_max;
                count[i] = tmp_max;
            }

            for (; i < n; i++) {
                hs.clear();
                p = 0;
                int tmp_max = random.nextInt(n / 2) + 1;
                for (; p < tmp_max; ) {
                    int t = random.nextInt(n) + 1;
                    if (!hs.contains(t)) {
                        result[i][p] = t;
                        p++;
                        hs.add(t);
                    }
                }
                count[i] = tmp_max;
            }
            try {

                File file = new File("test" + String.valueOf(n) + ".txt");
                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fileWritter = new FileWriter(file.getName(), true);
                BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                for (i = 0; i < n; i++) {
                    bufferWritter.write(String.valueOf(i));
                    for (int j = 0; j < count[i]; j++) {
                        bufferWritter.write(" " + String.valueOf(result[i][j]));
                    }
                    bufferWritter.write("\n");
                }
                bufferWritter.close();
                System.out.println("Done");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }