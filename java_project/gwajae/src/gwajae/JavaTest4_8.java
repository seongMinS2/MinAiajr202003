package gwajae;

public class JavaTest4_8 {
    public static void main(String[] args) {
//        1000 이하의 자연수 중에서 2의 배수 이면서 7의 배수인 숫자를 출력하고, 그 출력된 숫자들의 합을 구하는 프로그램을 while 문을 이용해서 작성

        int i = 1;
        int sum = 0;

        while(i<=1000){
            i++;
            if (i%2!=0 | i%7!=0)
                continue;
            System.out.println(i);

            sum += i;
        }
        System.out.println(sum);

    }
}
