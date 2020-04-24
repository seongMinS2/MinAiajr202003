package scm;

public class Computer extends  Product {

    public Computer(int price) {
        super(price);
    }

    void programming(){
        System.out.println("컴퓨터를 합니다.");
    }

    @Override
    public String toString() {
        return "Computer{}";
    }
}
