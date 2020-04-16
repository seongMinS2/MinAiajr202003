package gwajae_object;

public class CalcMain {
    public static void main(String[] args) {

        Calc calc = new Calc();

        int num1 =550;
        int num2 =30;

        System.out.println("덧셈결과: " + calc.add(num1,num2));
        System.out.println("뺄셈결과: " + calc.sub(num1,num2));
        System.out.println("곱셈결과: " + calc.multi(num1,num2));
        System.out.println("나눗셈결과: " + calc.div(num1,num2));
        System.out.println("나눈 나머지값: " + calc.remainder);
    }
}
