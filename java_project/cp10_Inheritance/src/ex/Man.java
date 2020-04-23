package ex;

public class Man {

    String name;
    String company;
    String position;

    Man(String name){
        this.name = name;
    }
    Man(String name, String company, String position){
        this.name = name;
        this.company = company;
        this.position = position;
    }

    void tellYourName(){
        System.out.println("나의 이름은 " + name + "입니다.");
    }
}
