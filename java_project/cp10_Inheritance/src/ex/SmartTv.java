package ex;

public class SmartTv extends Tv {

    String ch = "YOUTUBE";

    void display(){
        super.display();
        System.out.println(ch + " smart TV를 봅니다.");
    }
}
