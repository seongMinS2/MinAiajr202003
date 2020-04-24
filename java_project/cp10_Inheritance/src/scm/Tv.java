package scm;

public class Tv extends Product {

    public Tv(int price) {
        super(price);
    }

    @Override
    public String toString() {
        return "Tv";
    }

    void display(){
        System.out.println("Tv를 시청합니다.");
    }

    void programming(){
        System.out.println("프로그램을 만듭니다.");
    }

}
