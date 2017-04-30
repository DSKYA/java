import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {



    public static void main(String[] args) {
        System.out.println("Hello World!");
        /*
        for (int i = 1000; i < 16000; i+= 1000){
            new Makerand(i);
        }
        */

        Date t1;
        Date t2;
        for (int i = 1000; i < 16000; i += 1000) {
            /*
            Meiju mj = new Meiju(i);
            t1 = new Date();
            mj.getTubao();
            t2 = new Date();
            //mj.writeTubao();
            System.out.println(String.valueOf(i) + " " + String.valueOf(t2.getTime() - t1.getTime()));//会打印出相差3秒
            */

            Gs gs = new Gs(i);
            t1 = new Date();
            gs.getTubao();
            t2 = new Date();
            //gs.writeTubao();
            System.out.println(String.valueOf(i) + " " + String.valueOf(t2.getTime() - t1.getTime()));

            /*
            Fenzhi fz = new Fenzhi(i);
            t1 = new Date();
            fz.getTubao();
            t2 = new Date();
            //fz.writeTubao();
            System.out.println(String.valueOf(i) + " " + String.valueOf(t2.getTime() - t1.getTime()));

            /*
            Gs gs = new Gs(i);
            gs.getTubao();
            gs.writeTubao();
            Fenzhi fz = new Fenzhi(i);
            fz.getTubao();
            fz.writeTubao();
            */
        }
    }
}
