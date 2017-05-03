public class Main {

    public static void main(String[] args) {
        //for (int i = 100; i < 3000; i+= 200) new Makerand(i);
        //new Makerand(1000);

        tanxin tx = new tanxin(1000);
        tx.getjihe();
        tx.writetanxin();


        xiangui xg = new xiangui(1000);
        xg.getjihe();
        xg.writetanxin();

    }
}
