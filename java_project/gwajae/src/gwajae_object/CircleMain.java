package gwajae_object;

public class CircleMain {
    public static void main(String[] args) {
        Circle cir = new Circle();

        int r = 30;

        System.out.println("원의 둘레: " + cir.circumference(r));
        System.out.println("원의 넓이: " + cir.cirArea(r));
    }
}
