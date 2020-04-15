package gwajae;

public class JavaTest05_10 {
    public static void main(String[] args) {
//  [10] int타입의 변수 num 이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코드를 완성하라. 만일 변수 num의 값이 12345라면,
//  ‘1+2+3+4+5’의 결과인 15를 출력하라. (1)에 알맞은 코드를넣으시오.
//  [주의] 문자열로 변환하지 말고 숫자로만 처리해야 한다.

        int num = 12345;
        int sum = 0;

        sum += (num/10000) + (num/1000%10) + (num/100%10) + (num/10%10) + (num%10);

        System.out.println("First digit = " + num/10000);
        System.out.println("second digit = " + num/1000%10);
        System.out.println("third digit = " + num/100%10);
        System.out.println("fourth digit = " + num/10%10);
        System.out.println("Fifth digit = " + num%10);
        System.out.println("sum="+sum);
    }
}
