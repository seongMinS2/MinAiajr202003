package tv;

public class TvMain2 {
    public static void main(String[] args) {

        Tv tv1 = new Tv();
        Tv tv2 = new Tv();

        System.out.println(tv1==tv2);

        System.out.println("======================");

        tv1.channel = 10;
        System.out.println("Tv1의 cannel값을 10으로 변경");

        System.out.println("Tv1의 channel: " + tv1.channel);
        System.out.println("Tv2의 channel: " + tv2.channel);

    }
}
