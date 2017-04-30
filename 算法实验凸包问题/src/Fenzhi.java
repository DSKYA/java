/**
 * Created by cxj on 17-4-30.
 */
import java.io.*;
import java.util.*;
class Line {//线
    Point p1, p2;
    Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double getLength() {
        double dx = Math.abs(p1.x - p2.x);
        double dy = Math.abs(p1.y - p2.y);
        return Math.sqrt(dx * dx + dy * dy);
    }

}

class Point{//点
    double x;
    double y;

    public Point(double x,double y){
        this.x=x;
        this.y=y;
    }

    public boolean equals(Object st)
    {
        Point temp = (Point) st;
        if (x == temp.x && y == temp.y) return true;
        else return false;
    }
}

public class Fenzhi {
    List<Point> pts = new ArrayList<Point>();//给出的点集
    List<Line> lines = new ArrayList<Line>();//点集pts的凸包
    int n;

    public Fenzhi(int n){
        this.n = n;
        File file = new File("test" + String.valueOf(n) + ".txt");
        BufferedReader reader = null;
        try {
     //       System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
        //        System.out.println("line " + line + ": " + tempString);
                line++;
                String[] tmp = tempString.split(" ");
                Point x = new Point(Double.valueOf(tmp[0]),Double.valueOf(tmp[1]));
                this.pts.add(x);
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

    //求凸包，结果存入lines中
    public void getTubao() {
        lines.clear();
        if (pts != null || !pts.isEmpty()){
            List<Point> ptsLeft = new ArrayList<Point>();//左凸包中的点
            List<Point> ptsRight = new ArrayList<Point>();//右凸包中的点

            //按x坐标对pts排序
            Collections.sort(pts, new Comparator<Point>() {
                public int compare(Point p1, Point p2) {
                    if(p1.x-p2.x>0) return 1;
                    if(p1.x-p2.x<0) return -1;
                    return 0;
                }

            });

            Point p1 = pts.get(0);//最左边的点
            Point p2 = pts.get(pts.size()-1);//最右边的点,用直线p1p2将原凸包分成两个小凸包
            Point p3 = null;
            double area = 0;
            for (int i = 1; i < pts.size() - 1; i++) {//穷举所有的点,
                p3 = pts.get(i);
                area = getArea(p1, p2, p3);//求此三点所成三角形的有向面积
                if (area > 0) {
                    ptsLeft.add(p3);//p3属于左
                } else if (area < 0) {
                    ptsRight.add(p3);//p3属于右
                }
            }
            d(p1, p2, ptsLeft);//分别求解
            d(p2, p1, ptsRight);
        }
    }
    private int d(Point p1, Point p2, List<Point> s) {
        //s集合为空
        if (s.isEmpty()) {
            lines.add(new Line(p1, p2));
            return 0;
        }
        //s集合不为空，寻找Pmax
        double area = 0;
        double maxArea = getArea(p1, p2, s.get(0));
        Point pMax = s.get(0);
        for (int i = 0; i < s.size(); i++) {
            if(!p1.equals(s.get(i)) && !p2.equals(s.get(i))){
                area = getArea(p1, p2, s.get(i));//最大面积对应的点就是Pmax
                if (area > maxArea) {
                    pMax = s.get(i);
                    maxArea = area;
                }
            }
        }
        //找出位于(p1, pMax)直线左边的点集s1
        //找出位于(pMax, p2)直线左边的点集s2
        List<Point> s1 = new ArrayList<Point>();
        List<Point> s2 = new ArrayList<Point>();
        Point p3 = null;
        for (int i = 0; i < s.size(); i++) {
            p3 = s.get(i);
            if(!p1.equals(p3) && !p2.equals(p3)){
                if (getArea(p1, pMax, p3) > 0) {
                    s1.add(p3);
                } else if (getArea(pMax, p2, p3) > 0) {
                    s2.add(p3);
                }
            }
        }
        //递归
        d(p1, pMax, s1);
        d(pMax, p2, s2);
        return 0;
    }
    // 三角形的面积等于返回值绝对值的二分之一
    // 当且仅当点p3位于直线(p1, p2)左侧时，表达式的符号为正
    private double getArea(Point p1, Point p2, Point p3) {
        return p1.x * p2.y + p3.x * p1.y + p2.x * p3.y -
                p3.x * p2.y - p2.x * p1.y - p1.x * p3.y;
    }

    public void writeTubao(){
        HashSet<Point> hs = new HashSet<Point>();
        Iterator iterator1 = lines.iterator();
        while (iterator1.hasNext()) {
            Line temp = (Line) iterator1.next();
            hs.add(temp.p1);
            hs.add(temp.p2);
        }
        Iterator iterator = hs.iterator();
        try {

            String content = "This is the content to write into file";

            File file = new File("fenzhi" + String.valueOf(n) + ".txt");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWritter = new FileWriter(file.getName(),true);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            while (iterator.hasNext()) {
                Point temp = (Point) iterator.next();
                bufferWritter.write(String.valueOf(temp.x + " " + temp.y + "\n"));
            }
            bufferWritter.close();
       //     System.out.println("Done");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
