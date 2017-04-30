public class Main {



    public static void main(String[] args) {
        System.out.println("Hello World!");
        /*
        for (int i = 1000; i < 16000; i+= 1000){
            new Makerand(i);
        }
        */
        for (int i = 1000; i < 16000; i+= 1000) {
            Meiju mj = new Meiju(i);
            mj.getTubao();
            mj.writeTubao();

            Gs gs = new Gs(i);
            gs.getTubao();
            gs.writeTubao();
            Fenzhi fz = new Fenzhi(i);
            fz.getTubao();
            fz.writeTubao();
        }
    }
}
