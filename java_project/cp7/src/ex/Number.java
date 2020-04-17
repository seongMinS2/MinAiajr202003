package ex;

public class Number {

    int num;

    // 생성자
    Number(){
        System.out.println("생성자 호출");
        num = 1000;
    }

    Number(int n){

        System.out.println("생성자 호출");
        num = n;
    }

    public static void main(String[] args) {

      Number n1 =  new Number();

        System.out.println(n1.num);


      Number n2 =  new Number(50);

        System.out.println(n2.num);
    }
}
