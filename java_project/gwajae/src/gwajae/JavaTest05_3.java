package gwajae;

public class JavaTest05_3 {
    public static void main(String[] args) {
//        [3] 1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10)의 결과를 계산하시오.

        int sum = 0;
        int j = 0;
        for(int i=1; i<=10; i++){
                j = 1;
            System.out.println("j: " + j);
            for(j=1; j<=i; j++){
                sum += j;
            }
            System.out.println("합계: " + sum);
        }
    }
}
