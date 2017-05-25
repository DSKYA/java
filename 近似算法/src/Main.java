import java.util.Date;

public class Main {

    public static void main(String[] args) {
        //new Makerand(1000);
        //new Makerand(100);
        //new Makerand(1000);
        //new Makerand(5000);

        Date t1;
        Date t2;
        tanxin tx = new tanxin(100);
        t1 = new Date();
        tx.getjihe();
        t2 = new Date();
        System.out.println(String.valueOf(100) + " " + String.valueOf(t2.getTime() - t1.getTime()));
        tx.writetanxin();
        tx = new tanxin(1000);
        t1 = new Date();
        tx.getjihe();
        t2 = new Date();
        System.out.println(String.valueOf(1000) + " " + String.valueOf(t2.getTime() - t1.getTime()));
        tx.writetanxin();
        tx = new tanxin(5000);
        t1 = new Date();
        tx.getjihe();
        t2 = new Date();
        System.out.println(String.valueOf(5000) + " " + String.valueOf(t2.getTime() - t1.getTime()));
        tx.writetanxin();

        xiangui xg = new xiangui(100);
        t1 = new Date();
        xg.getjihe();
        t2 = new Date();
        System.out.println(String.valueOf(100) + " " + String.valueOf(t2.getTime() - t1.getTime()));
        xg.writetanxin();

        xg = new xiangui(1000);
        t1 = new Date();
        xg.getjihe();
        t2 = new Date();
        System.out.println(String.valueOf(1000) + " " + String.valueOf(t2.getTime() - t1.getTime()));
        xg.writetanxin();

        xg = new xiangui(5000);
        t1 = new Date();
        xg.getjihe();
        t2 = new Date();
        System.out.println(String.valueOf(5000) + " " + String.valueOf(t2.getTime() - t1.getTime()));
        xg.writetanxin();

    }
}
